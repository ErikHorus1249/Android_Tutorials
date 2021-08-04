package com.example.a114_login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class home_page extends AppCompatActivity {
    TextView name,mgv;
    Button btl_Danhsach;
    ListView list_LH;
    ArrayList<LichDay> listLD;
    CardView cardView;
    ImageView ImgIntro;
    String nameFromDB ;
    String codeFromDB ;
    String addressFromDB;
    String ageFromDB ;
    String classroom ;
    String username;
    String passwordFromDB;
    ImageView imgFromDB;
    LichDay lichday;
    //private final GiaoVien giaoVien;

    GiaoVien gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_manage);
        Log.e("HP: ","oncreat");
        //Lấy và hiện thị các thông tin từ login
        name = (TextView) findViewById(R.id.homepage_name);
        mgv = (TextView) findViewById(R.id.homepage_mgv);
        imgFromDB = (ImageView)findViewById(R.id.tths_img_avatar);


//        nameFromLogin =intent.getStringExtra("nameHP");
//        mgvFromLogin = intent.getStringExtra("codeHP");
//        addFromLogin = intent.getStringExtra("addressHP");
//        usernameFromLogin = intent.getStringExtra("usernameHP");
//        passFromLogin = intent.getStringExtra("passwordHP");
//        ageFromLogin = intent.getStringExtra("ageHP");

        //GET DATA
        Intent intent = getIntent();
        username  = intent.getStringExtra("username");
        Log.e("Check: ", username);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");
        DatabaseReference ref2 = reference.child(username);
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameFromDB = dataSnapshot.child("name").getValue(String.class);
                codeFromDB = dataSnapshot.child("code").getValue(String.class);
                addressFromDB = dataSnapshot.child("address").getValue(String.class);
                ageFromDB = dataSnapshot.child("age").getValue(String.class);
                classroom = dataSnapshot.child("classRoom").getValue(String.class);
                passwordFromDB = dataSnapshot.child("password").getValue(String.class);
                name.setText(nameFromDB);
                mgv.setText(codeFromDB);
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference sRef = storageReference.child("GiaoVien/"+username+"/avatar");
        sRef.getDownloadUrl().addOnSuccessListener(home_page.this, new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(home_page.this).load(uri).into(imgFromDB);
            }
        });



        //Image_logo_intro
        ImgIntro = (ImageView) findViewById(R.id.logo_intro);
        ImgIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("username",username);
                intent2.setClass(home_page.this, Intro.class);
                startActivity(intent2);
            }
        });
        //log();

        danhsach();
        listview();
        onclickcardview();
    }

//    void log(){
//        Log.e("check: ",nameFromLogin);
//        Log.e("check: ",mgvFromLogin);
//        Log.e("check: ",addFromLogin);
//        Log.e("check: ",usernameFromLogin);
//        Log.e("check: ",passFromLogin);
//        Log.e("check: ",ageFromLogin);
//        Log.e("check: ",classFromLogin);
//    }
    void danhsach(){
        btl_Danhsach = findViewById(R.id.btlDanhsach);
        btl_Danhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, danhsach.class);
                intent.putExtra("classroom", classroom);
                intent.putExtra("username",username);
//                        intent.putExtra("nameHP", nameFromDB);
//                        intent.putExtra("classRoomHP", classroomFromDB);
//                        intent.putExtra("codeHP", codeFromDB);
//                        intent.putExtra("addressHP", addressFromDB);
//                        intent.putExtra("passwordHP", passwordFromDB);
//                        intent.putExtra("usernameHP", usernameFromDB);
//                        intent.putExtra("ageHP", ageFromDB);
                startActivity(intent);
            }
        });
    }

    void onclickcardview(){
        //Cardview
        cardView = findViewById(R.id.hp_cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(home_page.this,thongtinGiaoVien.class);
                intent2.putExtra("classroom", classroom);
                intent2.putExtra("username", username);
                intent2.putExtra("code", codeFromDB);
                intent2.putExtra("address", addressFromDB);
                intent2.putExtra("password", passwordFromDB);
                intent2.putExtra("name", nameFromDB);
                intent2.putExtra("age", ageFromDB);
                startActivity(intent2);
            }
        });
    }

    void listview(){
        //ListView
        list_LH = (ListView) findViewById(R.id.list_lichhoc);
        listLD = new ArrayList<LichDay>();
        lichday_adapter adapter = new lichday_adapter(home_page.this, R.layout.lich_day_chi_tiet,listLD);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("LichDay");
        DatabaseReference ref2 = reference.child(username);

        lichday = new LichDay();
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ld : snapshot.getChildren()){
                    lichday = ld.getValue(LichDay.class);
                    listLD.add(lichday);
                }
                list_LH.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list_LH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position < listLD.size()){
                    DatabaseReference ref3 = ref2.child(String.valueOf(position));
                    ref3.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String nameMHFromDB = snapshot.child("name").getValue(String.class);
                            String classroomMHFromDB = snapshot.child("classroom").getValue(String.class);
                            String codeMHFromDB = snapshot.child("code").getValue(String.class);
                            String noidungMHFromDB = snapshot.child("noidung").getValue(String.class);
                            String thoigianMHFromDB = snapshot.child("thoigian").getValue(String.class);
                            String noteMHFromDB = snapshot.child("note").getValue(String.class);

                            Intent intentHS = new Intent();
                            intentHS.setClass(view.getContext(),thongtinlichday.class);
                            intentHS.putExtra("username",username);
                            intentHS.putExtra("classroom",classroomMHFromDB);
                            intentHS.putExtra("MH_name",nameMHFromDB);
                            intentHS.putExtra("MH_code",codeMHFromDB);
                            intentHS.putExtra("MH_noidung",noidungMHFromDB);
                            intentHS.putExtra("MH_note",noidungMHFromDB);
                            intentHS.putExtra("MH_thoigian",thoigianMHFromDB);
                            startActivity(intentHS);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
    }

}
