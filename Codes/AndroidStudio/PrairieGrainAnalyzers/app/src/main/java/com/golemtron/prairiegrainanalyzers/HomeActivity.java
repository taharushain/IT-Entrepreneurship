package com.golemtron.prairiegrainanalyzers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by taharushain on 4/18/17.
 */

public class HomeActivity extends AppCompatActivity implements OnGrainItemNameSelectionChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void OnSelectionChanged(int grainNameIndex) {
        GrainItemDescriptionFragment descriptionFragment = (GrainItemDescriptionFragment) getSupportFragmentManager()
                .findFragmentById(R.id.description_fragment);

        descriptionFragment.setDescription(grainNameIndex);

    }
}
