package com.golemtron.androidwarmup2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.golemtron.androidwarmup2.R;
import com.golemtron.androidwarmup2.activities.EarthDetailsActivity;
import com.golemtron.androidwarmup2.adapters.EarthquakesAdapter;
import com.golemtron.androidwarmup2.pojo.Earthquake;
import com.golemtron.androidwarmup2.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

/**
 * Created by taharushain on 3/17/17.
 */

public class EarthquakeFragment extends Fragment{

    ListView listView;
    ArrayList<Earthquake> data = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        listView = (ListView) getActivity().findViewById(R.id.listViewEartquake);
//        sendVolleyRequest();

        return inflater.inflate(R.layout.fragment_earthquake, container, false);
    }

    @Override
    public void onResume() {
        listView = (ListView) getActivity().findViewById(R.id.listViewEartquake);
        sendVolleyRequest();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), EarthDetailsActivity.class);
                Bundle bundle = new Bundle();
                Earthquake earthquake = data.get(position);

                bundle.putString("datetime",earthquake.getDatetime());
                bundle.putString("eqid",earthquake.getEqid());
                bundle.putString("src",earthquake.getSrc());
                bundle.putFloat("depth",earthquake.getDepth());
                bundle.putFloat("lat",earthquake.getLat());
                bundle.putFloat("lng",earthquake.getLng());
                bundle.putFloat("magnitude",earthquake.getMagnitude());

                intent.putExtra("earthquake", bundle);

                startActivity(intent);


            }
        });

        super.onResume();
    }

    private void sendVolleyRequest() {
        final ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());

        String url = Constants.earthquake_url;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        data = handleResponse(response);
                        EarthquakesAdapter earthquakesAdapter = new EarthquakesAdapter(
                                getContext(),
                                0,
                                data);
                        progressBar.setVisibility(View.INVISIBLE);
                        listView.setAdapter(earthquakesAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private ArrayList<Earthquake> handleResponse(String response) {
        ArrayList<Earthquake> earthquakes = new ArrayList<>();


        try {
            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();

            JSONArray jsonArray = jsonObject.getJSONArray(Constants.EARTHQUAKE_KEY);

            for(int i=0; i< jsonArray.length(); i++){
                JSONObject innerJsonObject = (JSONObject) jsonArray.get(i);

                Earthquake earthquake = new Earthquake();

                earthquake.setDatetime(innerJsonObject.get("datetime").toString());
                earthquake.setDepth
                        (Float.parseFloat(innerJsonObject.get("depth").toString()));
                earthquake.setLng
                        (Float.parseFloat(innerJsonObject.get("lng").toString()));
                earthquake.setSrc(innerJsonObject.get("src").toString());
                earthquake.setEqid(innerJsonObject.get("eqid").toString());
                earthquake.setMagnitude(Float.parseFloat(innerJsonObject.get("magnitude").toString()));
                earthquake.setLat(Float.parseFloat(innerJsonObject.get("lat").toString()));


                earthquakes.add(earthquake);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return earthquakes;
    }

}
