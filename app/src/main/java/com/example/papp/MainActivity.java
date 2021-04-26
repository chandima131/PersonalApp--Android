package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        TextView tvTitle = findViewById(R.id.title);
        String name = profile.getString("NAME", "Guest");
        tvTitle.setText("WELCOME" + name);
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

    public void newNotes(View v){
        Intent intent = new Intent( this, NewNoteActivity.class);
        startActivity(intent);
    }
}
