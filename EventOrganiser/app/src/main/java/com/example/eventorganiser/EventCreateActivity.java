package com.example.eventorganiser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EventCreateActivity extends AppCompatActivity {

    Button dateB, backB01, createB;
    Spinner typeS;
    TextView dateTV;
    EditText titleB, descriptionB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        dateB = findViewById(R.id.dateB);
        dateTV = findViewById(R.id.dateTV);
        typeS = findViewById(R.id.typeS);
        backB01 = findViewById(R.id.backB01);
        createB = findViewById(R.id.createB);
        titleB = findViewById(R.id.titleET);
        descriptionB = findViewById(R.id.descriptionET);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeS.setAdapter(adapter);

        dateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });


        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleB.getText().toString();
                String description = descriptionB.getText().toString();

                if (title.length() <= 0 || description.length() <= 0) {
                    Toast.makeText(EventCreateActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {



                 // dbHelperr = new DBHelper(EventCreateActivity.this);
                 //   User newUser = new User(title, description);
                 //   dbHelperr.addUser(newUser);
                 //   Toast.makeText(getApplicationContext(), "Signed up successfully!",
                 //    Toast.LENGTH_SHORT).show();
                 //  Intent i = new Intent(getApplicationContext(), EventListActivity.class);
                 //    startActivity(i);



                }
            }
        });








    }





    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(requireContext(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            dateTV.setText(year + ", " + month + ", " + day);
        }
    }












}