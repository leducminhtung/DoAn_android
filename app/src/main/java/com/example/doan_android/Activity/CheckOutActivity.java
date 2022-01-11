package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_android.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Adapter.KhachHangAdapter_Checkout;
import InterfaceReponsitory.Methods;
import Model.CallbackResultModel;
import Model.CangBayModel;
import Model.ChuyenBayModel;
import Model.HoaDonInsertModel;
import Model.HoaDonModel;
import Model.KhachHangModel;
import Model.KhachInsertModel;
import Model.VeMayBayInsertModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.Collections; import java.util.List; import java.util.Random;
import java.util.function.Consumer;

public class CheckOutActivity extends AppCompatActivity {

    int SL_NguoiLon = 0;
    int SL_TreEm = 0;
    int SL_EmBe = 0;
    int Event_NhapHD = 0;
    // update 1
    ChuyenBayModel.Data chuyenbaydachon;
    KhachHangAdapter_Checkout khachHangAdapter;
    ArrayList<KhachHangModel.Data> dsKH = new ArrayList<>();

    ArrayList<VeMayBayInsertModel> dsVe = new ArrayList<>();
    ArrayList<HoaDonInsertModel> dsHoaDon = new ArrayList<>();

    ListView lvCheck;
    TextView txtCheck_TenHang,txtCheck_TenCangDi,txtCheck_TenCangDen,txtCheck_NgayGioDi,txtCheck_NgayGioDen,txtCheck_TenMayBay,
            txtCheck_SLNguoiLon,txtCheck_SLTreEm,txtCheck_SLEmBe,
            txtCheck_GiaNL,txtCheck_GiaTE,txtCheck_GiaEB,
            txtCheck_GiaThueNL,txtCheck_GiaThueTE,txtCheck_GiaThueEB,
            txtCheck_GiaDVNL,txtCheck_GiaDVTE,txtCheck_GiaDVEB
            ,txtCheck_SumPrice;
    LinearLayout lnrCheck_NguoiLon,lnrCheck_TreEm,lnrCheck_EmBe;


    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaUpperCase = alpha.toUpperCase();
    private static final String digits = "0123456789";
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;
    private static Random generator = new Random();

    public static int randomNumber(int min, int max)
    {
        return generator.nextInt((max - min) + 1) + min;
    }

    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numberOfCharactor; i++) {
            if (i==9 || i == 14 || i == 19 || i == 24){
                sb.append("-");
                numberOfCharactor++;
            }
            else
            {
                int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
                char ch = ALPHA_NUMERIC.charAt(number);
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    public void GetIdView(){
        txtCheck_GiaDVEB = findViewById(R.id.txtCheck_GiaDVEB);
        txtCheck_GiaDVTE = findViewById(R.id.txtCheck_GiaDVTE);
        txtCheck_GiaDVNL = findViewById(R.id.txtCheck_GiaDVNL);

        txtCheck_GiaThueEB = findViewById(R.id.txtCheck_GiaThueEB);
        txtCheck_GiaThueTE = findViewById(R.id.txtCheck_GiaThueTE);
        txtCheck_GiaThueNL = findViewById(R.id.txtCheck_GiaThueNL);

        txtCheck_GiaEB = findViewById(R.id.txtCheck_GiaEB);
        txtCheck_GiaTE = findViewById(R.id.txtCheck_GiaTE);
        txtCheck_GiaNL = findViewById(R.id.txtCheck_GiaNL);

        txtCheck_SLEmBe = findViewById(R.id.txtCheck_SLEmBe);
        txtCheck_SLTreEm = findViewById(R.id.txtCheck_SLTreEm);
        txtCheck_SLNguoiLon = findViewById(R.id.txtCheck_SLNguoiLon);

        txtCheck_TenHang = findViewById(R.id.txtCheck_TenHang);
        txtCheck_TenMayBay = findViewById(R.id.txtCheck_TenMayBay);
        txtCheck_TenCangDi = findViewById(R.id.txtCheck_TenCangDi);
        txtCheck_TenCangDen = findViewById(R.id.txtCheck_TenCangDen);
        txtCheck_NgayGioDi = findViewById(R.id.txtCheck_NgayGioDi);
        txtCheck_NgayGioDen = findViewById(R.id.txtCheck_NgayGioDen);

        txtCheck_SumPrice = findViewById(R.id.txtCheck_SumPrice);

        lnrCheck_NguoiLon = findViewById(R.id.lnrCheck_NguoiLon);
        lnrCheck_TreEm = findViewById(R.id.lnrCheck_TreEm);
        lnrCheck_EmBe = findViewById(R.id.lnrCheck_EmBe);

        lvCheck = findViewById(R.id.lvCheck);
    }

    public  void GetData(){
        dsKH = (ArrayList<KhachHangModel.Data>) getIntent().getSerializableExtra("dsKH");
        chuyenbaydachon = (ChuyenBayModel.Data) getIntent().getSerializableExtra("chuyenbaydachon");

        Intent mIntent = getIntent();
        SL_NguoiLon = mIntent.getIntExtra("SL_NguoiLon",0);
        SL_TreEm = mIntent.getIntExtra("SL_TreEm",0);
        SL_EmBe = mIntent.getIntExtra("SL_EmBe",0);

    }

    public void SetData(){
        txtCheck_GiaDVEB.setText(chuyenbaydachon.getGiadichvuembe().replace(".00",""));
        txtCheck_GiaDVTE.setText(chuyenbaydachon.getGiadichvutreem().replace(".00",""));
        txtCheck_GiaDVNL.setText(chuyenbaydachon.getGiadichvunguoilon().replace(".00",""));

        txtCheck_GiaThueEB.setText(chuyenbaydachon.getThuephisanbayembe().replace(".00",""));
        txtCheck_GiaThueTE.setText(chuyenbaydachon.getThuephisanbaytreem().replace(".00",""));
        txtCheck_GiaThueNL.setText(chuyenbaydachon.getThuephisanbaynguoilon().replace(".00",""));

        txtCheck_GiaEB.setText(chuyenbaydachon.getGiaembe().replace(".00",""));
        txtCheck_GiaTE.setText(chuyenbaydachon.getGiatreem().replace(".00",""));
        txtCheck_GiaNL.setText(chuyenbaydachon.getGianguoilon().replace(".00",""));

        txtCheck_SLEmBe.setText(String.valueOf(SL_EmBe));
        txtCheck_SLTreEm.setText(String.valueOf(SL_TreEm));
        txtCheck_SLNguoiLon.setText(String.valueOf(SL_NguoiLon));

        txtCheck_TenHang.setText(chuyenbaydachon.getTenhang());
        txtCheck_TenMayBay.setText(chuyenbaydachon.getTenMB());
        txtCheck_TenCangDi.setText(chuyenbaydachon.getTencangdi());
        txtCheck_TenCangDen.setText(chuyenbaydachon.getTencangden());
        txtCheck_NgayGioDi.setText(chuyenbaydachon.getNgayGioDi());
        txtCheck_NgayGioDen.setText(chuyenbaydachon.getNgayGioDen());

        Double GiaEB=Double.parseDouble(txtCheck_GiaEB.getText().toString());
        Double GiaTE=Double.parseDouble(txtCheck_GiaTE.getText().toString());
        Double GiaNL=Double.parseDouble(txtCheck_GiaNL.getText().toString());

        Double GiaThueEB=Double.parseDouble(txtCheck_GiaThueEB.getText().toString());
        Double GiaThueTE=Double.parseDouble(txtCheck_GiaThueTE.getText().toString());
        Double GiaThueNL=Double.parseDouble(txtCheck_GiaThueNL.getText().toString());

        Double GiaDVEB=Double.parseDouble(txtCheck_GiaDVEB.getText().toString());
        Double GiaDVTE=Double.parseDouble(txtCheck_GiaDVTE.getText().toString());
        Double GiaDVNL=Double.parseDouble(txtCheck_GiaDVNL.getText().toString());

        BigDecimal Tong = BigDecimal.valueOf((GiaEB + GiaThueEB + GiaDVEB) * SL_EmBe +
                (GiaNL + GiaThueNL + GiaDVNL) * SL_NguoiLon +
                (GiaTE + GiaThueTE + GiaDVTE) * SL_TreEm);

        if (SL_NguoiLon == 0) lnrCheck_NguoiLon.setVisibility(View.GONE);
        if (SL_TreEm == 0) lnrCheck_TreEm.setVisibility(View.GONE);
        if (SL_EmBe == 0) lnrCheck_EmBe.setVisibility(View.GONE);

        txtCheck_SumPrice.setText(Tong.toString().replace(".00",""));

        int tongkhach = SL_NguoiLon + SL_EmBe + SL_TreEm;
        for (int i=0;i<dsKH.size();i++){

            khachHangAdapter.add(dsKH.get(i));

        }




        khachHangAdapter.notifyDataSetChanged();

        lvCheck.setAdapter(khachHangAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);
        khachHangAdapter = new KhachHangAdapter_Checkout(CheckOutActivity.this, R.layout.item_customer);

        GetIdView();
        GetData();
        SetData();


    }

    public  void InsertKhachHang(KhachHangModel.Data i){
        Methods methodsNhapKhach = getRetrofit().create(Methods.class);
        KhachInsertModel KHNhapVao = new KhachInsertModel();
        KHNhapVao.setUserName(i.getUserName());
        KHNhapVao.setEmail(i.getEmail());
        KHNhapVao.setGioiTinh(i.getGioiTinh());
        KHNhapVao.setHoTen(i.getHoTen());
        KHNhapVao.setNgaySinh(i.getNgaySinh().replace("/","-"));
        KHNhapVao.setTen(i.getTen());
        KHNhapVao.setCCCD(i.getCccd());
        KHNhapVao.setSDT(i.getSdt());
        KHNhapVao.setMaKhach(i.getMaKhach());
        KHNhapVao.setUserName("");
        Call<CallbackResultModel> callNhapKhach = methodsNhapKhach.insertKhachHang(KHNhapVao);
        callNhapKhach.enqueue(new Callback<CallbackResultModel>() {

            @Override
            public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                String status = response.body().getStatus();
                if (status == "true"){
                    Toast.makeText(getBaseContext(),"Đã thêm dữ liệu khách hàng!",Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Không thể thanh toán !",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void nhapHoaDon(){

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ThanhToan(View view) throws InterruptedException {

        Login.TaiKhoan.getUserName();
        Toast.makeText(getBaseContext(),Login.TaiKhoan.getUserName(),Toast.LENGTH_SHORT).show();

        Methods methodsNhapHoaDon = getRetrofit().create(Methods.class);
        HoaDonInsertModel hoadon = new HoaDonInsertModel();
        hoadon.setSL_EmBe(txtCheck_SLEmBe.getText().toString());
        hoadon.setSL_NguoiLon(txtCheck_SLNguoiLon.getText().toString());
        hoadon.setSL_TreEm(txtCheck_SLTreEm.getText().toString());
        hoadon.setTongTien(txtCheck_SumPrice.getText().toString());
        hoadon.setMaKhach(HomeActivity.KhachHang.getMaKhach());
        Call<CallbackResultModel> callNhapHD = methodsNhapHoaDon.insertHoaDon(hoadon);

        callNhapHD.enqueue(new Callback<CallbackResultModel>() {
            @Override
            public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                Toast.makeText(getBaseContext(),"Đã thêm hóa đơn!",Toast.LENGTH_SHORT).show();
                Event_NhapHD = 1;

                Methods methodsLayDSHD = getRetrofit().create(Methods.class);
                Call<HoaDonModel> callLayDSHD = methodsLayDSHD.getHoaDon();


                if (Event_NhapHD == 1)
                callLayDSHD.enqueue(new Callback<HoaDonModel>() {
                    @Override
                    public void onResponse(Call<HoaDonModel> call, Response<HoaDonModel> response) {
                        Toast.makeText(getBaseContext(),"Lấy ds hóa đơn!",Toast.LENGTH_SHORT).show();

                        List<HoaDonModel.Data> data = response.body().getData();
                        VeMayBayInsertModel vemMayBay = new VeMayBayInsertModel();
                        for (int i=0;i<data.size();i++){
                            if (data.get(i).getNgayLap().substring(0,16).equals(hoadon.getNgayLap().substring(0,16))){


                                vemMayBay.setId(chuyenbaydachon.getId());
                                vemMayBay.setNgayLap(data.get(i).getNgayLap());
                                vemMayBay.setTongTien(data.get(i).getTongTien().replace(".0",""));
                                vemMayBay.setLoaiVe("Vé thường");
                                vemMayBay.setMaHD(data.get(i).getMaHD());
                                break;




                            }
                        }

                        if (vemMayBay != null){
                            Methods methodsGuiVeMB = getRetrofit().create(Methods.class);
                            Call<CallbackResultModel> callingVE = methodsGuiVeMB.insertVeMayBay(vemMayBay);

                            callingVE.enqueue(new Callback<CallbackResultModel>() {
                                @Override
                                public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                                    String status = response.body().getStatus();
                                    if (status == "true") {
                                        Toast.makeText(getBaseContext(), "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(CheckOutActivity.this, Index.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getBaseContext(), "Thanh toán thất bại!", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                                    Toast.makeText(getBaseContext(),"Thanh toán thất bại!",Toast.LENGTH_SHORT).show();

                                }
                            });
                        }


                    }

                    @Override
                    public void onFailure(Call<HoaDonModel> call, Throwable t) {
                        Toast.makeText(getBaseContext(),"Không thể thanh toán !",Toast.LENGTH_SHORT).show();

                    }
                });
            }
            @Override
            public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Không thể thanh toán !",Toast.LENGTH_SHORT).show();
            }
        });





    }

    public void Back(View view) {
        finish();
    }
}
