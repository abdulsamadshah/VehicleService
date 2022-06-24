package com.example.vehicleservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.vehicleservice.bottomnavigationbar.bookingsFragment;
import com.example.vehicleservice.bottomnavigationbar.homeFragment;
import com.example.vehicleservice.bottomnavigationbar.profileFragment;
import com.example.vehicleservice.bottomnavigationbar.rewardsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboardActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        bottomnavigation=findViewById(R.id.bottomnavigation);

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new homeFragment());
        transaction.commit();

        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        fragmentTransaction.replace(R.id.container,new homeFragment());
                        break;

                    case R.id.booking:
                        fragmentTransaction.replace(R.id.container,new bookingsFragment());
                        break;

                    case R.id.rewards:
                        fragmentTransaction.replace(R.id.container,new rewardsFragment());
                        break;

                    case R.id.profiledata:
                        fragmentTransaction.replace(R.id.container,new profileFragment());
                        break;

                }
                fragmentTransaction.commit();
                return true;
            }
        });
    }
}