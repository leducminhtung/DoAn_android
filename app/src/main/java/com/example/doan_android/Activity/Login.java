package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doan_android.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import InterfaceReponsitory.Methods;
import Model.KhachHangModel;
import Model.TaiKhoanInsertModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    public static TaiKhoanModel.Data TaiKhoan;

    TextInputEditText txtUserName,txtPassWord;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassWord = findViewById(R.id.txtPassword);
        TaiKhoanInsertModel taiKhoanInsertModel = (TaiKhoanInsertModel) getIntent().getSerializableExtra("Taikhoandatao");
        if (taiKhoanInsertModel != null){
            txtUserName.setText(taiKhoanInsertModel.getUserName());
            txtPassWord.setText(taiKhoanInsertModel.getPassword());
        }
    }

    public void GoToHome1(View view){
        final Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    public void LayTaiKhoan(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<TaiKhoanModel> call = methods.getTaiKhoan();
        call.enqueue(new Callback<TaiKhoanModel>() {
            @Override
            public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                List<TaiKhoanModel.Data> data = response.body().getData();
                ArrayList<TaiKhoanModel.Data> dscb_Found = new ArrayList<>();

                String UserName = txtUserName.getText().toString();
                String PassWord = txtPassWord.getText().toString();

                boolean dangnhapthanhcong = false;

                for (int i=0;i<data.size();i++){
                    if (UserName.equals(data.get(i).getUserName()) && PassWord.equals(data.get(i).getPassword())){

                        if (data.get(i).getStatus().equals("Đã khóa")){
                            Toast.makeText(getBaseContext(),"Tài Khoản đã bị khóa !",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            dangnhapthanhcong = true;
                            TaiKhoan = data.get(i);


                            final Intent intent1 = new Intent(Login.this,HomeActivity.class);
                            intent1.putExtra("traKhachDaNhap", TaiKhoan);
                            startActivity(intent1);
                        }

                    }

                }
                if (dangnhapthanhcong == false) Toast.makeText(getBaseContext(),"Đăng nhập sai tài khoản hoặc mật khẩu !",Toast.LENGTH_SHORT).show();








            }

            @Override
            public void onFailure(Call<TaiKhoanModel> call, Throwable t) {

            }
        });
    }



    public void SignIn(View view) {
        LayTaiKhoan();


     
    }
}