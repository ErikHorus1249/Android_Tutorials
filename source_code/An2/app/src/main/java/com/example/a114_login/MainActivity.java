package com.example.a114_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btlLogin;
    EditText username, password;
    ArrayList<LichDay> list;

    private String sex;
    //ArrayList<HocSinh> list;

    //    FirebaseDatabase rootNode;
//    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Login
        password = (EditText) findViewById(R.id.login_password);
        username = (EditText) findViewById(R.id.tths_code);


        btlLogin = findViewById(R.id.btlLogin);
        btlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GiaoVien gv = new GiaoVien("0383939686","123456","Nguyễn Công Doanh", "GV001", "30", "Hà Nội","5A");
                //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");
                //reference.child(gv.getUsername()).setValue(gv);

                loginUser();
            }
        });
        }

    private Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Yêu cầu nhập thông tin username");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = username.getText().toString();
        if (val.isEmpty()) {
            username.setError("Yêu cầu nhập thông tin password");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }
    public void loginUser() {
        //Validate Login Info
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = username.getText().toString().trim();
        final String userEnteredPassword = password.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Teacher");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    username.setError(null);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (userEnteredPassword.equals(passwordFromDB)) {

                        //---------------------------
                        username.setError(null);
//                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
//                        String codeFromDB = dataSnapshot.child(userEnteredUsername).child("code").getValue(String.class);
//                        String addressFromDB = dataSnapshot.child(userEnteredUsername).child("address").getValue(String.class);
//                        String ageFromDB = dataSnapshot.child(userEnteredUsername).child("age").getValue(String.class);
//                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        //String classroomFromDB = dataSnapshot.child(userEnteredUsername).child("classRoom").getValue(String.class);

                        Intent intent = new Intent(MainActivity.this, home_page.class);
                        intent.putExtra("username", userEnteredUsername);
//                        intent.putExtra("nameHP", nameFromDB);
//                        intent.putExtra("classRoomHP", classroomFromDB);
//                        intent.putExtra("codeHP", codeFromDB);
//                        intent.putExtra("addressHP", addressFromDB);
//                        intent.putExtra("passwordHP", passwordFromDB);
//                        intent.putExtra("usernameHP", usernameFromDB);
//                        intent.putExtra("ageHP", ageFromDB);

                        startActivity(intent);
                    } else {
                        password.setError("Sai thông tin password!");
                        password.requestFocus();
                    }
                } else {
                    username.setError("Giáo viên không tồn tại!");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

}


