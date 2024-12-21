package com.example.myfirebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText username, password, email,phone;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        username = (EditText) findViewById(R.id.usernameEditText_reg);
        password = (EditText) findViewById(R.id.userpasswordEditText_reg);
        email = (EditText) findViewById(R.id.usermailIDEditText_reg);
        phone = (EditText) findViewById(R.id.userMobileNOEditText_reg);

        register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String user_name = username.getText().toString();
                String user_password = password.getText().toString();
                String user_email = email.getText().toString();
                String user_phone = phone.getText().toString();

                if (validateInputs(user_name, user_password, user_email, user_phone))
                {
                    boolean success = saveUserToFirebase(new User(user_name, user_password, user_email, user_phone));
                    if (success)
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                }

            }
        });

    }

    private boolean validateInputs(String userName, String userPassword, String userEmail, String userPhone) {
        if (TextUtils.isEmpty(userName)) {
            username.setError("Username is required");
            return false;
        }
        if (TextUtils.isEmpty(userPassword)) {
            password.setError("Password is required");
            return false;
        }
        if (TextUtils.isEmpty(userEmail)) {
            email.setError("Email is required");
            return false;
        }
        if (TextUtils.isEmpty(userPhone)) {
            phone.setError("Phone number is required");
            return false;
        }
        return true;
    }

    private Boolean saveUserToFirebase(User user) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        String userId = databaseReference.push().getKey();

        if (userId != null) {
            databaseReference.child(userId).setValue(user)
                    .addOnSuccessListener(aVoid -> Toast.makeText(RegistrationActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(RegistrationActivity.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            return true;
        } else {
            Toast.makeText(this, "Error generating User ID", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}