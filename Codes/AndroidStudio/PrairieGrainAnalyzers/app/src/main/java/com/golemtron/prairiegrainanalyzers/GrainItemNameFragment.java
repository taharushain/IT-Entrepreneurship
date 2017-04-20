package com.golemtron.prairiegrainanalyzers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by taharushain on 4/18/17.
 */

public class GrainItemNameFragment extends Fragment {


    public GrainItemNameFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        String[] grainNames = getResources().getStringArray(R.array.grain_item_names);
        ListView lv = (ListView) view.findViewById(R.id.lv_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, grainNames);
//      ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_list_item, R.id.tvName, grainNames);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OnGrainItemNameSelectionChangeListener listener = (OnGrainItemNameSelectionChangeListener) getActivity();
                listener.OnSelectionChanged(position);
            }
        });


        return view;
    }







}
