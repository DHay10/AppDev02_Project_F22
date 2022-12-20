package com.example.eventorganiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DBHelper dbHelper;
    Button signupBtn, backBtn;
    EditText usernameET, emailET, passET, passConfET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        signupBtn = findViewById(R.id.signupButton);
        backBtn = findViewById(R.id.backButton);
        usernameET = findViewById(R.id.usernameInput);
        emailET = findViewById(R.id.emailInput);
        passET = findViewById(R.id.passwordInput);
        passConfET = findViewById(R.id.passwordConfirmationInput);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerLogin.class);
                startActivity(i);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameET.getText().toString();
                String email = emailET.getText().toString();
                String password = passET.getText().toString();
                String passwordConf = passConfET.getText().toString();

                if (username.length() <= 0 || email.length() <= 0 || password.length() <= 0
                        || passwordConf.length() <= 0) {
                    Toast.makeText(Registration.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {

                    if (password.equals(passwordConf)) {
                        dbHelper = new DBHelper(Registration.this);
                        User newUser = new User(username, email, password);
                        dbHelper.addUser(newUser);

                        Intent att = new Intent(getApplicationContext(), Attendees.class);
                        att.putExtra("username", usernameET.getText().toString());


                        Toast.makeText(getApplicationContext(), "Signed up successfully!",
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), ProfileCreation.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Registration.this, "Passwords doesn't match",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}