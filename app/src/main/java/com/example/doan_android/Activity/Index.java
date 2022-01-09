package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_android.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import InterfaceReponsitory.Methods;
import Model.CallbackResultModel;
import Model.KhachHangModel;
import Model.KhachInsertModel;
import Model.TaiKhoanInsertModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index extends AppCompatActivity {

    ListView lv_history;
    TextView txtCustomUserName,txtIndex_UserName;
    TextInputEditText txtCustomerFullName,txtCustomerEmail,txtCustomerPhone,txtCustomerCCCD,txtCustomerBD,txtCustomerGioiTinh,txtCustomerFirstName;


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

    public void GetViewId(){


        txtCustomUserName =findViewById(R.id.txtCustomUserName);

        txtCustomerFullName =findViewById(R.id.txtCustomerFullName);
        txtCustomerEmail =findViewById(R.id.txtCustomerEmail);
        txtCustomerPhone=findViewById(R.id.txtCustomerPhone);
        txtCustomerCCCD=findViewById(R.id.txtCustomerCCCD);
        txtCustomerBD =findViewById(R.id.txtCustomerBD);
        txtCustomerGioiTinh=findViewById(R.id.txtCustomerGioiTinh);
        txtCustomerFirstName=findViewById(R.id.txtCustomerFirstName);
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
                        case R.id.menuSetting:
                            selectedFragment = new SettingsActivity.SettingsFragment();
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

    public void GoToTest(View view) {
        Intent intent = new Intent(Index.this, Test.class);
        startActivity(intent);
    }

    public void Update(View view) {
        GetViewId();
        KhachInsertModel khach = new KhachInsertModel();

        khach.setGioiTinh(txtCustomerGioiTinh.getText().toString());
        khach.setCCCD(txtCustomerCCCD.getText().toString());
        khach.setHoTen(txtCustomerFullName.getText().toString());
        khach.setSDT(txtCustomerPhone.getText().toString());
        khach.setEmail(txtCustomerEmail.getText().toString());
        khach.setTen(txtCustomerFirstName.getText().toString());
        khach.setMaKhach(HomeActivity.KhachHang.getMaKhach());
        khach.setNgaySinh(txtCustomerBD.getText().toString());
        khach.setUserName(HomeActivity.KhachHang.getUserName());

        HomeActivity.KhachHang.setGioiTinh(txtCustomerGioiTinh.getText().toString());
        HomeActivity.KhachHang.setCccd(txtCustomerCCCD.getText().toString());
        HomeActivity.KhachHang.setHoTen(txtCustomerFullName.getText().toString());
        HomeActivity.KhachHang.setSdt(txtCustomerPhone.getText().toString());
        HomeActivity.KhachHang.setEmail(txtCustomerEmail.getText().toString());
        HomeActivity.KhachHang.setTen(txtCustomerFirstName.getText().toString());
        HomeActivity.KhachHang.setNgaySinh(txtCustomerBD.getText().toString());

        Methods methodsNhapKhach = getRetrofit().create(Methods.class);
        Call<CallbackResultModel> callNhapKhach = methodsNhapKhach.insertKhachHang(khach);
        callNhapKhach.enqueue(new Callback<CallbackResultModel>() {

            @Override
            public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                String status = response.body().getStatus();
                if (status == "true"){
                    Toast.makeText(getBaseContext(),"Đã lưu thông tin !",Toast.LENGTH_SHORT).show();
                    txtCustomerFullName.setText(HomeActivity.KhachHang.getHoTen());
                    txtCustomerEmail.setText(HomeActivity.KhachHang.getEmail());
                    txtCustomerPhone.setText(HomeActivity.KhachHang.getSdt());
                    txtCustomerCCCD.setText(HomeActivity.KhachHang.getCccd());
                    txtCustomerBD.setText(HomeActivity.KhachHang.getNgaySinh().replace("T00:00:00",""));
                    txtCustomerGioiTinh.setText(HomeActivity.KhachHang.getGioiTinh());
                    txtCustomerFirstName.setText(HomeActivity.KhachHang.getTen());
                }
            }
            @Override
            public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Không thể lưu thông tin !",Toast.LENGTH_SHORT).show();
            }
        });
    }
}