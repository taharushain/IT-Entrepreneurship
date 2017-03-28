package com.example.listviewdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taharushain on 3/6/17.
 */

public class StudentListAdapter extends ArrayAdapter<StudentItem>{

    ArrayList<StudentItem> students = new ArrayList<>();

    public StudentListAdapter(@NonNull Context context, @LayoutRes int resource,
                              ArrayList<StudentItem> students) {
        super(context, 0, students);
        this.students = students;
        Log.d("MainActivity", students.size()+"");

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.student_detail_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvGpa = (TextView) convertView.findViewById(R.id.tv_gpa);
        TextView tvFatherName = (TextView) convertView.findViewById(R.id.tv_fname);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_student_image);

        tvName.setText(students.get(position).getName());
        tvGpa.setText(students.get(position).getGpa()+"");
        tvFatherName.setText(students.get(position).getFatherName());
        imageView.setImageDrawable(
                convertView.getResources().getDrawable(R.drawable.student_image));


        return convertView;

    }

    public StudentItem getStudentItem(int index){
        return students.get(index);
    }
}
