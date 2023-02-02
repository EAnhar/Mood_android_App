package com.example.moodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username , password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    public void SignIn(View view) {
        GoToSetting(view);
    }
    public void MoveToSignUp(View view){
        Intent signup = new Intent(this , signup.class);
        startActivity(signup);
    }
    public void GoToSetting(View view){
        Intent setting = new Intent(this , Setting.class);
        startActivity(setting);
    }


}