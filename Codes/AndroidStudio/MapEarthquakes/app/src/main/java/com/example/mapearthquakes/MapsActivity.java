package com.example.mapearthquakes;

import android.provider.SyncStateContract;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

import static android.R.attr.data;
import static java.security.AccessController.getContext;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private ArrayList<LatLng> places = new ArrayList<>();
    private GoogleMap mMap;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        sendVolleyRequest();
    }

    private void sendVolleyRequest() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=taharushain";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handleResponse(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void handleResponse(String response) {
        String EARTHQUAKE_KEY = "earthquakes";

        try {
            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();

            JSONArray jsonArray = jsonObject.getJSONArray(EARTHQUAKE_KEY);

            for(int i=0; i< jsonArray.length(); i++){
                JSONObject innerJsonObject = (JSONObject) jsonArray.get(i);

                LatLng earthquake = new LatLng(
                        Double.parseDouble(innerJsonObject.get("lat").toString()),
                        Double.parseDouble(innerJsonObject.get("lng").toString()));

                places.add(earthquake);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        updateMap();

    }

    private void updateMap() {
        mMap.clear();
        for(LatLng latLng: places){
            MarkerOptions marker = new MarkerOptions();
            marker.position(latLng);
            mMap.addMarker(marker);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(places.get(places.size()-1)));
        mMap.setMinZoomPreference(4);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
