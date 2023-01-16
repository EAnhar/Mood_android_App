package com.example.moodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText fullName , email ,username , password  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Assign user variables
        fullName = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.userEmail);
        password = findViewById(R.id.password);

    }
    public void SignUp(View view){
        //Registration and create a new account
        // if the username is used make an error toast message
    }


    public void MoveToSignIn(View view ){
        Intent SignIn = new Intent(this , MainActivity.class);
        startActivity(SignIn);

    }
}
