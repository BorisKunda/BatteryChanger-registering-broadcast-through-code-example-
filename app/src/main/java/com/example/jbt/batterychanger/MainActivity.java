package com.example.jbt.batterychanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyBatteryReciver reciver= new MyBatteryReciver();
        IntentFilter intentFilter= new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //IntentFilter myPhoneFilter= new IntentFilter("android.intent.action.PHONE_STATE");--> same thing
        registerReceiver(reciver,intentFilter);
 
    }



    public  class MyBatteryReciver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

            LinearLayout mainLayout= (LinearLayout) findViewById(R.id.mainLayout);
            if(level<85 && level>15)
            {
                //set darker screen

                mainLayout.setBackgroundColor(Color.parseColor("#f1f1f1"));

            }
            else if(level<15)
            {
                mainLayout.setBackgroundColor(Color.parseColor("#515151"));
            }
            else if(level>85)
            {
                mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }


            //Toast.makeText(context, "battery changed level:"+level, Toast.LENGTH_SHORT).show();
        }
    }



}
