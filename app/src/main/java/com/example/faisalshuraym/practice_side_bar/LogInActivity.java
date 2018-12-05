package com.example.faisalshuraym.practice_side_bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseUsers;
    boolean success = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void onClick(View view) {
        database = FirebaseDatabase.getInstance();
        databaseUsers = database.getReference("Users");
        EditText emailText = (EditText) findViewById(R.id.editText);
        final String inputEmail = emailText.getText().toString();
        EditText phoneText = (EditText)findViewById(R.id.editText6);
        final String inputPhone = phoneText.getText().toString();
        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Get value from firebase.
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()){
                    User user = orderSnapshot.getValue(User.class);
                    if(user.getEmail().equals(inputEmail) && user.getPhone().equals(inputPhone)){
                        success = true;

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value


            }
        });

        if(success){
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
    }
}
