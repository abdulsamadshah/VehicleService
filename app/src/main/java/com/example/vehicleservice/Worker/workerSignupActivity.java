package com.example.vehicleservice.Worker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicleservice.MainActivity;
import com.example.vehicleservice.R;
import com.example.vehicleservice.SignupActivity;
import com.example.vehicleservice.dashboardActivity;
import com.example.vehicleservice.users;
import com.example.vehicleservice.vehicleDetailActivity;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class workerSignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    LinearLayout state;
    TextView stateyname;
    CircleImageView wprofile;
    EditText wusername, wuseremail, wAddress;
    Button wsignup;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseStorage storage;
    Uri imageuri;
    String IMAGEURI;
    String[] statenamessdata = {"Andaman and Nicobar (UT)", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh ", "Chhattisgarh", "Dadra and Nagar Haveli (UT)", "Daman and Diu (UT)", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Ladakh", "Lakshadweep ", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Puducherry (UT)", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_signup);
        getSupportActionBar().hide();
        stateyname = findViewById(R.id.stateyname);
        wusername = findViewById(R.id.wusername);
        wuseremail = findViewById(R.id.wuseremail);
        wAddress = findViewById(R.id.wAddress);
        wsignup = findViewById(R.id.wsignup);
        wprofile = findViewById(R.id.wprofile);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();


        Spinner spinnerdata = (Spinner) findViewById(R.id.statespinner);
        spinnerdata.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapters = new ArrayAdapter(this, android.R.layout.simple_spinner_item, statenamessdata);
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerdata.setAdapter(adapters);

        wprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 5);
            }
        });


        wsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wusernames = wusername.getText().toString();
                String wuseremails = wuseremail.getText().toString();
                String shopaddress = wAddress.getText().toString();
                String statename = stateyname.getText().toString();

                auth.createUserWithEmailAndPassword(wuseremails, wusernames).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            DatabaseReference reference = database.getReference().child("worker").child(auth.getUid());
                            StorageReference storageReference = storage.getReference().child("worker").child(auth.getUid());

                            if (imageuri != null) {
                                storageReference.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                                        if (task.isSuccessful()) {

                                            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                    IMAGEURI = uri.toString();
                                                    workerUsers userworker = new workerUsers(wusernames, wuseremails, shopaddress, statename, IMAGEURI);
                                                    reference.setValue(userworker).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Intent intent = new Intent(workerSignupActivity.this, dashboardActivity.class);
                                                                startActivity(intent);
                                                                Toast.makeText(workerSignupActivity.this, "user created succesfully", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(workerSignupActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    }
                                });
                            } else {
                                IMAGEURI = "https://firebasestorage.googleapis.com/v0/b/fir-retreivedata.appspot.com/o/avatar.png?alt=media&token=14a4879f-1697-41fb-903f-c681d8d515b4";
                                workerUsers userworker = new workerUsers(wusernames, wuseremails, shopaddress, statename, IMAGEURI);
                                reference.setValue(userworker).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(workerSignupActivity.this, dashboardActivity.class);
                                            startActivity(intent);
                                            Toast.makeText(workerSignupActivity.this, "user created succesfully", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(workerSignupActivity.this, "something wrong", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }

                            Toast.makeText(workerSignupActivity.this, "user created succesfully", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(workerSignupActivity.this, "something wrong users", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            imageuri = data.getData();
            wprofile.setImageURI(imageuri);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            stateyname.setText(statenamessdata[position]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}