package com.example.tuananhb17dcatxxx.Model.B17DCATXXX;

public class B17DCATXXX_Chuyenmon {
    private int ma;
    private String ten;
    private String mota;

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public B17DCATXXX_Chuyenmon(String ten, String mota) {
        this.ten = ten;
        this.mota = mota;
    }

    public B17DCATXXX_Chuyenmon(int ma, String ten, String mota) {
        this.ma = ma;
        this.ten = ten;
        this.mota = mota;
    }

    public String toString(){
        return "ma chuyen mon: "+ma+"\n"+
                "ten chuyen mon: "+ten+"\n"+
                "mo ta: "+mota;
    }
}
