package com.example.tuananhb17dcatxxx.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tuananhb17dcatxxx.R;

public class MainActivity extends AppCompatActivity {

    Button btnGV, btnCM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGV = findViewById(R.id.btnGV);
        btnCM = findViewById(R.id.btnCM);

        themGV();
        themCM();
    }

    public  void themGV(){
        btnGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), themGiangvien.class);
                startActivity(in);
            }
        });
    }

    public  void themCM(){
        btnCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), themChuyenmon.class);
                startActivity(in);
            }
        });
    }
}