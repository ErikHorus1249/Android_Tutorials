package com.example.a114_login;

import androidx.annotation.NonNull;

public class GiaoVien {
    public String username;
    public String password;

    public String name;
    public String code;
    public String age;
    public String address;
    public String classRoom;
    public String image;

    public GiaoVien(String username, String password, String name, String code, String age, String address, String classRoom, String img) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.code = code;
        this.age = age;
        this.address = address;
        this.classRoom = classRoom;
        this.image = img;
        //ImgAvatar = imgAvatar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setClassRoom(String classRoom) {
        classRoom = classRoom;
    }

//    public int getImgAvatar() {
//        return ImgAvatar;
//    }
//
//    public void setImgAvatar(int imgAvatar) {
//        ImgAvatar = imgAvatar;
//    }

    public void setAddress(String address) {
        address = address;
    }
    public String getClassRoom() {
        return classRoom;
    }
}
