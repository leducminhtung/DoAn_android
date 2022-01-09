package com.example.doan_android.Activity;

import static Model.RetrofitClient.getRetrofit;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.doan_android.R;

import java.io.IOException;
import java.util.List;

import Adapter.HoaDonAdapter;
import InterfaceReponsitory.Methods;
import Model.HoaDonModel;
import Model.VeMayBayModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_History extends Fragment {
    ListView lv_history;
    HoaDonAdapter hoaDonAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inf = inflater.inflate(R.layout.listview_item_histories, container, false);
        lv_history =  (ListView) inf.findViewById(R.id.lv_history);
        hoaDonAdapter = new HoaDonAdapter(inf.getContext(),R.layout.item_history);

        return inf;


    }

    @Override
    public void onStart() {
        super.onStart();
        Methods methods = getRetrofit().create(Methods.class);
        Call<HoaDonModel> call = methods.getHoaDon();

        call.enqueue(new Callback<HoaDonModel>() {
            @Override
            public void onResponse(Call<HoaDonModel> call, Response<HoaDonModel> response) {
                List<HoaDonModel.Data> hoadon = response.body().getData();
                hoaDonAdapter.clear();
                lv_history.setAdapter(null);

                for (int i=0;i<hoadon.size();i++){
                    if (hoadon.get(i).getMaKhach().equals(HomeActivity.KhachHang.getMaKhach()))
                    hoaDonAdapter.add(hoadon.get(i));
                }

                lv_history.setAdapter(hoaDonAdapter);
            }

            @Override
            public void onFailure(Call<HoaDonModel> call, Throwable t) {

            }
        });

    }
}
