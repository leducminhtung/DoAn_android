package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doan_android.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import InterfaceReponsitory.Methods;
import Model.KhachHangModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Account extends Fragment {

    TextView txtCustomUserName;
    TextInputEditText txtCustomerFullName,txtCustomerEmail,txtCustomerPhone,txtCustomerCCCD,txtCustomerBD,txtCustomerGioiTinh,txtCustomerFirstName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inf =inflater.inflate(R.layout.activity_profile_user, container, false);
        GetViewId(inf);
        if (HomeActivity.TaiKhoan.getUserName() != null || HomeActivity.KhachHang.getUserName() != null){
            HomeActivity.TaiKhoan.setUserName("");

        }
        SetData();
        return inf;
    }

    public void SetData(){
        txtCustomUserName.setText(HomeActivity.KhachHang.getUserName());
        txtCustomerFullName.setText(HomeActivity.KhachHang.getHoTen());
        txtCustomerEmail.setText(HomeActivity.KhachHang.getEmail());
        txtCustomerPhone.setText(HomeActivity.KhachHang.getSdt());
        txtCustomerCCCD.setText(HomeActivity.KhachHang.getCccd());
        txtCustomerBD.setText(HomeActivity.KhachHang.getNgaySinh().replace("T00:00:00",""));
        txtCustomerGioiTinh.setText(HomeActivity.KhachHang.getGioiTinh());
        txtCustomerFirstName.setText(HomeActivity.KhachHang.getTen());
    }
    public void GetViewId(View inf){


        txtCustomUserName = (TextView) inf.findViewById(R.id.txtCustomUserName);

        txtCustomerFullName = (TextInputEditText) inf.findViewById(R.id.txtCustomerFullName);
        txtCustomerEmail = (TextInputEditText) inf.findViewById(R.id.txtCustomerEmail);
        txtCustomerPhone = (TextInputEditText) inf.findViewById(R.id.txtCustomerPhone);
        txtCustomerCCCD = (TextInputEditText) inf.findViewById(R.id.txtCustomerCCCD);
        txtCustomerBD = (TextInputEditText) inf.findViewById(R.id.txtCustomerBD);
        txtCustomerGioiTinh = (TextInputEditText) inf.findViewById(R.id.txtCustomerGioiTinh);
        txtCustomerFirstName = (TextInputEditText) inf.findViewById(R.id.txtCustomerFirstName);
    }




}
