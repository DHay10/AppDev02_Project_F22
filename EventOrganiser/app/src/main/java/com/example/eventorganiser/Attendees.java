package com.example.eventorganiser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Attendees extends AppCompatActivity {

    Button back3;

    TextView testuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees);

        String users = getIntent().getStringExtra("username");
        testuser.setText(users);

        back3 = findViewById(R.id.back3);

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Attendees.this,EventOptions.class);
                startActivity(intent);
            }
        });
    }




}
