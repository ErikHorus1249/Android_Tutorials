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

public class thongtinhocsinh extends AppCompatActivity {

    TextView txtName, txtCode, txtAdd, txtAge, txtDiem;
    ImageView ImgIntro,imgFromDB;
    private String name="";
    private  String code="";
    private String add="";
    private String age="";
    private String classroom="";
    private  String diemdangngoi="";
    Uri imageuri;
    String username;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinhocsinh);

        //Getdata
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
      classroom = intent.getStringExtra("classroom");
      name = intent.getStringExtra("HS_name");
      code = intent.getStringExtra("HS_code");
      add = intent.getStringExtra("HS_address");
      age = intent.getStringExtra("HS_age");
      diemdangngoi = intent.getStringExtra("HS_diemdangngoi");

        //anh xa
        txtName = findViewById(R.id.tths_name);
        txtCode = findViewById(R.id.tths_code);
        txtAdd = findViewById(R.id.tths_add);
        txtAge = findViewById(R.id.tths_age);
        txtDiem = findViewById(R.id.tths_diemdangngoi);
//        //Truyen data
        txtName.setText(name);
        txtCode.setText(code);
        txtAdd.setText(add);
        txtAge.setText(age);
        txtDiem.setText(diemdangngoi);

        txtDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten0 = new Intent(Intent.ACTION_PICK);
                inten0.putExtra("username",username);
                inten0.setClass(thongtinhocsinh.this, UpdatePose.class);
                startActivity(inten0);
            }
        });
        //----------
        imgFromDB = findViewById(R.id.tths_img_avatar);
        imgFromDB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1,1000);
            }
        });
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference sRef = storageReference.child("HocSinh/"+code+"/avatar.jpg");
        sRef.getDownloadUrl().addOnSuccessListener(thongtinhocsinh.this, new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(thongtinhocsinh.this).load(uri).into(imgFromDB);
            }
        });
        ////////=-------------------
        ImgIntro = findViewById(R.id.logo_intro);
        ImgIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.putExtra("username",username);
                intent2.setClass(thongtinhocsinh.this, Intro.class);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                imageuri =data.getData();
                imgFromDB.setImageURI(imageuri);
                UploadImage(imageuri);
            }
        }
    }
    public void UploadImage(Uri imageuri){
        StorageReference sRef = storageReference.child("HocSinh/"+code+"/avatar.jpg");
        sRef.putFile(imageuri).addOnSuccessListener(thongtinhocsinh.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(thongtinhocsinh.this, "Tải ảnh thành công!", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(thongtinhocsinh.this, "Tải ảnh thất bại!", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onClick(View view){
        Intent intentB = new Intent();
        intentB.setClass(thongtinhocsinh.this,danhsach.class);
        intentB.putExtra("classroom",classroom);
       intentB.putExtra("username",username);
        startActivity(intentB);
    }
}

