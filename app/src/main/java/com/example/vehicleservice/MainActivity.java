package com.example.vehicleservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView phonenumbertitle;
    LinearLayout phonetitle;
    EditText mobilenumbers;
    Button register;
    FirebaseAuth auth;
    CountryCodePicker ccp;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        database = FirebaseDatabase.getInstance();
        //this top app color change
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }
        auth = FirebaseAuth.getInstance();
        phonetitle = findViewById(R.id.phonetitle);
        mobilenumbers = findViewById(R.id.mobilenumbers);
        phonenumbertitle = findViewById(R.id.phonenumbertitle);
        register = findViewById(R.id.register);

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(mobilenumbers);

        mobilenumbers.setHint("Enter your Number");
        mobilenumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobilenumbers.setHint("");
                phonenumbertitle.setText("Enter Phone Number");


            }
        });


        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), dashboardActivity.class);
            startActivity(intent);
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = database.getReference().child("User");
                String mobilenumberdata = mobilenumbers.getText().toString();

                HashMap<String, String> vehicled = new HashMap<>();
                vehicled.put("MobileNumber", mobilenumberdata);


                reference.push().setValue(vehicled);

                Intent intent = new Intent(MainActivity.this, dataverifyActivity.class);
                intent.putExtra("mnumber", ccp.getFullNumberWithPlus().replace(" ", ""));
                startActivity(intent);
            }
        });


    }
}