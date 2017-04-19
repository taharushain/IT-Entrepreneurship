package com.golemtron.prairiegrainanalyzers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by taharushain on 4/18/17.
 */


public class GrainItemDescriptionFragment extends Fragment {

    final static String KEY_POSITION = "position";
    int mCurrentPosition = -1;

    String[] mGrainDescriptions;
    TextView mGrainDescriptionTextView;

    public GrainItemDescriptionFragment(){

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGrainDescriptions = getResources().getStringArray(R.array.grain_item_descriptions);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if (savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(KEY_POSITION);
        }


        View view = inflater.inflate(R.layout.fragment_description, container, false);

        mGrainDescriptionTextView = (TextView) view.findViewById(R.id.grain_description);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();


        Bundle args = getArguments();
        if (args != null){
            setDescription(args.getInt(KEY_POSITION));
        } else if(mCurrentPosition != -1){
            setDescription(mCurrentPosition);
        }
    }

    public void setDescription(int descriptionIndex){
        mGrainDescriptionTextView.setText(mGrainDescriptions[descriptionIndex]);
        mCurrentPosition = descriptionIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_POSITION,mCurrentPosition);
    }
}