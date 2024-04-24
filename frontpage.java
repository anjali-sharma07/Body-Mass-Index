package com.example.bmiapp;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bmiapp.R;
import android.os.Handler;
import android.content.Intent;


    public class frontpage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.front);

            LottieAnimationView frontId;
            frontId = findViewById(R.id.frontId);
            frontId.setAnimation(R.raw.bmi_front);
            frontId.playAnimation();
            frontId.loop(true);

            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent next = new Intent(frontpage.this , MainActivity.class);
                    startActivity(next);
                    finish();
                }
            },4000);
        }
    }
