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
        adminUser = findViewById(R.id.usernameInputA);
        adminPass = findViewById(R.id.passwordInputA);
        customerBtn = findViewById(R.id.customerButtonC);
        loginBtn = findViewById(R.id.loginButtonA);


  //Validate login input and login
      loginBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String loginID = "a";
              String loginPASS = "s";
              if (adminUser.getText().toString().equals(loginID) && adminPass.getText().toString().equals(loginPASS)) {
                  Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                //  loginID = "Admin";
               //   i.putExtra("user", loginID);
                  startActivity(i);
              } else {
                  Toast.makeText(getApplicationContext(), "Please enter valid username and password", Toast.LENGTH_SHORT).show();
              }
          }
      });


//Go to customer login page
        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CustomerLogin.class);
                startActivity(i);
            }
        });








    }

}