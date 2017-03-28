package com.example.androidwarmup;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by taharushain on 3/7/17.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    ArrayList<Employee> data = new ArrayList();

    public EmployeeAdapter(@NonNull Context context,
                           @LayoutRes int resource
                            , ArrayList<Employee> data) {
        super(context, resource, data);

        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.emp_item, parent, false);
        }

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_fname = (TextView) convertView.findViewById(R.id.tv_fname);
        TextView tv_age = (TextView) convertView.findViewById(R.id.tv_age);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_profile);


        tv_name.setText(data.get(position).getName());
        tv_fname.setText(data.get(position).getFatherName());
        tv_age.setText(data.get(position).getAge()+"");
        imageView.setImageDrawable(data.get(position).getImage());


        return convertView;
    }
}
