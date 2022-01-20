package com.example.keepnotesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class editnoteactivity extends AppCompatActivity {

    Intent data;
    EditText medittitleofnote, meditcontentofnote;
    FloatingActionButton msaveeditnotes;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnoteactivity);

        medittitleofnote = findViewById(R.id.edittitleofnote);
        meditcontentofnote = findViewById(R.id.editcontentofnote);
        msaveeditnotes = findViewById(R.id.saveeditnote);

        data = getIntent();

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        Toolbar toolbar = findViewById(R.id.toolbarofeditnote);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        msaveeditnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(),"savebutton click", Toast.LENGTH_SHORT).show();

                String newtitle = medittitleofnote.getText().toString();
                String newcontent = meditcontentofnote.getText().toString();

                if (newtitle.isEmpty() || newcontent.isEmpty()){

                    Toast.makeText(getApplicationContext(), "Something is Empty. Please try again", Toast.LENGTH_SHORT).show();
                    return;

                }
                else {

                    DocumentReference documentReference = firebaseFirestore.collection("notes")
                            .document(firebaseUser.getUid()).collection("myNotes")
                            .document(data.getStringExtra("noteID"));
                    Map<String, Object> note = new HashMap<>();
                    note.put("title", newtitle);
                    note.put("content", newcontent);
                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                            Toast.makeText(getApplicationContext(), "Note is Updated", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(editnoteactivity.this,noteactivity.class));


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(), "Failed to Update. Please try again", Toast.LENGTH_SHORT).show();


                        }
                    });

                }



            }
        });

        String notetitle = data.getStringExtra("title");
        String notecontent = data.getStringExtra("content");
        meditcontentofnote.setText(notecontent);
        medittitleofnote.setText(notetitle);


    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home){

            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}