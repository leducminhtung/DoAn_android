package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;
import androidx.annotation.Nullable;
import static Model.RetrofitClient.getRetrofit;

import com.example.doan_android.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import InterfaceReponsitory.Methods;
import Model.CangBayModel;
import Model.ChuyenBayModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Booking extends AppCompatActivity implements NumberPicker.OnValueChangeListener {




    NumberPicker Adult,Child,Baby;

    final Calendar DesCalendar= Calendar.getInstance();
    final Calendar DepCalendar= Calendar.getInstance();
    CheckBox checkBox;

    AutoCompleteTextView NoiDen,NoiDi,NgayVe,NgayDi;
    List<CangBayModel.Data> cangBayAdapter = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        cangBayAdapter = new ArrayList<>();


        init();

        NgayDi=(AutoCompleteTextView) findViewById(R.id.txtNgayDi);
        DatePickerDialog.OnDateSetListener datelichdi =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                DesCalendar.set(Calendar.YEAR, year);
                DesCalendar.set(Calendar.MONTH,month);
                DesCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        NgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Booking.this,datelichdi,DesCalendar.get(Calendar.YEAR),DesCalendar.get(Calendar.MONTH),DesCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        NgayVe=(AutoCompleteTextView) findViewById(R.id.txtNgayVe);
        DatePickerDialog.OnDateSetListener datelichve =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                DepCalendar.set(Calendar.YEAR, year);
                DepCalendar.set(Calendar.MONTH,month);
                DepCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        NgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Booking.this,datelichve,DepCalendar.get(Calendar.YEAR),DepCalendar.get(Calendar.MONTH),DepCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Number picker
        Adult = findViewById(R.id.numpickAdult);
        Adult.setMinValue(0);
        Adult.setMaxValue(5);

        Adult.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%d", value);
            }
        });
        Adult.setOnValueChangedListener(this);

        Child = findViewById(R.id.numPickChild);
        Child.setMinValue(0);
        Child.setMaxValue(5);

        Child.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%d", value);
            }
        });
        Child.setOnValueChangedListener(this);

        Baby = findViewById(R.id.numPickBaby);
        Baby.setMinValue(0);
        Baby.setMaxValue(5);

        Baby.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%d", value);
            }
        });
        Baby.setOnValueChangedListener(this);

    }
    private void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        NgayDi.setText(dateFormat.format(DesCalendar.getTime()));
        NgayVe.setText(dateFormat.format(DepCalendar.getTime()));
    }

    public void GoToHome2(View view) {
        finish();
    }

    public void GetCangBay(){
        Bundle bundle = new Bundle();
        Methods methods = getRetrofit().create(Methods.class);
        Call<CangBayModel> call = methods.getCangBay();
        call.enqueue(new Callback<CangBayModel>() {
            @Override
            public void onResponse(Call<CangBayModel> call, Response<CangBayModel> response) {
                List<CangBayModel.Data> data = response.body().getData();
                cangBayAdapter= data;
                LayCangBay();
                NoiDen.getText();
            }

            @Override
            public void onFailure(Call<CangBayModel> call, Throwable t) {
                Log.v("Thất bại rồi !","Thất bại rồi !" + "\n");
            }
        });



    }

    public void LayCangBay(){
        List<String> dsTenCang = new ArrayList<>();

        for(int i=0;i<cangBayAdapter.size();i++){
            dsTenCang.add(cangBayAdapter.get(i).getTenMB());
        }

        String[] items = {"SGN", "HAN", "DAD", "ASH"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.dropdown_item, dsTenCang);


        NoiDi.setAdapter(adapter);

        NoiDen.setAdapter(adapter);

        NoiDi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        NoiDen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init(){
        checkBox = findViewById(R.id.pa);
        checkBox.setOnCheckedChangeListener(mLinear);

        NgayVe = findViewById(R.id.txtNgayVe);
        NgayDi = findViewById(R.id.txtNgayDi);
        NoiDen = findViewById(R.id.txtNoiDen);
        NoiDi =  findViewById(R.id.txtNoiDi);
        GetCangBay();

    }



    CompoundButton.OnCheckedChangeListener mLinear = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(Booking.this,
                        "You just choose : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                NgayVe.setEnabled(true);
            }
            else
            {
                Toast.makeText(Booking.this,
                        "You just unchoose : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                NgayVe.setEnabled(false);
            }
        }
    };


    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.i("Values is" ," " + newVal);
    }

    public void UpValueAdult(View view) {
        int sohientai = Adult.getValue();
        Adult.setValue(sohientai+1);
    }

    public void UpValueChild(View view) {
        int sohientai = Child.getValue();
        Child.setValue(sohientai+1);
    }

    public void UpValueBaby(View view) {
        int sohientai = Baby.getValue();
        Baby.setValue(sohientai+1);
    }

    public void DownValueBaby(View view) {
        int sohientai = Baby.getValue();
        Baby.setValue(sohientai-1);
    }

    public void DownValueChild(View view) {
        int sohientai = Child.getValue();
        Child.setValue(sohientai-1);
    }

    public void DownValueAdult(View view) {
        int sohientai = Adult.getValue();
        Adult.setValue(sohientai-1);
    }

    public void GoToListBooking(View view) {



        Methods methods = getRetrofit().create(Methods.class);
        Call<ChuyenBayModel> call = methods.getChuyenBay();
        call.enqueue(new Callback<ChuyenBayModel>() {
            @Override
            public void onResponse(Call<ChuyenBayModel> call, Response<ChuyenBayModel> response) {
                List<ChuyenBayModel.Data> data = response.body().getData();
                ArrayList<ChuyenBayModel.Data> dscb_Found = new ArrayList<>();
                String noiden = NoiDen.getText().toString();
                String noidi = NoiDi.getText().toString();
                String ngaydi = NgayDi.getText().toString();
                String ngayve = NgayVe.getText().toString().trim();
                int SL_NguoiLon = Adult.getValue();
                int SL_TreEm = Child.getValue();
                int SL_EmBe = Baby.getValue();



                for (int i=0;i<data.size();i++){
                    if (noiden.equals(data.get(i).getTencangden()) && noidi.equals(data.get(i).getTencangdi())
                    && ngaydi.equals(data.get(i).getNgayDi().trim())){
                        dscb_Found.add(data.get(i));
                    }
                }

                Intent intent = new Intent(Booking.this, ListBooking.class);
                intent.putExtra("ListCB", dscb_Found);
                intent.putExtra("SL_NguoiLon", SL_NguoiLon);
                intent.putExtra("SL_TreEm", SL_TreEm);
                intent.putExtra("SL_EmBe", SL_EmBe);

                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ChuyenBayModel> call, Throwable t) {

            }
        });

    }
}