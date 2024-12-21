package com.example.myfirebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    EditText username, password,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        username =(EditText) findViewById(R.id.usernameEditText_fetch);
        password =(EditText) findViewById(R.id.userpasswordEditText_fetch);
        email =(EditText) findViewById(R.id.usermailIDEditText_fetch);
        phone =(EditText) findViewById(R.id.userMobileNOEditText_fetch);

        // Get the user details passed from MainActivity
        Intent intent = getIntent();
        String str_username = intent.getStringExtra("username");
        String str_password = intent.getStringExtra("password");
        String str_email = intent.getStringExtra("email");
        String str_phone = intent.getStringExtra("phone");

        username.setText(str_username);
        password.setText(str_password);
        email.setText(str_email);
        phone.setText(str_phone);


    }
}