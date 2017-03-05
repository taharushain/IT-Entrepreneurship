package com.example.listviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taharushain on 3/5/17.
 */

public class StudentListAdapter extends ArrayAdapter<StudentItem> {

    private ArrayList<StudentItem> users = new ArrayList<>();

    public StudentListAdapter(Context context, ArrayList<StudentItem> users) {
        super(context, 0, users);
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(users.get(position).getName());
        return convertView;
    }

    public StudentItem getStudent(int position){
        return users.get(position);
    }


}
