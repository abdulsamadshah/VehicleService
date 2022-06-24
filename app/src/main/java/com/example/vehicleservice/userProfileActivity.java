package com.example.vehicleservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userProfileActivity extends AppCompatActivity {
FirebaseAuth auth;
FirebaseDatabase database;
EditText username,phonenumbers,emailid,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getSupportActionBar().hide();
        idbingding();
        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();


        //this top app color change
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }

        DatabaseReference reference=database.getReference().child("User").child(auth.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String names=snapshot.child("name").getValue(String.class);
                String emails=snapshot.child("email").getValue(String.class);
                String countrynamess=snapshot.child("countryname").getValue(String.class);
                String mobilenumber=snapshot.child("MobileNumber").getValue(String.class);



                username.setText(names);
                emailid.setText(emails);
                city.setText(countrynamess);
                phonenumbers.setText(mobilenumber);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void idbingding() {
        username=findViewById(R.id.username);
        phonenumbers=findViewById(R.id.phonenumbers);
        emailid=findViewById(R.id.emailid);
        city=findViewById(R.id.city);
    }
}