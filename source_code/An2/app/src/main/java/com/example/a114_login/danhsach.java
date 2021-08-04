package com.example.a114_login;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class danhsach extends AppCompatActivity {

    ListView list;
    ArrayList<HocSinh> arrL;
    ImageView ImgIntro;
    HocSinh hs;

    private String classroom="";
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsach);

        //ListView
        hs = new HocSinh();
        list = (ListView) findViewById(R.id.lvDanhsach);
        arrL = new ArrayList<HocSinh>();
        hocsinh_adapter adapter = new hocsinh_adapter(danhsach.this, R.layout.hocsinh_list_detail,arrL);

        //
        Intent intent = getIntent();
        classroom = intent.getStringExtra("classroom");
        username = intent.getStringExtra("username");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Classroom");
        DatabaseReference ref2 = reference.child(classroom);

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    hs = ds.getValue(HocSinh.class);
                    arrL.add(hs);
                }
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position < arrL.size()){
                    DatabaseReference ref3 = ref2.child(String.valueOf(position));
                    ref3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String nameHSFromDB = snapshot.child("name").getValue(String.class);
                            String ageHSFromDB = snapshot.child("age").getValue(String.class);
                            String codeHSFromDB = snapshot.child("code").getValue(String.class);
                            String addressHSFromDB = snapshot.child("address").getValue(String.class);
                            String diemdangngoiHSFromDB = snapshot.child("diemdangngoi").getValue(String.class);
                            Intent intentHS = new Intent();

                            intentHS.setClass(view.getContext(),thongtinhocsinh.class);
                            intentHS.putExtra("username",username);
                            intentHS.putExtra("classroom",classroom);
                            intentHS.putExtra("HS_name",nameHSFromDB);
                            intentHS.putExtra("HS_code",codeHSFromDB);
                            intentHS.putExtra("HS_address",addressHSFromDB);
                            intentHS.putExtra("HS_age",ageHSFromDB);
                            intentHS.putExtra("HS_diemdangngoi",diemdangngoiHSFromDB);
                            startActivity(intentHS);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        ImgIntro = (ImageView) findViewById(R.id.logo_intro);
        ImgIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("username", username);
                intent2.setClass(danhsach.this, Intro.class);
                startActivity(intent2);
            }
        });
    }

    public void onClick(View view){
        Intent intentB = new Intent();
        intentB.putExtra("username",username);
        intentB.setClass(danhsach.this,home_page.class);
        startActivity(intentB);
    }

}
