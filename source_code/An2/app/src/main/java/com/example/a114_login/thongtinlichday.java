package com.example.a114_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class thongtinlichday extends AppCompatActivity {

    TextView txtClassroom, txtName, txtCode, txtTime, txtNoidung;
    String classroom, name, code, thoigian, noidung, username;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lich_day);

        //ãnhxaa
        txtClassroom = findViewById(R.id.lichday_classroom);
        txtName = findViewById(R.id.lichday_tenMH);
        txtCode = findViewById(R.id.lichday_codeMH);
        txtTime = findViewById(R.id.lichday_thoigianMH);
        txtNoidung = findViewById(R.id.lichday_noidung);


        //getdata
        Intent intent = getIntent();
        classroom = intent.getStringExtra("classroom");
        name = intent.getStringExtra("MH_name");
        code = intent.getStringExtra("MH_code");
        thoigian = intent.getStringExtra("MH_thoigian");
        noidung = intent.getStringExtra("MH_noidung");
        username = intent.getStringExtra("username");
        //
        txtNoidung.setText(noidung);
        txtTime.setText(thoigian);
        txtCode.setText(code);
        txtName.setText(name);
        txtClassroom.setText("Lớp "+classroom);
    }
    public void onClick(View view){
        Intent intentB = new Intent();
        intentB.putExtra("username",username);
        intentB.setClass(thongtinlichday.this,home_page.class);
        startActivity(intentB);
    }
}
