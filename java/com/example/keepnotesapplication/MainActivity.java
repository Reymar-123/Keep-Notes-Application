package com.example.keepnotesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.keepnotesapplication.R;
import com.example.keepnotesapplication.register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editLogEmail, editLogPassword;
    private Button loginbutton, registerbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        loginbutton = (Button) findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(this);

        registerbutton = (Button) findViewById(R.id.registerbutton);
        registerbutton.setOnClickListener(this);

        editLogEmail = (EditText) findViewById(R.id.loginemail);
        editLogPassword = (EditText) findViewById(R.id.loginpassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerbutton:
                startActivity(new Intent(this, register.class));
                break;
            case R.id.loginbutton:
                loginbutton();
                break;

        }

    }

    private void loginbutton() {

        String email = editLogEmail.getText().toString().trim();
        String password = editLogPassword.getText().toString().trim();

        if (email.isEmpty()){
            editLogEmail.setError("Email Address is required.");
            editLogEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editLogEmail.setError("Please enter a valid email.");
            editLogEmail.requestFocus();
            return;
        }


        if (password.isEmpty()){
            editLogPassword.setError("Password is required.");
            editLogPassword.requestFocus();
            return;
        }

        if (password.length()>8){
            editLogPassword.setError("Password is maximum of 8 characters.");
            editLogPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, noteactivity.class));
                    progressBar.setVisibility(View.GONE);

                }
                else{

                    Toast.makeText(MainActivity.this, "Failed to Log in. Please try again.", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }

            }
        });

    }



}