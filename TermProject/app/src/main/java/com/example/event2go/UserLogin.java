package com.example.event2go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserLogin extends AppCompatActivity {

    Button adminB, loginB, registerB;
    EditText usernameET, passwordET;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        // Association
        usernameET = findViewById(R.id.usernameUET);
        passwordET = findViewById(R.id.passwordUET);
        adminB = findViewById(R.id.adminUB);
        loginB = findViewById(R.id.loginUB);
        registerB = findViewById(R.id.registerUB);

        // Login Button
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper = new DBHelper(UserLogin.this);
                User user = helper.getUserByUsername(usernameET.getText().toString());
                // Password Check
                if (passwordET.getText().toString().equals(user.getPassword())) {
                    Intent i;
                    // Profile Creation
                    if (user.getFname().equals("")) {
                        i = new Intent(getApplicationContext(), UserProfileCreation.class);
                    // Dashboard
                    } else {
                        i = new Intent(getApplicationContext(), UserDashboard.class);
                    }
                    startActivity(i);
                }
            }
        });

        // Admin Switch Button
        adminB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Register Button
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserRegistration.class);
                startActivity(i);
            }
        });

    }
}