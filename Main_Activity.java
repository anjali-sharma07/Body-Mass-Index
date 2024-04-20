package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.LinearLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtwgt, edtft, edtinch;
        Button btn;
        TextView result0, result1;
        LinearLayout llMain;

        edtwgt = findViewById(R.id.edtwgt);
        edtft = findViewById(R.id.edtft);
        edtinch = findViewById(R.id.edtinch);
        btn = findViewById(R.id.btn);
        result0 = findViewById(R.id.result0);
        result1 = findViewById(R.id.result1);
        llMain = findViewById(R.id.llMain);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int wgt = Integer.parseInt(edtwgt.getText().toString());
                int ft = Integer.parseInt(edtft.getText().toString());
                int inch = Integer.parseInt(edtinch.getText().toString());
                double met = (ft*0.305+inch*0.0254);
                double bmi = wgt/(met*met);
                DecimalFormat decimal = new DecimalFormat("0.00");
                String formatted = decimal.format(bmi);
                result0.setText(formatted);

                if(bmi<18.5){
                    result1.setText("You're Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }else if(bmi>=18.5 && bmi<=24.9){
                    result1.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }else if(bmi>=25 && bmi<=29.9){
                    result1.setText("You're Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    result1.setText("You're Obese");
                llMain.setBackgroundColor(getResources().getColor(R.color.red));
            }}
        });

    }
}
