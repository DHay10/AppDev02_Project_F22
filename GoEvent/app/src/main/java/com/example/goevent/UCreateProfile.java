package com.example.goevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class UCreateProfile extends AppCompatActivity {

    private static final String TAG = "UpdateProfile";

    Button confirmB;
    EditText fNameET, lNameET, phoneET;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucreate_profile);

        // Association
        confirmB = findViewById(R.id.confirmButton);
        fNameET = findViewById(R.id.firstNameInput);
        lNameET = findViewById(R.id.lastNameInput);
        phoneET = findViewById(R.id.phoneNumberInput);
        mAuth = FirebaseAuth.getInstance();

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
                }

            }
        });
    }


    public void updateProfile() {
        // [START update_profile]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName("Jane Q. User")
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User profile updated.");
                        }
                    }
                });
        // [END update_profile]
    }
}