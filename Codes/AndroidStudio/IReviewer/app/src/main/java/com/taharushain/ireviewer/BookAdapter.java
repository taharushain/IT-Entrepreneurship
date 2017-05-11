package com.taharushain.ireviewer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taharushain on 5/11/17.
 */

class BookAdapter extends ArrayAdapter<Book> {

    ArrayList<Book> data = new ArrayList();

    public BookAdapter(@NonNull Context context,
                              @LayoutRes int resource
            , ArrayList<Book> data) {
        super(context, resource, data);

        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_item, parent, false);
        }

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_book_item_name);

        tv_name.setText("Book: "+data.get(position).getName());

        return convertView;
    }
}