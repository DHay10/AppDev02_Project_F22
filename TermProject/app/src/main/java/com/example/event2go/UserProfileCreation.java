package com.example.event2go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfileCreation extends AppCompatActivity {

    DBHelper helper;
    Button confirmB;
    EditText fNameET, lNameET, phoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_creation);
        Bundle extras = getIntent().getExtras();

        // Association
        confirmB = findViewById(R.id.confirmPCB);
        fNameET = findViewById(R.id.fNamePCET);
        lNameET = findViewById(R.id.lNamePCET);
        phoneET = findViewById(R.id.phonePCET);

        // Confirm Button
        confirmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = fNameET.getText().toString();
                String lName = fNameET.getText().toString();
                String phone = phoneET.getText().toString();
                if (fName.length() <= 0 || lName.length() <= 0 || phone.length() <= 0) {
                    Toast.makeText(UserProfileCreation.this, "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                } else {
                    helper = new DBHelper(UserProfileCreation.this);
                    User user = helper.getUserByUsername(extras.getString("username"));
                    user.setFname(fName);
                    user.setLname(lName);
                    user.setPhone(phone);
                    helper.updateUser(user);
                }
            }
        });
    }
}