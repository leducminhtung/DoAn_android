package Adapter;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doan_android.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.KhachHangModel;

public class KhachHangAdapter_Checkout extends ArrayAdapter<KhachHangModel.Data>
{
    Activity context;
    int resource;

    final Calendar DesCalendar= Calendar.getInstance();



    public KhachHangAdapter_Checkout(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;


    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);


        /*TextView txtCustomer_NL_FirstN = view.findViewById(R.id.txtCustomer_NL_FirstN_item);
        TextView txtCustomer_NL_FullN = view.findViewById(R.id.txtCustomer_NL_FullN_item);
        TextView txtCustomer_NL_GT = view.findViewById(R.id.txtCustomer_NL_GT_item);
        TextView txtCustomer_NL_SN = view.findViewById(R.id.txtCustomer_NL_SN_item);
        TextView txtCustomer_NL_CCCD = view.findViewById(R.id.txtCustomer_NL_CCCD_item);
        TextView txtCustomer_NL_Email = view.findViewById(R.id.txtCustomer_NL_Email_item);
        TextView txtCustomer_NL_Phone = view.findViewById(R.id.txtCustomer_NL_Phone_item);
*/
        TextView txtTen = view.findViewById(R.id.txtCheck_Customer);
        TextView txtNgaySinh = view.findViewById(R.id.txtCheck_Birthday);


        KhachHangModel.Data khachHangModel = getItem(position);


       /* txtCustomer_NL_FirstN.setText(khachHangModel.getTen());
        txtCustomer_NL_FullN.setText(khachHangModel.getHoTen());
        txtCustomer_NL_CCCD.setText(khachHangModel.getCccd());
        txtCustomer_NL_Email.setText(khachHangModel.getEmail());
        txtCustomer_NL_Phone.setText(khachHangModel.getSdt());
        txtCustomer_NL_GT.setText(khachHangModel.getGioiTinh());
        txtCustomer_NL_SN.setText(khachHangModel.getNgaySinh());*/
        txtTen.setText(khachHangModel.getTen());
        txtNgaySinh.setText(khachHangModel.getNgaySinh());


        return view;
    }

    private void updateLabel(AutoCompleteTextView txtCustomer_NL_SN){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        txtCustomer_NL_SN.setText(dateFormat.format(DesCalendar.getTime()));

    }

}
