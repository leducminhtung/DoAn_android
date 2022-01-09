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
import Model.HoaDonModel;
import Model.KhachInsertModel;
import Model.TaiKhoanInsertModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {

    TextInputEditText txtRe_UserName,txtRe_Password,txtRe_ConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        txtRe_ConfirmPassword = findViewById(R.id.txtRe_ConfirmPassword);
        txtRe_UserName = findViewById(R.id.txtRe_UserName);
        txtRe_Password = findViewById(R.id.txtRe_Password);

    }

    public void GoToHome(View view){
        Intent intent = new Intent(RegisterUser.this,HomeActivity.class);
        startActivity(intent);

    }

    public void CreateAccount(View view) {
        final int[] check_UserNameExist = {1};
        String MatKhau = txtRe_Password.getText().toString();
        String MatKhauConfirm = txtRe_ConfirmPassword.getText().toString();

        final Methods[] methodsLayDSTK = {getRetrofit().create(Methods.class)};
        Call<TaiKhoanModel> callLayDSHD = methodsLayDSTK[0].getTaiKhoan();
        callLayDSHD.enqueue(new Callback<TaiKhoanModel>() {
            @Override
            public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                List<TaiKhoanModel.Data> data = response.body().getData();
                for (int i=0;i<data.size();i++){
                    if (txtRe_UserName.getText().toString().equals(data.get(i).getUserName())) {
                        Toast.makeText(getBaseContext(), "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                        check_UserNameExist[0] = -1;

                    }
                }

                if (MatKhau.equals(MatKhauConfirm) && check_UserNameExist[0] == 1 ){
                    TaiKhoanInsertModel taiKhoanInsertModel = new TaiKhoanInsertModel();
                    taiKhoanInsertModel.setUserName(txtRe_UserName.getText().toString());
                    taiKhoanInsertModel.setPassword(txtRe_Password.getText().toString());
                    taiKhoanInsertModel.setMaTK("00000000-0000-0000-0000-000000000000");



                    Methods methods = getRetrofit().create(Methods.class);
                    Call<CallbackResultModel> call2 = methods.insertTaiKhoan(taiKhoanInsertModel);
                    call2.enqueue(new Callback<CallbackResultModel>() {
                        @Override
                        public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                            String status = response.body().getStatus();
                            if (status == "true"){


                                Methods methods3 = getRetrofit().create(Methods.class);
                                KhachInsertModel khachInsertModel = new KhachInsertModel();
                                khachInsertModel.setUserName(taiKhoanInsertModel.getUserName());
                                khachInsertModel.setMaKhach("00000000-0000-0000-0000-000000000000");
                                khachInsertModel.setSDT("");
                                khachInsertModel.setNgaySinh("1970-01-01");
                                khachInsertModel.setTen("");
                                khachInsertModel.setHoTen("");
                                khachInsertModel.setCCCD("");
                                khachInsertModel.setEmail("");
                                khachInsertModel.setGioiTinh("");

                                Call<CallbackResultModel> callThemKhach = methods3.insertKhachHang(khachInsertModel);
                                callThemKhach.enqueue(new Callback<CallbackResultModel>() {
                                    @Override
                                    public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                                        String status = response.body().getStatus();
                                        if (status == "true"){
                                            Toast.makeText(getBaseContext(),"Tạo tài khoản thành công!",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(RegisterUser.this,Login.class);
                                            intent.putExtra("Taikhoandatao",taiKhoanInsertModel);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<CallbackResultModel> call, Throwable t) {

                                    }
                                });
                            }else{
                                Toast.makeText(getBaseContext(),"Tạo tài khoản thất bại !",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                            Toast.makeText(getBaseContext(),"Tạo tài khoản thất bại !",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Mật khẩu xác nhận không trùng khớp !",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<TaiKhoanModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Server gặp sự cố!",Toast.LENGTH_SHORT).show();

            }
        });




    }
}