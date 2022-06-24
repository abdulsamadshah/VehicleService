package com.example.vehicleservice.bottomnavigationbar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.vehicleservice.R;
import com.example.vehicleservice.userProfileActivity;

public class profileFragment extends Fragment {
LinearLayout userprofile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        userprofile=view.findViewById(R.id.userprofile);
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), userProfileActivity.class);
                startActivity(intent);
            }
        });


        return view ;
    }

}