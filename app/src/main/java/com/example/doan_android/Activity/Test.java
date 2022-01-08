package com.example.doan_android.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Test extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    String[] items = {"SGN", "HAN", "DAD", "ASH"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    public Button pls1, min1;
    NumberPicker Adult,Child,Baby;

    static Dialog d;
    final Calendar myCalendar= Calendar.getInstance();
    AutoCompleteTextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        autoCompleteTextView = findViewById(R.id.txtNoiDi1);

        adapterItems = new ArrayAdapter<String>(this, R.layout.dropdown_item, items);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        //Date
        textView=(AutoCompleteTextView) findViewById(R.id.txtNgayDi);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Test.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
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
        textView.setText(dateFormat.format(myCalendar.getTime()));
    }

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


}
