package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.doan_android.R;

import java.util.ArrayList;
import java.util.List;

import Model.ChuyenBayModel;
import Model.KhachHangModel;

public class InputCustomer extends AppCompatActivity {
    EditText txtCustomer_NL_FirstN,txtCustomer_NL_FullN,txtCustomer_NL_GT,txtCustomer_NL_SN,txtCustomer_NL_CCCD,txtCustomer_NL_Email,txtCustomer_NL_Phone;



    KhachHangModel.Data khachHang_current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_customer);
        GetIdView();

        khachHang_current = (KhachHangModel.Data) getIntent().getSerializableExtra("Khach");
        SetDataView();

    }

    public void GetIdView(){
        txtCustomer_NL_FirstN = findViewById(R.id.txtCustomer_NL_FirstN);
        txtCustomer_NL_FullN = findViewById(R.id.txtCustomer_NL_FullN);
        txtCustomer_NL_GT = findViewById(R.id.txtCustomer_NL_GT);
        txtCustomer_NL_SN = findViewById(R.id.txtCustomer_NL_SN);
        txtCustomer_NL_CCCD = findViewById(R.id.txtCustomer_NL_CCCD);
        txtCustomer_NL_Email = findViewById(R.id.txtCustomer_NL_Email);
        txtCustomer_NL_Phone = findViewById(R.id.txtCustomer_NL_Phone);
    }

    public void SetDataView(){
        txtCustomer_NL_FirstN.setText(khachHang_current.getTen());
        txtCustomer_NL_FullN.setText(khachHang_current.getHoTen());
        txtCustomer_NL_CCCD.setText(khachHang_current.getCccd());
        txtCustomer_NL_Email.setText(khachHang_current.getEmail());
        txtCustomer_NL_Phone.setText(khachHang_current.getSdt());
        txtCustomer_NL_GT.setText(khachHang_current.getGioiTinh());
        txtCustomer_NL_SN.setText(khachHang_current.getNgaySinh());

    }


    public void Save(View view) {
        final Intent intent = new Intent();

                khachHang_current.setNgaySinh(txtCustomer_NL_SN.getText().toString());
                khachHang_current.setHoTen(txtCustomer_NL_FullN.getText().toString());
                khachHang_current.setCccd(txtCustomer_NL_CCCD.getText().toString());
                khachHang_current.setGioiTinh(txtCustomer_NL_GT.getText().toString());
                khachHang_current.setTen(txtCustomer_NL_FirstN.getText().toString());
                khachHang_current.setEmail(txtCustomer_NL_Email.getText().toString());
                khachHang_current.setSdt(txtCustomer_NL_Phone.getText().toString());






        intent.putExtra("traKhachDaNhap", khachHang_current);
        setResult(Activity.RESULT_OK, intent);
        finish();

    }

    public void Cancel(View view) {
        final Intent intent = new Intent();
        intent.putExtra("traKhachDaNhap", khachHang_current);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}