package com.example.android.m13_si3903_21_ira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addentry extends AppCompatActivity {
    EditText entrynama, entryid;
    DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addentry);
        entrynama = findViewById(R.id.entrynama);
        entryid = findViewById(R.id.entryid);
        dataref = FirebaseDatabase.getInstance().getReference();
    }

    public void submit(View view) {
        model baru = new model(entrynama.getText().toString(), entryid.getText().toString());
        dataref.push().setValue(baru).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(addentry.this, "Record added!", Toast.LENGTH_SHORT).show();
                addentry.this.onBackPressed();
            }
        });
    }
}