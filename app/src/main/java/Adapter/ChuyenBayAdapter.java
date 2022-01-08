package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan_android.R;
import com.squareup.picasso.Picasso;

import Model.ChuyenBayModel;

public class ChuyenBayAdapter extends ArrayAdapter<ChuyenBayModel.Data>
{
    Activity context;
    int resource;

    public ChuyenBayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);


        TextView txtTenHang = view.findViewById(R.id.txtTenHang_layoutDetails);
        TextView txtCangDi = view.findViewById(R.id.txtCangDi);
        TextView txtCangDen = view.findViewById(R.id.txtCangDen);
        TextView txtGioDi = view.findViewById(R.id.txtGioDi);
        TextView txtGioDen = view.findViewById(R.id.txtGioDen);

        ImageView imgHang = view.findViewById(R.id.imgHang);
        TextView txtPrice = view.findViewById(R.id.txtCustomer_NL_FullN);


        ChuyenBayModel.Data chuyenBayModel = getItem(position);
        Picasso.get().load(chuyenBayModel.getPicture()).into(imgHang);
        txtTenHang.setText(chuyenBayModel.getTenhang());
        txtPrice.setText(chuyenBayModel.getGianguoilon().replace(".00","")+"đ");
        txtCangDi.setText(chuyenBayModel.getMacangdi());
        txtCangDen.setText(chuyenBayModel.getMacangden());
        txtGioDi.setText(chuyenBayModel.getGioDi());
        txtGioDen.setText(chuyenBayModel.getGioDen());
        return view;
    }

}
