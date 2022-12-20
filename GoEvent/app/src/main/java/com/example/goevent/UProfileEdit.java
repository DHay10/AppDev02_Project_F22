package com.example.goevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UProfileEdit extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    EditText fNameET, lNameET, phoneET;
    Button backB, saveB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        // Association
        fNameET = findViewById(R.id.firstNameInput1);
        lNameET = findViewById(R.id.lastNameInput1);
        phoneET = findViewById(R.id.phoneNumberInput1);
        backB = findViewById(R.id.backButton);
        saveB = findViewById(R.id.saveButton);
        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = mAuth.getCurrentUser();

        // Value Placement
        mRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String fName = snapshot.child(user.getUid()).child("fName").getValue(String.class);
                String lName = snapshot.child(user.getUid()).child("lName").getValue(String.class);
                String phone = snapshot.child(user.getUid()).child("phone").getValue(String.class);
                fNameET.setText(fName);
                lNameET.setText(lName);
                phoneET.setText(phone);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Save Button
        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = fNameET.getText().toString();
                String lName = lNameET.getText().toString();
                String phone = phoneET.getText().toString();

                if (fName.length() <= 0 || lName.length() <= 0 || phone.length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                } else {
                    mRef.child("users").child(user.getUid()).child("fName").setValue(fName);
                    mRef.child("users").child(user.getUid()).child("lName").setValue(lName);
                    mRef.child("users").child(user.getUid()).child("phone").setValue(phone);
                    Toast.makeText(getApplicationContext(), "Saved Successfully",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Back Button
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}