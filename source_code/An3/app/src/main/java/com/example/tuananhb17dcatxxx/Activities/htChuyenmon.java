package com.example.tuananhb17dcatxxx.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tuananhb17dcatxxx.DatabaseHelper.DatabaseHelper;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Chuyenmon;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Giangvien;
import com.example.tuananhb17dcatxxx.R;

import java.util.ArrayList;

public class htChuyenmon extends AppCompatActivity {

    ListView lvCM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ht_chuyenmon);

        lvCM = findViewById(R.id.lvCM);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        ArrayList<B17DCATXXX_Chuyenmon> cms = db.laCM();
        ArrayAdapter adapter = new ArrayAdapter(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                cms
        );
        lvCM.setAdapter(adapter);
    }
}