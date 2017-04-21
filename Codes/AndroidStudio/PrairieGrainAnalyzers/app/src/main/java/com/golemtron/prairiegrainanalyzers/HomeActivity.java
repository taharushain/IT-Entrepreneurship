package com.golemtron.prairiegrainanalyzers;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by taharushain on 4/18/17.
 */

public class HomeActivity extends AppCompatActivity implements OnGrainItemNameSelectionChangeListener{

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void OnSelectionChanged(int grainNameIndex) {
        GrainItemDescriptionFragment descriptionFragment = (GrainItemDescriptionFragment) getSupportFragmentManager()
                .findFragmentById(R.id.description_fragment);

        descriptionFragment.setDescription(grainNameIndex);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Snackbar.make(toolbar,"Settigns Clicked",Snackbar.LENGTH_SHORT).show();

            return true;
        }else if(id == R.id.action_previous_results){
            Snackbar.make(toolbar, "Previous Results Clicked",Snackbar.LENGTH_SHORT).show();

        }else if(id == R.id.action_read_id){
            Snackbar.make(toolbar, "Read ID Clicked",Snackbar.LENGTH_SHORT).show();

        }



        return super.onOptionsItemSelected(item);
    }
}
