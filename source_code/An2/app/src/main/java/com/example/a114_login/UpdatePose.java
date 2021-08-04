package com.example.a114_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdatePose extends AppCompatActivity {
//    khai bao thanh phan su dung
    Button btnUpdate, btnView;
    ImageView ivPose;
    private static final  int IMAGE_REQUEST = 1;
    String currentImgPath = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_pose);

//        anh xa
        btnUpdate = (Button) findViewById(R.id.button_capnhat);
        btnView = (Button) findViewById(R.id.button_view);
        ivPose = (ImageView) findViewById(R.id.imageView_pose);

//        su kien
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void updatePose(View view){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(cameraIntent.resolveActivity(getPackageManager()) != null){

            File imageFile = null;

            try {
                imageFile = getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(imageFile != null){
                Uri imageUri = FileProvider.getUriForFile(this, "com.example.filprovider", imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                startActivit
            }

        }

    }

    public void viewPose(View view){

    }

    private File getImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "jpg"+timestamp+"_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File imageFile = File.createTempFile(imageName, "jpg", storageDir);
        currentImgPath = imageFile.getAbsolutePath();

        return imageFile;

    }
}