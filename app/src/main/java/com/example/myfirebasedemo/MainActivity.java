package com.example.myfirebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, passwordEditText;
    private DatabaseReference mDatabase;
    private TextView openRegisterActivityTV;
    private DatabaseReference databaseReference;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        openRegisterActivityTV = findViewById(R.id.open_reg_act_tv);
        nameEditText = findViewById(R.id.login_usernameEditText);
        passwordEditText = findViewById(R.id.login_userpasswordEditText);
        login = findViewById(R.id.login_Button);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        openRegisterActivityTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(name, password);
                }
            }
        });
    }

    private void loginUser(String username, String password) {
        // Get reference to the 'users' node in the Firebase database
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Query the 'users' node to find a user with the given username
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // User exists, check password
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        User user = userSnapshot.getValue(User.class);

                        // Debugging: Print the user details
                        Log.d("Login", "Found user: " + user.username + ", password: " + user.password);

                        // Ensure that user is not null and passwords match
                        if (user != null && user.password.equals(password)) {
                            // Successfully logged in, now fetch and show user details
                            Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                            // Pass the user details to the next activity (HomeActivity)
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("username", user.username);
                            intent.putExtra("password", user.password);
                            intent.putExtra("email", user.email);
                            intent.putExtra("phone", user.phone);
                            startActivity(intent);
                        } else {
                            // Invalid password
                            Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // User not found
                    Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle database error
                Toast.makeText(MainActivity.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
