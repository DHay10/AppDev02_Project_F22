package com.example.event2go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {

    DBHelper helper;
    Button signUpB, backB;
    EditText usernameET, emailET, passET, passConfET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        // Association
        usernameET = findViewById(R.id.usernameRET);
        emailET = findViewById(R.id.emailRET);
        passET = findViewById(R.id.passwordRET);
        passConfET = findViewById(R.id.passConfRET);
        signUpB = findViewById(R.id.signUpB);
        backB = findViewById(R.id.backRB);

        // Back Button
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Register Button
        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String email = emailET.getText().toString();
                String password = passET.getText().toString();
                String passwordConf = passConfET.getText().toString();

                if (username.length() <= 0 || email.length() <= 0 || password.length() <= 0
                        || passwordConf.length() <= 0) {
                    Toast.makeText(UserRegistration.this, "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(passwordConf)) {
                        helper = new DBHelper(UserRegistration.this);
                        User newUser = new User(username, email, password);
                        helper.addUser(newUser);
                        Toast.makeText(getApplicationContext(), "Signed up successfully!",
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), UserProfileCreation.class);
                        i.putExtra("username", username);
                        startActivity(i);
                    } else {
                        Toast.makeText(UserRegistration.this, "Passwords doesn't match",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}