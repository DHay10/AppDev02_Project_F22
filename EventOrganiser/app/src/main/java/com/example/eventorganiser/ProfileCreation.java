package com.example.eventorganiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileCreation extends AppCompatActivity {

    Button confirmBtn;
    EditText firstn, lastn, phonen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_creation);
        confirmBtn = findViewById(R.id.confirmButton);
        firstn = findViewById(R.id.firstNameInput);
        lastn = findViewById(R.id.lastNameInput);
        phonen = findViewById(R.id.phoneNumberInput);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstn.getText().toString();
                String lastName = lastn.getText().toString();
                String phoneNumber = phonen.getText().toString();

                if (firstName.length() <= 0 || lastName.length() <= 0 || phoneNumber.length() <= 0) {
                    Toast.makeText(ProfileCreation.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent i = new Intent(getApplicationContext(), EventListActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}