package com.example.a114_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class hocsinh_adapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<HocSinh> myList;

    public hocsinh_adapter(Context context, int layout, List<HocSinh> listHS) {
        myContext = context;
        myLayout = layout;
        myList = listHS;
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
        TextView TenHS = (TextView) convertView.findViewById(R.id.TenHS);
        TenHS.setText(myList.get(position).getName().toString());
        TextView MaHS = (TextView) convertView.findViewById(R.id.MaHS);
        MaHS.setText(myList.get(position).getCode().toString());
        TextView Diem = (TextView) convertView.findViewById(R.id.listview_diem);
        Diem.setText(myList.get(position).getDiemdangngoi().toString());
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.image_iconHS);
        imgIcon.setImageResource(R.mipmap.icon_logo_main1_foreground);

        return convertView;
    }
}
