package com.example.doan_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper v_flipper, v_flipper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int images[] = {R.drawable.quangcao1, R.drawable.quangcao2, R.drawable.quangcao3,
                        R.drawable.quangcao4, R.drawable.quangcao5, R.drawable.quangcao6};

        int images1[] = {R.drawable.new1, R.drawable.new2, R.drawable.new3};

        v_flipper = findViewById(R.id.v_flipper);
        v_flipper1 = findViewById(R.id.v_flipper1);

        //vong lap
        for( int image: images){
            flipperImages(image);
        }

        for(int image: images1){
            flipperImages1(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4900);//4 giay chuyen qua hinh moi
        v_flipper.setAutoStart(true);



        //animation
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void flipperImages1(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper1.addView(imageView);
        v_flipper1.setFlipInterval(4000);//4 giay chuyen qua hinh moi
        v_flipper1.setAutoStart(true);



        //animation
        v_flipper1.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper1.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void GoToLogin(View view) {
        Intent intent = new Intent(HomeActivity.this,Login.class);
        startActivity(intent);
    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(HomeActivity.this,RegisterUser.class);
        startActivity(intent);
    }

    public void GoToHomeidex(View view) {
        Intent intent = new Intent(HomeActivity.this,index.class);
        startActivity(intent);
    }

}