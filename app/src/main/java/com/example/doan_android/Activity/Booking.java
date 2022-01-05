package com.example.doan_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.doan_android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Booking extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    NumberPicker Adult,Child,Baby;

    final Calendar DesCalendar= Calendar.getInstance();
    final Calendar DepCalendar= Calendar.getInstance();
    CheckBox checkBox;

    AutoCompleteTextView NoiDen,NoiDi,NgayVe,NgayDi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
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
        Adult.setMaxValue(100);

        Adult.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d", value);
            }
        });
        Adult.setOnValueChangedListener(this);

        Child = findViewById(R.id.numPickChild);
        Child.setMinValue(0);
        Child.setMaxValue(100);

        Child.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d", value);
            }
        });
        Child.setOnValueChangedListener(this);

        Baby = findViewById(R.id.numPickBaby);
        Baby.setMinValue(0);
        Baby.setMaxValue(100);

        Baby.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%02d", value);
            }
        });
        Baby.setOnValueChangedListener(this);

    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        NgayDi.setText(dateFormat.format(DesCalendar.getTime()));
        NgayVe.setText(dateFormat.format(DepCalendar.getTime()));
    }

    public void GoToHome2(View view) {
        finish();
    }

    void init(){
        checkBox = findViewById(R.id.pa);
        checkBox.setOnCheckedChangeListener(mLinear);

        NgayVe = findViewById(R.id.txtNgayVe);
        NgayDi = findViewById(R.id.txtNgayDi);
        NoiDen = findViewById(R.id.txtNoiDen);
        NoiDi = findViewById(R.id.txtNoiDi);
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
        Intent intent = new Intent(Booking.this, ListBooking.class);
        startActivity(intent);
    }
}