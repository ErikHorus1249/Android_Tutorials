package com.example.a114_login;

public class HocSinh {

    public String name;
    public String code;
    public String age;
    public String address;
    public String diemdangngoi;
    public String sex;
    public String image;


    public HocSinh() {
    }

    public HocSinh(String name, String code, String age, String address, String diemdangngoi, String sex, String img) {
        this.name = name;
        this.image = img;
        this.code = code;
        this.age = age;
        this.address = address;
        this.diemdangngoi = diemdangngoi;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiemdangngoi() {
        return diemdangngoi;
    }

    public void setDiemdangngoi(String diemdangngoi) {
        this.diemdangngoi = diemdangngoi;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
