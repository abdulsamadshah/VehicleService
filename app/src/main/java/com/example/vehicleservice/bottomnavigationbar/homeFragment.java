package com.example.vehicleservice.bottomnavigationbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicleservice.BikeServicingActivity;
import com.example.vehicleservice.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class homeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FirebaseDatabase database;
    FirebaseAuth auth;
    TextView cityname;
    LinearLayout bikeservincing;
    String[] citydata = {"Mumbai", "Pune", "Nagpur", "Thane", "Pimpri-Chinchwad", "Nashik", "Kalyan-Dombivli", "Vasai-Virar City MC", "Aurangabad", "Navi Mumbai", "Solapur", "Mira-Bhayandar", "Bhiwandi-Nizampur MC", "Jalgaon", "Amravati", "Nanded Waghala", "Kolhapur", "Ulhasnagar", "\tSangli-Miraj-Kupwad", "PHP", "HTML", "CSS", "JAVA", "PHP", "HTML", "CSS", "JAVA", "PHP", "HTML", "CSS", "JAVA", "PHP"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        cityname = view.findViewById(R.id.cityname);
        bikeservincing = view.findViewById(R.id.bikeservincing);

        Spinner cityspinner = (Spinner) view.findViewById(R.id.cityspinner);
        cityspinner.setOnItemSelectedListener(this);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, citydata);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        cityspinner.setAdapter(adapter);

        DatabaseReference reference = database.getReference().child("User").child(auth.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String countrynamess = snapshot.child("countryname").getValue(String.class);
                cityname.setText(countrynamess);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });


        bikeservincing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BikeServicingActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            cityname.setText(citydata[position]);
        } else if (position == 1) {
            cityname.setText(citydata[position]);
        }else if (position == 2) {
            cityname.setText(citydata[position]);
        }else if (position == 3) {
            cityname.setText(citydata[position]);
        }else if (position == 4) {
            cityname.setText(citydata[position]);
        }else if (position == 5) {
            cityname.setText(citydata[position]);
        }else if (position == 6) {
            cityname.setText(citydata[position]);
        }else if (position == 7) {
            cityname.setText(citydata[position]);
        }else if (position == 8) {
            cityname.setText(citydata[position]);
        }else if (position == 9) {
            cityname.setText(citydata[position]);
        }else if (position == 10) {
            cityname.setText(citydata[position]);
        }else if (position == 11) {
            cityname.setText(citydata[position]);
        }else if (position == 12) {
            cityname.setText(citydata[position]);
        }else if (position == 13) {
            cityname.setText(citydata[position]);
        }else if (position == 14) {
            cityname.setText(citydata[position]);
        }else if (position == 15) {
            cityname.setText(citydata[position]);
        }else if (position == 16) {
            cityname.setText(citydata[position]);
        }else if (position == 17) {
            cityname.setText(citydata[position]);
        }else if (position == 18) {
            cityname.setText(citydata[position]);
        }else if (position == 19) {
            cityname.setText(citydata[position]);
        }else if (position == 20) {
            cityname.setText(citydata[position]);
        }else if (position == 21) {
            cityname.setText(citydata[position]);
        }else if (position == 22) {
            cityname.setText(citydata[position]);
        }else if (position == 23) {
            cityname.setText(citydata[position]);
        }else if (position == 24) {
            cityname.setText(citydata[position]);
        }else if (position == 25) {
            cityname.setText(citydata[position]);
        }else if (position == 26) {
            cityname.setText(citydata[position]);
        }else if (position == 27) {
            cityname.setText(citydata[position]);
        }else if (position == 28) {
            cityname.setText(citydata[position]);
        }else if (position == 29) {
            cityname.setText(citydata[position]);
        }else if (position == 30) {
            cityname.setText(citydata[position]);
        }else if (position == 31) {
            cityname.setText(citydata[position]);
        }else if (position == 32) {
            cityname.setText(citydata[position]);
        }else if (position == 33) {
            cityname.setText(citydata[position]);
        }else if (position == 34) {
            cityname.setText(citydata[position]);
        }else if (position == 35) {
            cityname.setText(citydata[position]);
        }else if (position == 36) {
            cityname.setText(citydata[position]);
        }else if (position == 37) {
            cityname.setText(citydata[position]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}