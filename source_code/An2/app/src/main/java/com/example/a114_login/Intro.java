package com.example.a114_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Intro extends AppCompatActivity {
    String username;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_app);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
    }
    public void onClick(View view){
        Intent intentB = new Intent();
        intentB.putExtra("username", username);
        intentB.setClass(Intro.this,home_page.class);
        startActivity(intentB);
    }
}

