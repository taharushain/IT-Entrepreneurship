package com.golemtron.androidwarmup2.adapters;

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

import com.golemtron.androidwarmup2.R;
import com.golemtron.androidwarmup2.pojo.Earthquake;

import java.util.ArrayList;

/**
 * Created by taharushain on 3/17/17.
 */

public class EarthquakesAdapter extends ArrayAdapter<Earthquake> {

    ArrayList<Earthquake> data = new ArrayList();

    public EarthquakesAdapter(@NonNull Context context,
                           @LayoutRes int resource
            , ArrayList<Earthquake> data) {
        super(context, resource, data);

        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_earthquake_item_name);

        tv_name.setText("Magnitude: "+data.get(position).getMagnitude());

        return convertView;
    }
}