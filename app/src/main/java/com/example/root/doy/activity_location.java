package com.example.root.doy;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by root on 16-1-12.
 */
public class activity_location extends Activity {

    private TextView textView;
    private LocationManager locationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_location);
        textView = (TextView)findViewById(R.id.text_location);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> provider_list = locationManager.getProviders(true);
        String provider;
        if(provider_list.contains(LocationManager.GPS_PROVIDER))
            provider = LocationManager.GPS_PROVIDER;
        else if(provider_list.contains(LocationManager.NETWORK_PROVIDER))
            provider = LocationManager.NETWORK_PROVIDER;
        else {
            Toast.makeText(this, "no LSB", Toast.LENGTH_SHORT).show();
            return;
        }

        Location location = locationManager.getLastKnownLocation(provider);
        if(location != null)
        {
            String pos = String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude());
            textView.setText(pos);
        }

        locationManager.requestLocationUpdates(provider, 500, 1, locationListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(locationManager != null)
            locationManager.removeUpdates(locationListener);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            String pos = String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude());
            textView.setText(pos);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
}
