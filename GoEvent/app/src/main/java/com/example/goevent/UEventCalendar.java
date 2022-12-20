package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UEventCalendar extends AppCompatActivity {
    Button listB;
    ImageView filterIV, EdProfileIV, logoutIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_calendar);
        listB = findViewById(R.id.listButton);
        filterIV = findViewById(R.id.filtersB);
        EdProfileIV = findViewById(R.id.edProfileB);
        logoutIV = findViewById(R.id.logoutB);

        listB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UEventList.class);
                startActivity(intent);
            }
        });

        filterIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UFilters.class);
                startActivity(intent);
            }
        });

        EdProfileIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UProfileEdit.class);
                startActivity(intent);
            }
        });

        logoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ULogin.class);
                startActivity(intent);
            }
        });
    }
}