package com.example.tuananhb17dcatxxx.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tuananhb17dcatxxx.DatabaseHelper.DatabaseHelper;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Giangvien;
import com.example.tuananhb17dcatxxx.R;

import java.util.ArrayList;

public class htGiangvien extends AppCompatActivity {

    ListView lvGV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht_giangvien);

        lvGV = findViewById(R.id.lvGV);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        ArrayList<B17DCATXXX_Giangvien> gvs = db.layGV();
        ArrayAdapter adapter = new ArrayAdapter(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                gvs
        );
        lvGV.setAdapter(adapter);
    }
}