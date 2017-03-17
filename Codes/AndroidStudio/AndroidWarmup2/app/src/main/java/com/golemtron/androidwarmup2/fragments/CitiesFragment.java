package com.golemtron.androidwarmup2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.golemtron.androidwarmup2.R;
import com.golemtron.androidwarmup2.adapters.CitiesAdapter;
import com.golemtron.androidwarmup2.pojo.City;
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

public class CitiesFragment extends Fragment{

    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onResume() {
        listView = (ListView) getActivity().findViewById(R.id.listViewCities);
        sendVolleyRequest();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        super.onResume();
    }


    private void sendVolleyRequest() {
        final ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());

        String url = Constants.city_url;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        CitiesAdapter cityAdapter = new CitiesAdapter(
                                getContext(),
                                0,
                                handleResponse(response));
                        progressBar.setVisibility(View.INVISIBLE);
                        listView.setAdapter(cityAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private ArrayList<City> handleResponse(String response) {
        ArrayList<City> cities = new ArrayList<>();


        try {
            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();

            JSONArray jsonArray = jsonObject.getJSONArray(Constants.CITY_KEY);

            for(int i=0; i< jsonArray.length(); i++){
                JSONObject innerJsonObject = (JSONObject) jsonArray.get(i);

                City city = new City();

                city.setLng(Float.parseFloat(innerJsonObject.getString("lng")));
                city.setGeonameId(innerJsonObject.getInt("geonameId"));
                city.setName(innerJsonObject.getString("name"));
                city.setFclName(innerJsonObject.getString("fclName"));
                city.setToponymName(innerJsonObject.getString("toponymName"));
                city.setFcodeName(innerJsonObject.getString("fcodeName"));
                city.setWikipedia(innerJsonObject.getString("wikipedia"));
                city.setLat((float)(innerJsonObject.getDouble("lat")));
                city.setFcl(innerJsonObject.getString("fcl"));
                city.setPopulation(innerJsonObject.getLong("population"));
                city.setFcode(innerJsonObject.getString("fcode"));

                cities.add(city);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return cities;
    }


}
