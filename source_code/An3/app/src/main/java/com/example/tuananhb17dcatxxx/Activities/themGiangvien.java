package com.example.tuananhb17dcatxxx.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tuananhb17dcatxxx.DatabaseHelper.DatabaseHelper;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Giangvien;
import com.example.tuananhb17dcatxxx.R;

public class themGiangvien extends AppCompatActivity {

    Button btnThem;
    EditText edTen, edNam;
    Spinner spTrinhdo;
    String[] Trinhdos = {"thac si", "tien si", "giao su", "PGS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_giangvien);

        edTen = findViewById(R.id.edTen);
        edNam = findViewById(R.id.edNam);
        btnThem = findViewById(R.id.btnThemGV);
        spTrinhdo = findViewById(R.id.spTrinhdo);

        ArrayAdapter adapter = new ArrayAdapter(
                getBaseContext(),
                android.R.layout.simple_dropdown_item_1line,
                Trinhdos
        );

        spTrinhdo.setAdapter(adapter);

        them();
    }

    public  void them(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getBaseContext());
                String ten = edTen.getText().toString().trim();
                String nam = edNam.getText().toString().trim();
                String trinhdo = spTrinhdo.getSelectedItem().toString().trim();

                if(db.themGV(new B17DCATXXX_Giangvien(ten, trinhdo, nam))){
                    Toast.makeText(getBaseContext(), "Them thanh cong "+ten, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getBaseContext(), htGiangvien.class);
                    startActivity(in);
                }else
                    Toast.makeText(getBaseContext(), "Them that bai ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}