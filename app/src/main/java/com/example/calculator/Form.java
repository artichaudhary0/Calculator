package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText nameField = findViewById(R.id.userName);
        EditText emailField = findViewById(R.id.userEmail);
        EditText phoneField = findViewById(R.id.userPhoneNumber);
        EditText passwordField = findViewById(R.id.userPassword);


        Button submitBtn = findViewById(R.id.submitButton);
        Button clearBtn = findViewById(R.id.clearButton);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String email = emailField.getText().toString();
                String phone = phoneField.getText().toString();
                String password = passwordField.getText().toString();
            }
        });

    }
}