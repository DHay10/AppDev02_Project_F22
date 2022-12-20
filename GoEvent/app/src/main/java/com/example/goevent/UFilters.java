package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UFilters extends AppCompatActivity {
    Button sportBtn, musicBtn, partyBtn, foodBtn, festivalBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        sportBtn = findViewById(R.id.sportsButton);
        musicBtn = findViewById(R.id.musicButton);
        partyBtn = findViewById(R.id.partyButton);
        foodBtn = findViewById(R.id.foodButton);
        festivalBtn = findViewById(R.id.festivalButton);
        backBtn = findViewById(R.id.backButton);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UEventList.class);
                startActivity(intent);
            }
        });
    }
}