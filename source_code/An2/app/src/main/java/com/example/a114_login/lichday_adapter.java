package com.example.a114_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class lichday_adapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<LichDay> myList;

    public lichday_adapter(Context context, int layout, List<LichDay> listLD) {
       myContext = context;
       myLayout = layout;
       myList = listLD;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);
        //Anh xa
        TextView TenMH = (TextView) convertView.findViewById(R.id.tenMonHoc);
        TenMH.setText(myList.get(position).getName().toString());
        TextView ThoiGianMH = (TextView) convertView.findViewById(R.id.thoigianMonHoc);
        ThoiGianMH.setText(myList.get(position).getThoigian().toString());
        TextView LopHoc = (TextView) convertView.findViewById(R.id.lopHoc);
        LopHoc.setText(myList.get(position).getClassroom().toString());
        return convertView;
    }
}
