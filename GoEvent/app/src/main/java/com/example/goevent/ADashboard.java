package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ADashboard extends AppCompatActivity {

    Button createEventB, eventsB;
    ImageView logoutB;

    Button adminEventList, adminEventCreate, logout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adashboard);
    }
}