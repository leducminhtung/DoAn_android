package com.example.doan_android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_android.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Adapter.ChuyenBayAdapter;
import Adapter.KhachHangAdapter;
import Model.ChuyenBayModel;
import Model.KhachHangModel;

public class InfoCustomerActivity extends AppCompatActivity {

    ChuyenBayModel.Data chuyenbaydachon;
    ListView lv_info;
    KhachHangAdapter khachHangAdapter;
    ArrayList <KhachHangModel.Data> dsKH = new ArrayList<>();
    int SL_NguoiLon = 0;
    int SL_TreEm = 0;
    int SL_EmBe = 0;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    int selected_position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_infocustomer);
        lv_info = findViewById(R.id.lv_infocustommer);



        chuyenbaydachon = (ChuyenBayModel.Data) getIntent().getSerializableExtra("ChuyenBayDaChon");
        khachHangAdapter = new KhachHangAdapter(InfoCustomerActivity.this, R.layout.item_test);
        GetData();


        GetKhachHang();

    }

    public void GetKhachHang(){
        int tongkhach = SL_NguoiLon + SL_EmBe + SL_TreEm;
        for (int i=0;i<tongkhach;i++){
            KhachHangModel.Data khachhang = new KhachHangModel.Data();
            khachHangAdapter.add(khachhang);

        }




        khachHangAdapter.notifyDataSetChanged();

        lv_info.setAdapter(khachHangAdapter);

        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_position = position;
                KhachHangModel.Data item = (KhachHangModel.Data) parent.getItemAtPosition(position);
                Intent i = new Intent(InfoCustomerActivity.this, InputCustomer.class);
                i.putExtra("Khach",item);

                startActivityForResult(i,REQUEST_CODE_EXAMPLE);

            }
        });


    }

    public void GetData(){
        Intent i = getIntent();
        Intent mIntent = getIntent();
        SL_NguoiLon = mIntent.getIntExtra("SL_NguoiLon", 0);
        SL_TreEm = mIntent.getIntExtra("SL_TreEm", 0);
        SL_EmBe = mIntent.getIntExtra("SL_EmBe", 0);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_EXAMPLE) {

                KhachHangModel.Data khachhang  = (KhachHangModel.Data) data.getSerializableExtra("traKhachDaNhap");
                for (int i=0;i<khachHangAdapter.getCount();i++){
                    if (i == selected_position){
                        khachHangAdapter.getItem(i).setNgaySinh(khachhang.getNgaySinh());
                        khachHangAdapter.getItem(i).setSdt(khachhang.getSdt());
                        khachHangAdapter.getItem(i).setEmail(khachhang.getEmail());
                        khachHangAdapter.getItem(i).setTen(khachhang.getTen());
                        khachHangAdapter.getItem(i).setCccd(khachhang.getCccd());
                        khachHangAdapter.getItem(i).setHoTen(khachhang.getHoTen());
                        khachHangAdapter.getItem(i).setGioiTinh(khachhang.getGioiTinh());
                    }
                }
                khachHangAdapter.notifyDataSetChanged();
                lv_info.setAdapter(null);
                lv_info.setAdapter(khachHangAdapter);
             }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void Cancel1(View view) {
        finish();
    }

    public void GoToCheckout(View view) {
        for (int i=0;i<khachHangAdapter.getCount();i++){
            dsKH.add(khachHangAdapter.getItem(i));
        }

        Intent intent = new Intent(InfoCustomerActivity.this, CheckOutActivity.class);
        intent.putExtra("SL_NguoiLon",SL_NguoiLon);
        intent.putExtra("SL_TreEm",SL_TreEm);
        intent.putExtra("SL_EmBe",SL_EmBe);
        intent.putExtra("dsKH",dsKH);
        intent.putExtra("chuyenbaydachon",chuyenbaydachon);
        startActivity(intent);
    }
}
