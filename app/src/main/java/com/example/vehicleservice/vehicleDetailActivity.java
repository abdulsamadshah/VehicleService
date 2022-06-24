package com.example.vehicleservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class vehicleDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    LinearLayout manufacture, model, petrolLayout, deisellayout;
    public static TextView manufacturename, petrol, deisel, skip;
    public static TextView modelname;
    Button register;
    LinearLayout bike,car;
    FirebaseDatabase database;
    EditText registerationN;

    String[]modeldatas={"Hero Glamour ","Hero HF Deluxe BS6","Hero Karizma ZMR","Hero Maestro Edge","Hero Passion","Hero Pleasure","Hero Passion X Pro","Hero Splendor Plus","Hero HF Deluxe","Hero Passion Pro"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        getSupportActionBar().hide();
        manufacture = findViewById(R.id.manufacture);
        modelname = findViewById(R.id.modelname);
        manufacturename = findViewById(R.id.manufacturename);
        model = findViewById(R.id.model);
        petrolLayout = findViewById(R.id.petrolLayout);
        petrol = findViewById(R.id.petrol);
        deisellayout = findViewById(R.id.deisellayout);
        deisel = findViewById(R.id.deisel);
        skip = findViewById(R.id.skip);
        register = findViewById(R.id.register);
        bike=findViewById(R.id.bike);
        car=findViewById(R.id.car);
        registerationN=findViewById(R.id.registerationN);
        database=FirebaseDatabase.getInstance();

        //this top app color change
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }

        String manufacturedata = getIntent().getStringExtra("manufacturenames");
        manufacturename.setText(manufacturedata);

        String modeldata = getIntent().getStringExtra("modelname");
        modelname.setText(modeldata);
        modelname.getText().toString();

        manufacture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), manufacturelayout.class);
                startActivity(intent);


            }
        });



        deisellayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deisellayout.setBackgroundColor(R.drawable.petrolanddiesel);
                if (deisellayout.isSelected()){
                    deisellayout.setBackgroundColor(R.drawable.petrolanddiesel);
                }else{
                    petrolLayout.setBackgroundColor(Color.WHITE);
                }

            }
        });

        petrolLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                petrolLayout.setBackgroundColor(R.drawable.petrolanddiesel);
                if (petrolLayout.isSelected()){
                    petrolLayout.setBackgroundColor(R.drawable.petrolanddiesel);
                }else{
                    deisellayout.setBackgroundColor(Color.WHITE);
                }

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vehicleDetailActivity.this, dashboardActivity.class);
                startActivity(intent);
            }
        });



        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bike.setBackgroundColor(R.drawable.bikedesigncolor);
                if (bike.isSelected()){
                    bike.setBackgroundColor(R.drawable.bikedesigncolor);
                }else{
                   car.setBackgroundColor(Color.WHITE);
                }
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car.setBackgroundColor(R.drawable.bikedesigncolor);
                if (car.isSelected()){
                    car.setBackgroundColor(R.drawable.bikedesigncolor);
                }else{
                    bike.setBackgroundColor(Color.WHITE);
                }
            }
        });

        DatabaseReference reference=database.getReference().child("VehicleData");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manufacturenames=manufacturename.getText().toString();
                String modelnames=modelname.getText().toString();
                String petroldata=petrol.getText().toString();
                String deiseldata=deisel.getText().toString();
                String registerationNumber=registerationN.getText().toString();

                HashMap<String,String>vehicled=new HashMap<>();
                vehicled.put("ManuFactureName",manufacturenames);
                vehicled.put("Modelname",modelnames);
                vehicled.put("Petrol",petroldata);
                vehicled.put("Registeration No",registerationNumber);

                reference.push().setValue(vehicled).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(getApplicationContext(),dashboardActivity.class);
                            startActivity(intent);
                        }
                    }
                });



            }
        });




        Spinner modelspin = (Spinner) findViewById(R.id.modelspinner);
        modelspin.setOnItemSelectedListener(vehicleDetailActivity.this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, modeldatas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        modelspin.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            modelname.setText(modeldatas[position]);
        } else if (position == 1) {
            modelname.setText(modeldatas[position]);
        } else if (position == 2) {
            modelname.setText(modeldatas[position]);
        } else if (position == 3) {
            modelname.setText(modeldatas[position]);
        } else if (position == 4) {
            modelname.setText(modeldatas[position]);
        } else if (position == 5) {
            modelname.setText(modeldatas[position]);
        } else if (position == 6) {
            modelname.setText(modeldatas[position]);
        } else if (position == 7) {
            modelname.setText(modeldatas[position]);
        } else if (position == 8) {
            modelname.setText(modeldatas[position]);
        } else if (position == 9) {
            modelname.setText(modeldatas[position]);
        } else if (position == 10) {
            modelname.setText(modeldatas[position]);
        } else if (position == 11) {
            modelname.setText(modeldatas[position]);
        } else if (position == 12) {
            modelname.setText(modeldatas[position]);
        } else if (position == 13) {
            modelname.setText(modeldatas[position]);
        } else if (position == 14) {
            modelname.setText(modeldatas[position]);
        } else if (position == 15) {
            modelname.setText(modeldatas[position]);
        } else if (position == 16) {
            modelname.setText(modeldatas[position]);
        } else if (position == 17) {
            modelname.setText(modeldatas[position]);
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}