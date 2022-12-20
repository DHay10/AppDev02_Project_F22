package com.example.goevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UCreateProfile extends AppCompatActivity {

    private static final String TAG = "UpdateProfile";

    Button confirmB;
    EditText fNameET, lNameET, phoneET;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucreate_profile);

        // Association
        confirmB = findViewById(R.id.confirmButton);
        fNameET = findViewById(R.id.firstNameInput1);
        lNameET = findViewById(R.id.lastNameInput1);
        phoneET = findViewById(R.id.phoneNumberInput1);
        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();

        // Confirm Button
        confirmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = fNameET.getText().toString();
                String lName = lNameET.getText().toString();
                String phone = phoneET.getText().toString();

                if (fName.length() <= 0 || lName.length() <= 0 || phone.length() <= 0) {
                    Toast.makeText(UCreateProfile.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    mRef.child("users").child(currentUser.getUid()).child("fName").setValue(fName);
                    mRef.child("users").child(currentUser.getUid()).child("lName").setValue(lName);
                    mRef.child("users").child(currentUser.getUid()).child("phone").setValue(phone);
                    Intent intent = new Intent(getApplicationContext(), UEventList.class);
                    startActivity(intent);
                }

            }
        });
    }

}