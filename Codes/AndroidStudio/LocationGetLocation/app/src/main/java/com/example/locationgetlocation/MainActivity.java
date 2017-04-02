package com.example.locationgetlocation;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import static android.support.v4.content.PermissionChecker.PERMISSION_DENIED;
import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;

    private long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */

    private TextView tvLng;
    private TextView tvLat;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int permissionFineLocationCheck = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionFineLocationCheck == PERMISSION_GRANTED) {

            permissionsAvailable();

        } else {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }


        tvLat = (TextView) findViewById(R.id.tvLat);
        tvLng = (TextView) findViewById(R.id.tvLng);
    }

    private void permissionsAvailable() {
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    protected void onStart() {
        if(mGoogleApiClient!=null)
            mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);

        // only stop if it's connected, otherwise we crash
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        // Get last known recent location.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        // Note that this can be NULL if last location isn't already known.
        if (mCurrentLocation != null) {
            // Print current location if not null
            Log.d("DEBUG", "current location: " + mCurrentLocation.toString());
            LatLng latLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
            tvLat.setText(latLng.latitude+"");
            tvLng.setText(latLng.longitude+"");

        }
        // Begin polling for new location updates.
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        if (i == CAUSE_SERVICE_DISCONNECTED) {
            Toast.makeText(this, "Disconnected. Please re-connect.", Toast.LENGTH_SHORT).show();
        } else if (i == CAUSE_NETWORK_LOST) {
            Toast.makeText(this, "Network lost. Please re-connect.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void startLocationUpdates() {
        // Create the location request
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                mLocationRequest, this);

    }


    @Override
    public void onLocationChanged(Location location) {
        // New location has now been determined
        String msg = "Updated Location: " +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        // You can now create a LatLng Object for use with maps
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        tvLat.setText(latLng.latitude+"");
        tvLng.setText(latLng.longitude+"");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    permissionsAvailable();
                    if (!mGoogleApiClient.isConnected() && !mGoogleApiClient.isConnecting())
                        mGoogleApiClient.connect();

                } else {
                    finish();
                }
                return;
            }
        }
    }
}