package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan_android.R;

public class MainActivity extends AppCompatActivity {

    //thoi gian chuyen man hinh gioi thieu
    private static int SPLASH_TIME_OUT = 3000;

    Animation topAmin, bottomAmin;
    ImageView image;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        //Animation
        topAmin = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAmin = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView1);

        image.setAnimation(topAmin);
        textView1.setAnimation(bottomAmin);
        textView2.setAnimation(bottomAmin);
    }
}