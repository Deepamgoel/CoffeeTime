package com.example.deepamgoel.coffeetime;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler delay = new Handler();
        delay.postDelayed(new Runnable() {


            @Override
            public void run() {
                delay();
                finish();
            }

        }, 10000);

    }

    public void delay() {
        final Intent openOtherActivity = new Intent(this, Order.class);
        startActivity(openOtherActivity);
    }
}
