package com.example.vehicleservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView imageView;
    EditText useremail, username;
    TextView countryname;
    FirebaseAuth auth;
    Button signup;
    FirebaseDatabase database;

    String[] country = {"Maharashtra", "Chennai", "Mumbai", "Karnatka", "UttarPradesh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        getSupportActionBar().setTitle("SignUpActivity");
        getSupportActionBar().hide();

        //this top app color change
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }

        database = FirebaseDatabase.getInstance();

        allidbinding();
//
//        if (auth.getCurrentUser() != null) {
//            Intent intent = new Intent(getApplicationContext(), dashboardActivity.class);
//            startActivity(intent);
//        }

        String url = "https://previews.123rf.com/images/sundatoon/sundatoon1410/sundatoon141000025/33039083-mec%C3%A1nico-con-service-list.jpg";

        Picasso.get().load(url)
                .fit()
                .centerCrop()
                .into(imageView);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(adapter);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String email = useremail.getText().toString();
                String countrynames = countryname.getText().toString();

                auth.createUserWithEmailAndPassword(email, name).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            DatabaseReference reference = database.getReference().child("User").child(auth.getUid());
                            users userss = new users(name, email, countrynames);

                            reference.setValue(userss).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), vehicleDetailActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignupActivity.this, "error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(SignupActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

    }

    private void allidbinding() {
        signup = findViewById(R.id.signup);
        auth = FirebaseAuth.getInstance();
        countryname = findViewById(R.id.countryname);
        useremail = findViewById(R.id.useremail);
        imageView = findViewById(R.id.imageView);
        username = findViewById(R.id.username);


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
        if (position == 0) {
            countryname.setText(country[position]);
        } else if (position == 1) {
            countryname.setText(country[position]);
        } else if (position == 2) {
            countryname.setText(country[position]);
        } else if (position == 3) {
            countryname.setText(country[position]);
        } else if (position == 4) {
            countryname.setText(country[position]);
        } else if (position == 5) {
            countryname.setText(country[position]);
        } else if (position == 6) {
            countryname.setText(country[position]);
        } else if (position == 7) {
            countryname.setText(country[position]);
        } else if (position == 8) {
            countryname.setText(country[position]);
        } else if (position == 9) {
            countryname.setText(country[position]);
        } else if (position == 10) {
            countryname.setText(country[position]);
        } else if (position == 11) {
            countryname.setText(country[position]);
        } else if (position == 12) {
            countryname.setText(country[position]);
        } else if (position == 13) {
            countryname.setText(country[position]);
        } else if (position == 14) {
            countryname.setText(country[position]);
        } else if (position == 15) {
            countryname.setText(country[position]);
        } else if (position == 16) {
            countryname.setText(country[position]);
        } else if (position == 17) {
            countryname.setText(country[position]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}