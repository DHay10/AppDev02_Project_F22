package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AEventCreate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final Calendar myCalendar= Calendar.getInstance();
    Button backB, createB;
    EditText eventTitleET, nbPlacesET, dateET;
    ImageView eventImageB;
    Spinner typeS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        // Association
        backB = findViewById(R.id.backB1);
        createB = findViewById(R.id.createB);
        eventTitleET = findViewById(R.id.eventTitleET);
        nbPlacesET = findViewById(R.id.nbPlaceET);
        dateET = findViewById(R.id.dateET);
        eventImageB = findViewById(R.id.eventImageB);
        typeS = findViewById(R.id.typeS);

        // Spinner Init
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeS.setAdapter(adapter);
        typeS.setOnItemSelectedListener(this);

        // Date Init
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        dateET.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String choice = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}