package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notes(View v){
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }
    public void expenses(View v){
        Intent intent = new Intent(this, ExpensesActivity.class);
        startActivity(intent);
    }
    public void tasks(View v){
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }
    public void profile(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
