package com.golemtron.prairiegrainanalyzers;

import android.graphics.Typeface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taharushain on 4/18/17.
 */


public class GrainItemDescriptionFragment extends Fragment {

    final static String KEY_POSITION = "position";
    int mCurrentPosition = -1;

    private String[] mGrainDescriptions;
    private TextView mGrainDescriptionTextView;
    private PieChart chart;

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

//        mGrainDescriptionTextView = (TextView) view.findViewById(R.id.grain_description);
        chart = (PieChart) view.findViewById(R.id.chart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(30.8f, "Blue"));

        PieDataSet set = new PieDataSet(entries, "Election Results");
        PieData data = new PieData(set);
        set.setDrawIcons(false);
        set.setSliceSpace(3f);
        set.setIconsOffset(new MPPointF(0, 40));
        set.setSelectionShift(5f);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        set.setColors(new int[] { R.color.colorAccent, R.color.colorPrimary}, getContext());
        styleChar();
        chart.setData(data);
        chart.setDrawSlicesUnderHole(true);
        chart.invalidate(); // refresh

        return view;
    }

    private void styleChar() {
        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);

        chart.setDragDecelerationFrictionCoef(0.95f);

        chart.setCenterText("SAMPLE");

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.WHITE);

        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);

        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);

        chart.setDrawCenterText(true);

        chart.setRotationAngle(0);
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);


        chart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);


        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(12f);
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