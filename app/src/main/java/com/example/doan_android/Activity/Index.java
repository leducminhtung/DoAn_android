package com.example.doan_android.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.doan_android.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_Home()).commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.menuHome:
                            selectedFragment = new Fragment_Home();
                            break;
                        case R.id.menuAccount:
                            selectedFragment = new Fragment_Account();
                            break;
                        case R.id.menuHistory:
                            selectedFragment = new Fragment_History();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


    public void GoToBooking(View view) {
        Intent intent = new Intent(Index.this, Booking.class);
        startActivity(intent);
    }

    public void GoToChangePass(View view) {
        Intent intent = new Intent(Index.this, Change_Password.class);
        startActivity(intent);
    }
}