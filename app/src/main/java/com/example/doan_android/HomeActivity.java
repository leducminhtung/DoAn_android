package com.example.doan_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class HomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void GoToLogin(View view) {
        Intent intent = new Intent(HomeActivity.this,Login.class);
        startActivity(intent);
    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(HomeActivity.this,RegisterUser.class);
        startActivity(intent);
    }


}