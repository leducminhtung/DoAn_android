package com.example.doan_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_android.R;

import Model.ChuyenBayModel;

public class DetailsBookingActivity extends AppCompatActivity {

    ChuyenBayModel.Data chuyenbaydachon;
    TextView txtTenHang,txtTenCangDi,txtTenCangDen,txtNgayGioDi,txtNgayGioDen,txtSL_NguoiLon,txtSL_TreEm,txtSL_EmBe,txtPriceNL,txtPriceCR,txtPriceBB,txtSumPrice;
    int SL_NguoiLon = 0;
    int SL_TreEm = 0;
    int SL_EmBe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_booking);
        chuyenbaydachon = (ChuyenBayModel.Data) getIntent().getSerializableExtra("ChuyenBayDaChon");

        GetIdView();
        GetDataItem();
    }

    public void GetIdView(){

        txtTenHang = findViewById(R.id.txtTenHang_layoutDetails);
        txtTenCangDi = findViewById(R.id.txtTenCangDi);
        txtTenCangDen = findViewById(R.id.txtTenCangDen);
        txtNgayGioDi = findViewById(R.id.txtNgayGioDi);
        txtNgayGioDen = findViewById(R.id.txtNgayGioDen);
        txtSL_NguoiLon = findViewById(R.id.txtSL_NguoiLon);
        txtSL_TreEm = findViewById(R.id.txtSL_TreEm);
        txtSL_EmBe = findViewById(R.id.txtSL_EmBe);

        txtPriceNL = findViewById(R.id.txtPriceNL);
        txtPriceCR = findViewById(R.id.txtPriceCR);
        txtPriceBB = findViewById(R.id.txtPriceBB);
        txtSumPrice = findViewById(R.id.txtSumPrice);

    }

    public void GetDataItem(){
        Intent i = getIntent();
        Intent mIntent = getIntent();
        SL_NguoiLon = mIntent.getIntExtra("SL_NguoiLon", 0);
        SL_TreEm = mIntent.getIntExtra("SL_TreEm", 0);
        SL_EmBe = mIntent.getIntExtra("SL_EmBe", 0);

        txtTenHang.setText(chuyenbaydachon.getTenhang());
        txtTenCangDi.setText(chuyenbaydachon.getTencangdi());
        txtTenCangDen.setText(chuyenbaydachon.getTencangden());
        txtNgayGioDi.setText(chuyenbaydachon.getNgayGioDi());
        txtNgayGioDen.setText(chuyenbaydachon.getNgayGioDen());
        txtSL_NguoiLon.setText(String.valueOf(SL_NguoiLon));

        txtSL_TreEm.setText(String.valueOf(SL_TreEm));
        txtSL_EmBe.setText(String.valueOf(SL_EmBe));

        txtPriceNL.setText(chuyenbaydachon.getGianguoilon().replace(".00",""));
        txtPriceCR.setText(chuyenbaydachon.getGiatreem().replace(".00",""));
        txtPriceBB.setText(chuyenbaydachon.getGiaembe().replace(".00",""));

        double GiaNL = Double.parseDouble(txtPriceNL.getText().toString());
        double GiaTE = Double.parseDouble(txtPriceCR.getText().toString());
        double GiaEB = Double.parseDouble(txtPriceBB.getText().toString());

        int SL_NL = Integer.valueOf(txtSL_NguoiLon.getText().toString());
        int SL_TE = Integer.valueOf(txtSL_TreEm.getText().toString());
        int SL_EB = Integer.valueOf(txtSL_NguoiLon.getText().toString());

        double tong = GiaNL * SL_NL + GiaTE * SL_TE + GiaEB * SL_EB;

        txtSumPrice.setText(Double.toString(tong));
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void GoToInfoCustomer(View view) {
        Intent i = new Intent(DetailsBookingActivity.this, InfoCustomerActivity.class);
        i.putExtra("ChuyenBayDaChon", chuyenbaydachon);
        i.putExtra("SL_NguoiLon", SL_NguoiLon);
        i.putExtra("SL_EmBe", SL_EmBe);
        i.putExtra("SL_TreEm", SL_TreEm);
        startActivity(i);
    }

    public void BackToList(View view) {
        finish();
    }
}
