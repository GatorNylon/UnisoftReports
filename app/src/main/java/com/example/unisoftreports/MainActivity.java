package com.example.unisoftreports;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.*;

import android.view.View;
import android.widget.*;
import java.sql.*;

/**
 * Jose Martin Chang
 * Main Login Page for UnisoftReports App
 */

public class MainActivity extends AppCompatActivity {

    // Declaring layout button, edit texts
    Button login;
    EditText username, password;
    ProgressBar progressBar;

    // Declaring user-input login credentials
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting values from button, texts and progress bar
        login = (Button) findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        // Action when  button login is clicked
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                user = username.getText().toString();
                pass = password.getText().toString();
                checkLogin checkLogin = new checkLogin();
                checkLogin.loginMessage(user, pass);
            }
        }
        );
    }
}