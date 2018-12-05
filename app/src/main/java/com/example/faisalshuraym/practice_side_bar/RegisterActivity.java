package com.example.faisalshuraym.practice_side_bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickSaveUser(View view){
        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("Users");
        EditText emailEdit = findViewById(R.id.editText9);
        EditText phoneEdit = findViewById(R.id.editText3);
        User user = new User(emailEdit.getText().toString(),phoneEdit.getText().toString());
        databaseUsers.setValue(user);
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
}
