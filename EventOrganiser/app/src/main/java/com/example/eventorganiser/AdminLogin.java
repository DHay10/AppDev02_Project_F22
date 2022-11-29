package com.example.eventorganiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button customerBtn, loginBtn;
    EditText adminUser, adminPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adminUser = findViewById(R.id.usernameInput);
        adminPass = findViewById(R.id.passwordInput);
        customerBtn = findViewById(R.id.customerButton);
        loginBtn = findViewById(R.id.loginButton);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginID = "admin1234";
                String loginPassword = "pass1234";
                if (adminUser.getText().toString().equals(loginID) && adminPass.getText().toString().equals(loginPassword)) {
                    Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                    loginID = "Admin";
                    i.putExtra("user", loginID);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter the valid username and password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerLogin.class);
                startActivity(i);
            }
        });








    }

}