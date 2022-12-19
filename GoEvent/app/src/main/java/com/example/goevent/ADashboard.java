package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ADashboard extends AppCompatActivity {

    Button adminEventList, adminEventCreate, logout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adashboard);


        //Association
        adminEventList = findViewById(R.id.eventsB);
        adminEventCreate = findViewById(R.id.createEventsB);
        logout = findViewById(R.id.logoutB);



        //Events Button
        adminEventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AEventList.class);
                startActivity(i);
            }
        });

        //Event Create Button
       adminEventCreate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(), EventCreate.class);
               startActivity(i);
           }
       });

       //Logout Button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ALogin.class);
                startActivity(i);
            }
        });




    }
}