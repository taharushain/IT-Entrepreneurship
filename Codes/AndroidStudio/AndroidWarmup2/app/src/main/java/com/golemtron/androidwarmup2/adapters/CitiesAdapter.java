package com.golemtron.androidwarmup2.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.golemtron.androidwarmup2.R;
import com.golemtron.androidwarmup2.pojo.City;
import com.golemtron.androidwarmup2.pojo.Earthquake;

import java.util.ArrayList;

/**
 * Created by taharushain on 3/17/17.
 */

public class CitiesAdapter extends ArrayAdapter<City> {

    ArrayList<City> data = new ArrayList();

    public CitiesAdapter(@NonNull Context context,
                              @LayoutRes int resource
            , ArrayList<City> data) {
        super(context, resource, data);

        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.city_item, parent, false);
        }

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_city_item_name);

        tv_name.setText("City: "+data.get(position).getName());

        return convertView;
    }
}