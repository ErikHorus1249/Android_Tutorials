package com.example.tuananhb17dcatxxx.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Chuyenmon;
import com.example.tuananhb17dcatxxx.Model.B17DCATXXX.B17DCATXXX_Giangvien;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASAE_NAME = "NGUYENTUANANH_QUANLYGIANGVIEN";

//    CAC TRUONG CUA BANG GIANG VIEN
    private static final String GV_TABLE = "giangvien";
    private static final String GV_MA = "ma";
    private static final String GV_TEN = "ten";
    private static final String GV_TRINHDO = "trinhdo";
    private static final String GV_NAM = "nam";

//    CAC TRUONG CHO BANG CHUYEN MON
    private static final String CM_TABLE = "chuyenmon";
    private static final String CM_MA = "ma";
    private static final String CM_TEN = "ten";
    private static final String CM_MOTA = "mota";


    public DatabaseHelper( Context context) {
        super(context, DATABASAE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE "+GV_TABLE+" ( "+
                GV_MA + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                GV_TEN + " TEXT , "+
                GV_TRINHDO + " TEXT , "+
                GV_NAM + " TEXT )";

        String sql2 = "CREATE TABLE "+CM_TABLE+" ( "+
                CM_MA + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                CM_TEN + " TEXT , "+
                CM_MOTA + " TEXT )";

        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql2 = "DROP TABLE IF EXISTS "+CM_TABLE;
        String sql1 = "DROP TABLE IF EXISTS "+GV_TABLE;

        onCreate(db);
    }

    public  boolean themGV(B17DCATXXX_Giangvien gv){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GV_TEN, gv.getTen());
        values.put(GV_TRINHDO, gv.getTrinhdo());
        values.put(GV_NAM, gv.getNam());

        long check = db.insert(GV_TABLE, null, values);
        if(check != -1) return  true;
        else return false;
    }

    public ArrayList<B17DCATXXX_Giangvien> layGV(){
        ArrayList<B17DCATXXX_Giangvien> gvs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+GV_TABLE;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            B17DCATXXX_Giangvien gv = new B17DCATXXX_Giangvien(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));

            gvs.add(gv);
        }

        return  gvs;
    }

    public  boolean themCM(B17DCATXXX_Chuyenmon cm){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CM_TEN, cm.getTen());
        values.put(CM_MOTA, cm.getMota());

        long check = db.insert(CM_TABLE, null, values);
        if(check != -1) return  true;
        else return false;
    }

    public ArrayList<B17DCATXXX_Chuyenmon> laCM(){
        ArrayList<B17DCATXXX_Chuyenmon> cms = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+CM_TABLE;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            B17DCATXXX_Chuyenmon cm = new B17DCATXXX_Chuyenmon(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));

            cms.add(cm);
        }

        return  cms;
    }
}
