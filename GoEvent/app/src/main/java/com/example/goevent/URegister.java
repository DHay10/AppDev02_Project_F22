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

public class URegister extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    Button signUpB, backB;
    EditText usernameET, emailET, passET, passConfET;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uregister);

        // Association
        usernameET = findViewById(R.id.usernameRET);
        emailET = findViewById(R.id.emailRET);
        passET = findViewById(R.id.passwordRET);
        passConfET = findViewById(R.id.passConfRET);
        signUpB = findViewById(R.id.signUpB);
        backB = findViewById(R.id.backRB);
        mAuth = FirebaseAuth.getInstance();

        // Back Button
        backB.setOnClickListener(v -> finish());

        // Register Button
        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String pass = passET.getText().toString();
                String passConf = passConfET.getText().toString();
                String username = usernameET.getText().toString();

                if (username.length() <= 0 || email.length() <= 0 || pass.length() <= 0
                        || passConf.length() <= 0) {
                    Toast.makeText(URegister.this, "Enter All Data",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(passConf)) {
                        createAccount(email, pass);
                    } else {
                        Toast.makeText(URegister.this, "Passwords doesn't match",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            updateUI(null);
                            Toast.makeText(URegister.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void reload() { }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(getApplicationContext(), "Signed up successfully!",
                    Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), ULogin.class);
            startActivity(i);
        }
    }
}