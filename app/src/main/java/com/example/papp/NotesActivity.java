package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        File folder = getFilesDir();
        String[] files = folder.list();

        ListView lvNotes = findViewById(R.id.notes_list);

        int layout = android.R.layout.simple_list_item_1;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,layout,files);
        lvNotes.setAdapter(adapter);

        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                String name = tv.getText().toString();

                Intent intent = new Intent(NotesActivity.this, ViewNoteActivity.class);
                intent.putExtra("NAME", name);
                startActivity(intent);

            }
        });
    }
}
