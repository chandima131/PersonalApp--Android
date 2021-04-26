package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText etNote = findViewById(R.id.note_text);

        try {
            FileInputStream fis = openFileInput("myfile.txt");
            byte[] chars = new byte[fis.available()];
            fis.read(chars);
            fis.close();
            String text = new String(chars);
            etNote.setText(text);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: Failed to Read the file", Toast.LENGTH_LONG).show();
        }
    }

    public void save (View v){
        EditText etNote = findViewById(R.id.note_text);
        String text = etNote.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("myfile.txt", Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();

            Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_SHORT).show(); // user displayed msg

        }catch (Exception exception){
            exception.printStackTrace();
            Toast.makeText(this, "Error: Failed to save the file", Toast.LENGTH_LONG).show();
        }


    }
}
