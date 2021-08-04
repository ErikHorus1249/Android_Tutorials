package com.example.a114_login;

import android.icu.text.DateFormat;

public class LichDay {
    public String code;
    public String username;
    public String thoigian;
    public String classroom;
    public String note;
    public String noidung;
    public String name;

    public LichDay(String name, String code, String thoigian, String classroom, String note, String noidung, String username) {
        this.code = code;
        this.name = name;
        this.thoigian = thoigian;
        this.classroom = classroom;
        this.note = note;
        this.noidung = noidung;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LichDay() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }



    //public Integer iconTG1, iconLH1;
    //public Date ThoiGian;
    //public CodeGV;


}
