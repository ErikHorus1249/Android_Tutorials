package com.example.a114_login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class thongtinGiaoVien extends AppCompatActivity {
    ImageView ImgIntro1;
    ImageView imageFromDB;
    TextView txtName, txtCode, txtClass, txtUsername, txtPass, txtAge, txtAdd;
    String classroom;
    String nameFromDB, codeFromDB,addressFromDB,ageFromDB,usernameFromDB,passFromDB;
    Uri imageuri;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtingiaovien);
        //Sotragd
        storageReference = FirebaseStorage.getInstance().getReference();

        //get data
        Intent intent = getIntent();
        nameFromDB = intent.getStringExtra("name");
        codeFromDB = intent.getStringExtra("code");
        addressFromDB = intent.getStringExtra("address");
        ageFromDB = intent.getStringExtra("age");
        usernameFromDB = intent.getStringExtra("username");
        passFromDB = intent.getStringExtra("password");
        classroom = intent.getStringExtra("classroom");

        ImgIntro1 = (ImageView) findViewById(R.id.logo_intro);
        ImgIntro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("username",usernameFromDB);
                intent2.setClass(thongtinGiaoVien.this, Intro.class);
                startActivity(intent2);
            }
        });
        txtName = findViewById(R.id.ttgv_name);
        txtCode = findViewById(R.id.ttgv_code);
        txtClass = findViewById(R.id.ttgv_classroom);
        txtUsername = findViewById(R.id.lichday_tenMH);
        txtPass = findViewById(R.id.lichday_codeMH);
        txtAge = findViewById(R.id.lichday_thoigianMH);
        txtAdd = findViewById(R.id.lichday_noidung);
        imageFromDB = findViewById(R.id.tths_img_avatar);

        //anh xa

        txtName.setText(nameFromDB);
        txtCode.setText(codeFromDB);
        txtClass.setText(classroom);
        txtUsername.setText(usernameFromDB);
        txtPass.setText(passFromDB);
        txtAge.setText(ageFromDB);
        txtAdd.setText(addressFromDB);
        //Avatar
        imageFromDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1,1000);
            }
        });
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference sRef = storageReference.child("GiaoVien/"+usernameFromDB+"/avatar");
        sRef.getDownloadUrl().addOnSuccessListener(thongtinGiaoVien.this, new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(thongtinGiaoVien.this).load(uri).into(imageFromDB);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                imageuri =data.getData();
                imageFromDB.setImageURI(imageuri);
                UploadImage(imageuri);
            }
        }
    }
    public void UploadImage(Uri imageuri){
        StorageReference sRef = storageReference.child("GiaoVien/"+usernameFromDB+"/avatar");
        sRef.putFile(imageuri).addOnSuccessListener(thongtinGiaoVien.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(thongtinGiaoVien.this, "Tải ảnh thành công!", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(thongtinGiaoVien.this, "Tải ảnh thất bại!", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Get data từ Homepage

    public void onClick(View view){
        Intent intentB = new Intent();
        intentB.putExtra("username",usernameFromDB);
        intentB.setClass(thongtinGiaoVien.this,home_page.class);
        startActivity(intentB);
    }

}

