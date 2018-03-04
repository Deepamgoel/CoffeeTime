package com.example.deepamgoel.coffeetime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void order(View view) {
        Intent openOtherActivity = new Intent(this, Order.class);
        startActivity(openOtherActivity);
    }


}
