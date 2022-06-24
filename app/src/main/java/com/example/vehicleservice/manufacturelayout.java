package com.example.vehicleservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class manufacturelayout extends ListActivity {
String[]manufacturedata={"Hero ","Honda ","TVS ","Bajaj ","Yamaha ","Royal Enfield","Suzuki ","Piaggio ","Mahindra ","UM Lohia "};
//    String[]manufacturedata={"Hero ","Hero Glamour ","Hero HF Deluxe BS6","Hero Karizma ZMR","Hero Maestro Edge","Hero Passion","Hero Pleasure","Hero Passion X Pro",      "Honda","Honda Livo","Honda Activita i","Honda Dio","Honda CBR 300","Honda hornet 200","","","",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_manufacturelayout);

        //this top app color change
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.gray));
        }


        ListAdapter listAdapter=new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,manufacturedata);
        setListAdapter(listAdapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position==0){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==1){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==2){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==3){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==4){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==5){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==6){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==7){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==8){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==9){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }else if (position==10){
            Intent intent=new Intent(getApplicationContext(),vehicleDetailActivity.class);
            intent.putExtra("manufacturenames",manufacturedata[position]);
            startActivity(intent);
        }
    }
}