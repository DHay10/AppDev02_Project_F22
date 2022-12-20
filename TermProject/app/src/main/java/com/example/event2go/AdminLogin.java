package com.example.event2go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button userB, loginB;
    EditText usernameET, passwordET;
    private static String adminUsername = "admin";
    private static String adminPassword = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        // Association
        usernameET = findViewById(R.id.usernameAET);
        passwordET = findViewById(R.id.passwordAET);
        userB = findViewById(R.id.userAB);
        loginB = findViewById(R.id.loginAB);

        // Login Button
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameET.getText().toString().equals(adminUsername) &&
                        passwordET.getText().toString().equals(adminPassword)) {
                    Intent i = new Intent(getApplicationContext(), AdminDashboard.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter valid username and password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // User Switch Button
        userB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserLogin.class);
                startActivity(i);
            }
        });
    }
}