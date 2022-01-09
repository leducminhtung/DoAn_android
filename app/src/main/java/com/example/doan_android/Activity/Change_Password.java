package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doan_android.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import InterfaceReponsitory.Methods;
import Model.CallbackResultModel;
import Model.TaiKhoanInsertModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Change_Password extends AppCompatActivity {

    TextInputEditText txtchange_oldP,txtchange_newP,txtchange_newCP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        txtchange_oldP = findViewById(R.id.txtchange_oldP);
        txtchange_newP = findViewById(R.id.txtchange_newP);
        txtchange_newCP = findViewById(R.id.txtchange_newCP);

    }

    public void Save(View view) {
        String MatKhau_Old = txtchange_oldP.getText().toString();
        String MatKhau_New = txtchange_newP.getText().toString();
        String MatKhau_NewConfirm = txtchange_newCP.getText().toString();

        if (MatKhau_NewConfirm.equals(MatKhau_New)){
            Methods methods = getRetrofit().create(Methods.class);
            Call<TaiKhoanModel> callLayDSHD = methods.getTaiKhoan();
            callLayDSHD.enqueue(new Callback<TaiKhoanModel>() {
                @Override
                public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                    List<TaiKhoanModel.Data> data = response.body().getData();
                    TaiKhoanInsertModel taikhoan = new TaiKhoanInsertModel();
                    int SK_DOIMK = -1;
                    for (int i=0;i<data.size();i++){
                        if (data.get(i).getPassword().equals(MatKhau_Old) && data.get(i).getUserName().equals(HomeActivity.KhachHang.getUserName())){



                            taikhoan.setPassword(txtchange_newP.getText().toString());
                            SK_DOIMK =1;
                            break;
                        }

                    }
                    if (SK_DOIMK != 1) return;
                    taikhoan.setUserName(HomeActivity.KhachHang.getUserName());
                    taikhoan.setMaTK(Index.TaiKhoan.getMaTK());

                    Methods methodsDoiPass = getRetrofit().create(Methods.class);
                    Call<CallbackResultModel> callDoiMK = methodsDoiPass.editTaiKhoan(taikhoan);
                    callDoiMK.enqueue(new Callback<CallbackResultModel>() {
                        @Override
                        public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(getBaseContext(), "Đổi mật khẩu thành công !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Change_Password.this,Index.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                            Toast.makeText(getBaseContext(), "Đổi mật khẩu thất bại !", Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                @Override
                public void onFailure(Call<TaiKhoanModel> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Đổi mật khẩu thất bại !", Toast.LENGTH_SHORT).show();

                }
            });

        }
        else
        Toast.makeText(getBaseContext(), "Sai thông tin cần nhập !", Toast.LENGTH_SHORT).show();

    }

    public void GoBack(View view) {
        finish();
    }
}