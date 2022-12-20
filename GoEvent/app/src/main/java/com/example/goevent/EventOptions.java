package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventOptions extends AppCompatActivity {

    Button attendees, delete, backEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_options);


        //Association
        attendees = findViewById(R.id.attendees);
        delete = findViewById(R.id.delete);
        backEvent = findViewById(R.id.backToEventDetailsAdmin);


        //Attendees button
        attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AAttendees.class);
                startActivity(i);
            }
        });



        //Delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });











    }
}