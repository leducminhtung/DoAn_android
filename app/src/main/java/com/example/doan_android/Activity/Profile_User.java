package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.doan_android.R;

public class Profile_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
    }


    public void GoToChangePass(View view) {
        Intent intent = new Intent(Profile_User.this, Change_Password.class);
        startActivity(intent);
    }
}