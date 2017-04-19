package com.golemtron.prairiegrainanalyzers;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by taharushain on 4/18/17.
 */

public class GrainItemNameFragment extends ListFragment {


    public GrainItemNameFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] grainNames = getResources().getStringArray(R.array.grain_item_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, grainNames);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OnGrainItemNameSelectionChangeListener listener = (OnGrainItemNameSelectionChangeListener) getActivity();
        listener.OnSelectionChanged(position);
    }
}
