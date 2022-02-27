package com.example.keepnotesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class sync_acc extends AppCompatActivity {

    EditText syncUsername, syncEmail, syncPassword;
    Button syncButton;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_acc);
        getSupportActionBar().setTitle("Sync Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        syncUsername  = findViewById(R.id.syncusername);
        syncEmail  = findViewById(R.id.syncemail);
        syncPassword = findViewById(R.id.syncpassword);

        syncButton = findViewById(R.id.syncbutton);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = syncUsername.getText().toString();
                String email = syncEmail.getText().toString();
                String password = syncPassword.getText().toString();

                if (name.isEmpty()){
                    syncUsername.setError("Username is required.");
                    syncUsername.requestFocus();
                    return;
                }
                if (!name.matches("[a-z,A-Z, .]*")){
                    syncUsername.setError("Enter Characters only.");
                    syncUsername.requestFocus();
                    return;
                }


                if (email.isEmpty()){
                    syncEmail.setError("Email Address is required.");
                    syncEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    syncEmail.setError("Please enter a valid email.");
                    syncEmail.requestFocus();
                    return;
                }


                if (password.isEmpty()){
                    syncPassword.setError("Password is required.");
                    syncPassword.requestFocus();
                    return;
                }
                if (password.length()>8){
                    syncPassword.setError("Password is maximum of 8 characters.");
                    syncPassword.requestFocus();
                    return;
                }

                progressBar.setVisibility(view.GONE);

                AuthCredential credential = EmailAuthProvider.getCredential(email, password);
                firebaseAuth.getCurrentUser().linkWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(sync_acc.this, "Notes are Synced.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), noteactivity.class));

                        FirebaseUser usr = firebaseAuth.getCurrentUser();
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .build();
                        usr.updateProfile(request);

                        startActivity(new Intent(getApplicationContext(), noteactivity.class));

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(sync_acc.this, "Failed to connect. Try Again.", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(this, noteactivity.class));
        finish();
        return super.onOptionsItemSelected(item);
    }
}