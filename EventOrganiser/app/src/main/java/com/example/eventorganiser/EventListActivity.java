package com.example.eventorganiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EventListActivity extends AppCompatActivity {

    Button backB, calendarbtn;
    ImageView filtersIm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        backB = findViewById(R.id.backB);

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventListActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        calendarbtn = findViewById(R.id.calendarB);
        filtersIm = findViewById(R.id.filtersIV);

        calendarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EventCalendar.class);
                startActivity(i);
            }
        });

        filtersIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Filters.class);
                startActivity(i);
            }
        });
    }
}