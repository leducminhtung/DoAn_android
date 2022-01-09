package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_android.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ChuyenBayAdapter;
import Model.ChuyenBayModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBooking extends AppCompatActivity {
    List<ChuyenBayModel.Data>  ListCB;
    ChuyenBayAdapter chuyenBayAdapter;
    ListView lv;
    TextView txtSL;
    int SL_NguoiLon = 0;
    int SL_TreEm = 0;
    int SL_EmBe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lisview_booking);
        lv = findViewById(R.id.lv);
        txtSL =findViewById(R.id.txtSLNguoi);

        chuyenBayAdapter = new ChuyenBayAdapter(ListBooking.this, R.layout.item_booking);
    }

    public void GetChuyenBay(){
        for (int i=0;i<ListCB.size();i++){
            chuyenBayAdapter.add(ListCB.get(i));
        }

        lv.setAdapter(chuyenBayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChuyenBayModel.Data item = (ChuyenBayModel.Data) parent.getItemAtPosition(position);
                Intent i = new Intent(ListBooking.this, DetailsBookingActivity.class);

                i.putExtra("ChuyenBayDaChon", item);
                i.putExtra("SL_NguoiLon", SL_NguoiLon);
                i.putExtra("SL_EmBe", SL_EmBe);
                i.putExtra("SL_TreEm", SL_TreEm);

                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListCB = new ArrayList<>();
        ListCB = (ArrayList<ChuyenBayModel.Data>) getIntent().getSerializableExtra("ListCB");
        Intent mIntent = getIntent();
        SL_NguoiLon = mIntent.getIntExtra("SL_NguoiLon",0);
        SL_TreEm = mIntent.getIntExtra("SL_TreEm",0);
        SL_EmBe = mIntent.getIntExtra("SL_EmBe",0);

        String SoLuong = SL_NguoiLon + " Adults, " + SL_TreEm + " Children, " + SL_EmBe + " Babies ";
        txtSL.setText(SoLuong);

        if (ListCB == null) Toast.makeText(getApplicationContext(), "Không tìm thấy chuyến bay nào !", Toast.LENGTH_LONG).show();
        chuyenBayAdapter.clear();
        lv.setAdapter(null);

        GetChuyenBay();
    }
}