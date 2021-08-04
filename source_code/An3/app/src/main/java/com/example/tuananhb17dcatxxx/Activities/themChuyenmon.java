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
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Chuyenmon;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Giangvien;
import com.example.tuananhb17dcatxxx.R;

public class themChuyenmon extends AppCompatActivity {

    Button btnThem;
    Spinner spten;
    EditText edMota;
    String[] Chuyenmon = {"Phan mem", "lap trinh nhung", "an toan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_chuyenmon);

        btnThem = findViewById(R.id.btnThemCM);
        edMota = findViewById(R.id.edMota);
        spten = findViewById(R.id.spTenCM);

        ArrayAdapter adapter = new ArrayAdapter(getBaseContext(),
                android.R.layout.simple_dropdown_item_1line,
                Chuyenmon);
        spten.setAdapter(adapter);
        them();
    }

    public  void them(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getBaseContext());
                String ten = spten.getSelectedItem().toString().trim();
                String mota = edMota.getText().toString().trim();

                if(db.themCM(new B17DCATXXX_Chuyenmon(ten, mota))){
                    Toast.makeText(getBaseContext(), "Them thanh cong "+ten, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getBaseContext(), htChuyenmon.class);
                    startActivity(in);
                }else
                    Toast.makeText(getBaseContext(), "Them that bai ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}