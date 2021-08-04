package com.example.tuananhb17dcatxxx.Model.B17DCATXXX;

public class B17DCATXXX_Giangvien {
    private  int ma;
    private String ten;
    private String trinhdo;
    private String nam;

    public B17DCATXXX_Giangvien(int ma, String ten, String trinhdo, String nam) {
        this.ma = ma;
        this.ten = ten;
        this.trinhdo = trinhdo;
        this.nam = nam;
    }

    public B17DCATXXX_Giangvien(String ten, String trinhdo, String nam) {
        this.ten = ten;
        this.trinhdo = trinhdo;
        this.nam = nam;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public String getNam() {
        return nam;
    }

    public String toString(){
        return "ma giang: "+ma+"\n"+
                "ten gian vien: "+ten+"\n"+
                "trinh do: "+trinhdo+"\n"+
                "nam kinh nghiem: "+nam;
    }
}
