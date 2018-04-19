package com.example.android.m13_si3903_21_ira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText inputsearch;
    DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputsearch = findViewById(R.id.inputsearch);
        dataref = FirebaseDatabase.getInstance().getReference();
    }

    public void bukaaddentry(View view) {
        startActivity(new Intent(MainActivity.this, addentry.class));
    }

    public void lakuinpencarian(View view) {
        dataref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean check = false;
                String result = null;
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    model cur = data.getValue(model.class);
                    if (cur.getId().equals(inputsearch.getText().toString())) {
                        check  = true;
                        result = "("+cur.getId()+"=(name="+cur.getNama()+", studentid="+cur.getId()+")";
                        break;
                    }
                }

                if(check){
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Record Not Found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        inputsearch.setText(null);
    }
}