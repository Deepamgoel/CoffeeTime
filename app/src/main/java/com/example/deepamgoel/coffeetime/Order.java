package com.example.deepamgoel.coffeetime;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Order extends AppCompatActivity {


    String message;
    private int noOfCoffees = 1, pricePerCoffee = 30, totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void submitOrder(View view) {
        EditText name = findViewById(R.id.name);
        Button orderSummary = findViewById(R.id.order_summary);
        Button confirm = findViewById(R.id.confirm);

        confirm.setVisibility(View.VISIBLE);
        name.setVisibility(View.GONE);
        orderSummary.setVisibility(View.INVISIBLE);

        displaySummary(noOfCoffees);
    }

    public void inc(View View) {

        //      Name
        EditText name = findViewById(R.id.name);

        //      Buttons
        Button orderSummary = findViewById(R.id.order_summary);
        Button confirm = findViewById(R.id.confirm);

        if (noOfCoffees >= 15) {
            noOfCoffees = 14;
            Toast.makeText(this, "Maximum Order: 2 Cups", Toast.LENGTH_SHORT).show();
        }

        confirm.setVisibility(android.view.View.INVISIBLE);
        name.setVisibility(android.view.View.VISIBLE);
        orderSummary.setVisibility(android.view.View.VISIBLE);
        display(++noOfCoffees);
    }

    public void dec(View View) {

        //      Name
        EditText name = findViewById(R.id.name);

        //      Buttons
        Button orderSummary = findViewById(R.id.order_summary);
        Button confirm = findViewById(R.id.confirm);

        if (noOfCoffees <= 1) {
            noOfCoffees = 2;
            Toast.makeText(this, "Minimum Order: 1 Cup", Toast.LENGTH_SHORT).show();
        }

        confirm.setVisibility(android.view.View.INVISIBLE);
        name.setVisibility(android.view.View.VISIBLE);
        orderSummary.setVisibility(android.view.View.VISIBLE);
        display(--noOfCoffees);
    }


    public void whipped(View view) {

        //      Name
        EditText name = findViewById(R.id.name);

        //      Buttons
        Button orderSummary = findViewById(R.id.order_summary);
        Button confirm = findViewById(R.id.confirm);

        confirm.setVisibility(android.view.View.INVISIBLE);
        name.setVisibility(android.view.View.VISIBLE);
        orderSummary.setVisibility(android.view.View.VISIBLE);
        display(noOfCoffees);
    }


    public void chocolate(View view) {


        //      Name
        EditText name = findViewById(R.id.name);

        //      Buttons
        Button orderSummary = findViewById(R.id.order_summary);
        Button confirm = findViewById(R.id.confirm);

        confirm.setVisibility(android.view.View.INVISIBLE);
        name.setVisibility(android.view.View.VISIBLE);
        orderSummary.setVisibility(android.view.View.VISIBLE);
        display(noOfCoffees);
    }


    private void display(int noOfCoffees) {

        //      TextViews
        TextView priceSummaryTextView = findViewById(R.id.price);
        TextView priceText = findViewById(R.id.priceText);
        TextView quantity = findViewById(R.id.qty);

        //      CheckBox
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);


        priceText.setText(R.string.priceText);

        quantity.setText(String.format(Locale.getDefault(), "%d", noOfCoffees));

        totalPrice = noOfCoffees * pricePerCoffee;

        if (whippedCream.isChecked()) {
            totalPrice += (15 * noOfCoffees);
        }

        if (chocolate.isChecked()) {
            totalPrice += (15 * noOfCoffees);
        }

        priceSummaryTextView.setText(String.format(Locale.getDefault(), "₹%d", totalPrice));
    }


    private void displaySummary(int noOfCoffees) {


        //      Name
        EditText name = findViewById(R.id.name);

        //      TextViews
        TextView priceSummaryTextView = findViewById(R.id.price);
        TextView priceText = findViewById(R.id.priceText);

        //      CheckBox
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);


        totalPrice = noOfCoffees * pricePerCoffee;

        message = "Name: " + name.getText().toString();
        message += "\nQuantity: " + noOfCoffees;
        message += "\nWhipped Cream: ";

        if (whippedCream.isChecked()) {
            totalPrice += (15 * noOfCoffees);
            message += "Yes";
        } else
            message += "No";

        message += "\nChocolate:";

        if (chocolate.isChecked()) {
            totalPrice += (15 * noOfCoffees);
            message += "Yes";
        } else
            message += "No";


        message += "\nPrice: ₹" + totalPrice;
        message += "\nThank You";

        priceText.setText(R.string.summary);
        priceSummaryTextView.setTextSize(30);
        priceSummaryTextView.setText(message);
    }

    public void confirm(View view) {

        Handler delay = new Handler();
        delay.postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent send = new Intent(Intent.ACTION_SENDTO);
                send.setData(Uri.parse("mailto:"));
                send.putExtra(Intent.EXTRA_TEXT, message);
                send.putExtra(Intent.EXTRA_EMAIL, "deepamgoel4@gmail.com");
                send.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");
                startActivity(send);
                finish();
            }

        }, 2500);

        pl.droidsonroids.gif.GifImageView yess = findViewById(R.id.yess);
        yess.setVisibility(View.VISIBLE);

    }




}
