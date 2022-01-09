package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.doan_android.R;

import java.util.List;

import InterfaceReponsitory.Methods;
import Model.KhachHangModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper v_flipper, v_flipper1;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    Button Login,Ticket,Register;
    TaiKhoanModel.Data TaiKhoan;
    public static KhachHangModel.Data KhachHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.btnRegister);
        Ticket = findViewById(R.id.btnTicket);

        TaiKhoan  = (TaiKhoanModel.Data) getIntent().getSerializableExtra("traKhachDaNhap");
        if (TaiKhoan != null) {
            Login.setEnabled(false);
            Register.setEnabled(false);
            Ticket.setEnabled(true);
            Toast.makeText(getBaseContext(),"Xin chào " +TaiKhoan.getUserName()+ " ! Bạn đã đăng nhập thành công !",Toast.LENGTH_SHORT).show();

        }


        int images[] = {R.drawable.quangcao1, R.drawable.quangcao2, R.drawable.quangcao3,
                        R.drawable.quangcao4, R.drawable.quangcao5, R.drawable.quangcao6};

        int images1[] = {R.drawable.new1, R.drawable.new2, R.drawable.new3};

        v_flipper = findViewById(R.id.v_flipper);
        v_flipper1 = findViewById(R.id.v_flipper1);

        //vong lap
        for( int image: images){
            flipperImages(image);
        }

        for(int image: images1){
            flipperImages1(image);
        }

    }

    public void LayKhachHang(){


    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4900);//4 giay chuyen qua hinh moi
        v_flipper.setAutoStart(true);



        //animation
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    public void flipperImages1(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper1.addView(imageView);
        v_flipper1.setFlipInterval(4000);//4 giay chuyen qua hinh moi
        v_flipper1.setAutoStart(true);



        //animation
        v_flipper1.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper1.setOutAnimation(this,android.R.anim.slide_out_right);


    }


    public void GoToLogin(View view) {
        Intent intent = new Intent(HomeActivity.this,Login.class);
        startActivityForResult(intent,REQUEST_CODE_EXAMPLE);
    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(HomeActivity.this,RegisterUser.class);
        startActivity(intent);
    }

    public void GoToIndex(View view) {

        Methods methods = getRetrofit().create(Methods.class);
        Call<KhachHangModel> callKhachHang = methods.getKhachHang();

        callKhachHang.enqueue(new Callback<KhachHangModel>() {
            @Override
            public void onResponse(Call<KhachHangModel> call, Response<KhachHangModel> response) {
                List<KhachHangModel.Data> dataKH = response.body().getData();
                Toast.makeText(getBaseContext(),"Đã lấy thông tin cá nhân !",Toast.LENGTH_SHORT).show();

                for (int j=0;j<dataKH.size();j++){
                    if (TaiKhoan.getUserName().equals(dataKH.get(j).getUserName())){
                        KhachHang = dataKH.get(j);
                        Intent intent = new Intent(HomeActivity.this, Index.class);

                        startActivity(intent);
                    }

                }
            }

            @Override
            public void onFailure(Call<KhachHangModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Không có dữ liệu khách hàng !",Toast.LENGTH_SHORT).show();

            }
        });


    }


}