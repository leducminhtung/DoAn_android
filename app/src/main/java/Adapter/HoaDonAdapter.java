package Adapter;

import static Model.RetrofitClient.getRetrofit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan_android.Activity.Booking;
import com.example.doan_android.Activity.ListBooking;
import com.example.doan_android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import InterfaceReponsitory.Methods;
import Model.ChuyenBayModel;
import Model.HoaDonModel;
import Model.VeMayBayModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoaDonAdapter extends ArrayAdapter<HoaDonModel.Data>
{
    Activity context;
    int resource;

    public HoaDonAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);


        TextView txtTenHang = view.findViewById(R.id.txtTenHang_History);
        TextView txtNgayDi = view.findViewById(R.id.txtNgayDi_History);
        TextView txtCangDi = view.findViewById(R.id.txtCangDi_History);

        TextView txtCangDen = view.findViewById(R.id.txtCangDen_History);
        TextView txtSoLuong_History = view.findViewById(R.id.txtSoLuong_History);
        TextView txtCustomer_NL_FullN = view.findViewById(R.id.txtCustomer_NL_FullN);


        HoaDonModel.Data hoadon = getItem(position);

        if (hoadon != null){
            Methods methods = getRetrofit().create(Methods.class);
            Call<VeMayBayModel> call = methods.getVeMayBay();
            call.enqueue(new Callback<VeMayBayModel>() {
                @Override
                public void onResponse(Call<VeMayBayModel> call, Response<VeMayBayModel> response) {
                    List<VeMayBayModel.Data> ve = response.body().getData();
                    Toast.makeText(context,"Đang hiển thị danh sách !",Toast.LENGTH_SHORT).show();

                    for (int i=0;i<ve.size();i++){
                        if (ve.get(i).getMaHD().equals(hoadon.getMaHD())){
                            int SL_NL = Integer.valueOf(hoadon.getSL_NguoiLon());
                            int SL_TE = Integer.valueOf(hoadon.getSL_TreEm());
                            int SL_EB = Integer.valueOf(hoadon.getSL_EmBe());
                            txtSoLuong_History.setText(String.valueOf(SL_EB + SL_NL + SL_TE) );
                            txtCustomer_NL_FullN.setText(hoadon.getTongTien());
                            Methods methods = getRetrofit().create(Methods.class);
                            Call<ChuyenBayModel> callCB = methods.getChuyenBay();
                            int finalI = i;
                            callCB.enqueue(new Callback<ChuyenBayModel>() {
                                @Override
                                public void onResponse(Call<ChuyenBayModel> call, Response<ChuyenBayModel> response) {
                                    if (response.isSuccessful()){
                                        Toast.makeText(context,"Đang hiển thị danh sách !",Toast.LENGTH_SHORT).show();

                                        List<ChuyenBayModel.Data> chuyenbay = response.body().getData();
                                        for (int j=0;j<chuyenbay.size();j++){
                                            if (chuyenbay.get(j).getId().equals(ve.get(finalI).getId())){
                                                txtCangDen.setText(chuyenbay.get(j).getTencangden());
                                                txtCangDi.setText(chuyenbay.get(j).getTencangdi());
                                                txtNgayDi.setText(chuyenbay.get(j).getNgayDi() + " " + chuyenbay.get(j).getGioDi());
                                                txtTenHang.setText(chuyenbay.get(j).getTenhang());
                                            }

                                        }
                                    }
                                    else {
                                        Toast.makeText(context,"Gặp vấn đề!",Toast.LENGTH_SHORT).show();

                                    }
                                }

                                @Override
                                public void onFailure(Call<ChuyenBayModel> call, Throwable t) {

                                }
                            });
                        }


                    }



                }

                @Override
                public void onFailure(Call<VeMayBayModel> call, Throwable t) {

                }
            });
        }



        return view;

    }

}
