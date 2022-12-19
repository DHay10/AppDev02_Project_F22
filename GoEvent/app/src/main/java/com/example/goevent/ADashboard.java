package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ADashboard extends AppCompatActivity {

    Button createEventB, eventsB;
    ImageView logoutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adashboard);

        // Association
        createEventB = findViewById(R.id.createEventsB);
        eventsB = findViewById(R.id.eventsB);
        logoutB = findViewById(R.id.aLogoutB);

        // Log Out Button
        logoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Event List Button
        eventsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AEventList.class);
                startActivity(intent);
            }
        });

        // Create Event Button
        createEventB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AEventCreate.class);
                startActivity(intent);
            }
        });
    }
}