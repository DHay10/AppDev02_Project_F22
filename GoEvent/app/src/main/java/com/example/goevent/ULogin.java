package com.example.goevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ULogin extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    Button adminB, loginB, registerB;
    EditText emailET, passwordET;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulogin);

        // Association
        emailET = findViewById(R.id.emailUET);
        passwordET = findViewById(R.id.passwordUET);
        adminB = findViewById(R.id.adminUB);
        loginB = findViewById(R.id.loginUB);
        registerB = findViewById(R.id.registerUB);
        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();

        // Login Button
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String pass = passwordET.getText().toString();
                if (email.length() <= 0 || pass.length() <= 0) {
                    Toast.makeText(ULogin.this, "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                } else {
                    signIn(email, pass);
                }
            }
        });

        // Register Button
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), URegister.class);
                startActivity(i);
            }
        });

        // Admin Switch Button
        adminB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ALogin.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(ULogin.this, "Authentication Passed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(ULogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void reload() { }

    private void updateUI() {
        FirebaseUser user = mAuth.getCurrentUser();
        // Check if User has a profile in the DB
        mRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Redirects to Dashboard
                if (snapshot.hasChild(user.getUid())) {
                    Intent i = new Intent(getApplicationContext(), UEventList.class);
                    startActivity(i);
                // Redirects to Create Profile
                } else {
                    Intent i = new Intent(getApplicationContext(), UCreateProfile.class);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}