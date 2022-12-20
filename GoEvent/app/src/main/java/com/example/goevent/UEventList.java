package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UEventList extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Button calendarB;
    ImageView logoutIB, profileIB, filtersIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        calendarB = findViewById(R.id.calendarB);
        logoutIB = findViewById(R.id.logoutIB);
        profileIB = findViewById(R.id.profileIB);
        filtersIB = findViewById(R.id.filtersIB);

        mAuth = FirebaseAuth.getInstance();

        logoutIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logged Out.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), UEventCalendar.class);
                startActivity(intent);
            }
        });

        profileIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UProfileEdit.class);
                startActivity(intent);
            }
        });

        filtersIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UFilters.class);
                startActivity(intent);
            }
        });
    }
}