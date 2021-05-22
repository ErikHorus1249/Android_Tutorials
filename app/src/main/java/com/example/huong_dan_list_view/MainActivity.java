package com.example.huong_dan_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView danh_sach;
    EditText nhap;
    Button nop;
    Button capNhat;
    ArrayList<String> mon_hoc;
    int vi_tri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danh_sach = (ListView) findViewById(R.id.danh_sach);
        nhap = (EditText) findViewById(R.id.text_input);
        nop = (Button) findViewById(R.id.button_nop);
        mon_hoc = new ArrayList<String>();
        capNhat = (Button) findViewById(R.id.button_capNhat);

        mon_hoc.add("math");
        mon_hoc.add("geography");
        mon_hoc.add("Chemetry");
        mon_hoc.add("Physical");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mon_hoc
        );

        danh_sach.setAdapter(adapter);

        nop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mon_hoc_input = nhap.getText().toString();
                mon_hoc.add(mon_hoc_input);
                adapter.notifyDataSetChanged();
            }
        });

        danh_sach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nhap.setText(mon_hoc.get(position));
                vi_tri = position;
            }
        });

        capNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mon_hoc_edited = nhap.getText().toString();
                mon_hoc.set(vi_tri, mon_hoc_edited);
                adapter.notifyDataSetChanged();
            }
        });
   }
}