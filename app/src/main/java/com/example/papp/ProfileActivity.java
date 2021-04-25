package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText etName,etEmail,etMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.email);
        etMobile = findViewById(R.id.mobile);
    }

    @Override
    protected void onResume() { // back wela ena hema welawakama storage eken retreview krala gannawa
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = profile.getString("NAME", "");
        String email = profile.getString("EMAIL", "");
        String mobile = profile.getString("MOBILE", "");

        etName.setText(name);
        etEmail.setText(email);
        etMobile.setText(mobile);

    }

    public void clear(View v){
        etName.setText("");
        etEmail.setText("");
        etMobile.setText("");
    }

    public void save(View v){

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String mobile = etMobile.getText().toString();

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = profile.edit();

        editor.putString("Name", name);
        editor.putString("Email", email);
        editor.putString("MOBILE", mobile);
        editor.commit();

        Toast.makeText(this, "SAVED PROFILE DETAILS.", Toast.LENGTH_SHORT).show();

    }
}
