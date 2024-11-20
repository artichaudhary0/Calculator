package com.example.calculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class Form extends AppCompatActivity {
private     EditText nameField ;
 private    EditText emailField ;
 private    EditText phoneField ;
    private EditText passwordField ;
    private Button submitBtn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_form);
         initBinding();
         
         submitBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name = nameField.getText().toString();
                 String email = emailField.getText().toString();
                 String phone = phoneField.getText().toString();
                 String password = passwordField.getText().toString();

                 if(validateForm(name,email,phone,password)){
                     Toast.makeText(getApplicationContext(),"Form submitted successfully!!",Toast.LENGTH_SHORT).show();
                 }
             }
         });
         clearFunction();
    }

    private  boolean validateForm(String name,String email, String phone ,String password){

        // name : empty, at lease 3 character.
        if(TextUtils.isEmpty(name)){
            Toast.makeText(getApplicationContext(),"Name is required",Toast.LENGTH_SHORT).show();
            return  false;
        }else  if(name.length() < 3 ){
            Toast.makeText(getApplicationContext(),"Name should have at least 3 characters",Toast.LENGTH_SHORT).show();
            return  false;
        }

        // email validation
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Email is required",Toast.LENGTH_SHORT).show();
            return  false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),"Email should be valid",Toast.LENGTH_SHORT).show();
            return  false;
        }

        // Phone no.
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(getApplicationContext(),"Phone no. is required",Toast.LENGTH_SHORT).show();
            return  false;
        }else if(!Patterns.PHONE.matcher(phone).matches() ){
            Toast.makeText(getApplicationContext(),"Phone be valid",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (phone.length() <10) {
            Toast.makeText(getApplicationContext(),"Phone should have at least 10 characters",Toast.LENGTH_SHORT).show();
            return  false;
        }

        // password
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Password is required",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (password.length() < 8) { // length
            Toast.makeText(getApplicationContext(),"Password should have at least 8 characters",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (!password.matches(".*[A-Z].*")) { // capital upper case character  at least 1
            Toast.makeText(getApplicationContext(),"Password should have at least 1 upper characters",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (!password.matches(".*[a-z].*")) { // lower case character  at least 1
            Toast.makeText(getApplicationContext(),"Password should have at least 1 lower characters",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (!password.matches(".*[0-9].*")) { // number case character  at least 1
            Toast.makeText(getApplicationContext(),"Password should have at least 1 digit",Toast.LENGTH_SHORT).show();
            return  false;
        }else if (!password.matches(".*[@#$%^&*+=_!].*")) { // special case character  at least 1
            Toast.makeText(getApplicationContext(),"Password should have at least 1 special character",Toast.LENGTH_SHORT).show();
            return  false;
        }

        return  true;
    }


    private void initBinding(){
        nameField = findViewById(R.id.userName);
        emailField = findViewById(R.id.userEmail);
        phoneField = findViewById(R.id.userPhoneNumber);
        passwordField = findViewById(R.id.userPassword);
        submitBtn = findViewById(R.id.submitButton);
    }



    private void clearFunction(){
        Button clearBtn = findViewById(R.id.clearButton);
        // clear button
        clearBtn.setOnClickListener(v -> {
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            passwordField.setText("");
            Toast.makeText(getApplicationContext(),"Form Cleared",Toast.LENGTH_SHORT).show();

        });
    }

}