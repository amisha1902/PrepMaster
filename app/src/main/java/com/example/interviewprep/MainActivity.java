package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
     LottieAnimationView laView;
     TextView prepmaster;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepmaster= findViewById(R.id.PrepMaster);
        laView= findViewById(R.id.anim1);
//        laView.setAnimation(R.raw.animation1);
//        laView.playAnimation();
//        laView.loop(true);
        prepmaster.animate().translationY(-1000).setDuration(2500).setStartDelay(50);
        laView.animate().translationX(2000).setDuration(2000).setStartDelay(5000);
        laView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), IntroductionActivity.class);
                startActivity(i);
            }
        },5000);

        }
    }
