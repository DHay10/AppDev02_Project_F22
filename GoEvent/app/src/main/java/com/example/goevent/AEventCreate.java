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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AEventCreate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final Calendar myCalendar= Calendar.getInstance();
    private DatabaseReference mRef;
    Button backB, createB;
    EditText eventTitleET, nbPlacesET, dateET, descriptionET;
    ImageView eventImageB;
    Spinner typeS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        // Association
        backB = findViewById(R.id.backB1);
        createB = findViewById(R.id.createB);
        eventImageB = findViewById(R.id.eventImageB);

        eventTitleET = findViewById(R.id.eventTitleET);
        nbPlacesET = findViewById(R.id.nbPlaceET);
        dateET = findViewById(R.id.dateET);
        descriptionET = findViewById(R.id.descriptionET);

        typeS = findViewById(R.id.typeS);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        mRef = FirebaseDatabase.getInstance().getReference();

        // Spinner Init
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeS.setAdapter(adapter);
        typeS.setOnItemSelectedListener(this);

        // Date Init
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };

        dateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final Calendar c = Calendar.getInstance();
//                int mYear = c.get(Calendar.YEAR);
//                int mMonth = c.get(Calendar.MONTH);
//                int mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//
//                                dateET.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                            }
//                        }, mYear, mMonth, mDay);
//                datePickerDialog.show();
                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        AEventCreate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dateET.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        // Back Button
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Create Button
        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = eventTitleET.getText().toString();
                String nbPlacesS = nbPlacesET.getText().toString();
                String date = dateET.getText().toString();
                String description = descriptionET.getText().toString();
                String type = typeS.getSelectedItem().toString();

                if (title.length() <= 0 || nbPlacesS.length() <= 0 || date.length() <= 0 ||
                        description.length() <= 0 || type.length() <= 0) {
                    Toast.makeText(AEventCreate.this, "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int nbPlaces = Integer.parseInt(nbPlacesS);

                if (nbPlaces <= 0) {
                    Toast.makeText(AEventCreate.this, "Number of Places must be above 0",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    Date date1 = new SimpleDateFormat("MM/dd/yy").parse(date);
                    Event newEvent = new Event(nbPlaces, title, description, type, date1);
                    mRef.child("events").setValue(newEvent);
                } catch (ParseException e) {}

            }
        });
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