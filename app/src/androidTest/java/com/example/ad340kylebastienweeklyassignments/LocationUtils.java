package com.example.ad340kylebastienweeklyassignments;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;

import com.google.android.gms.location.LocationServices;

public class LocationUtils {
    public static void startUpdates(
            final Activity activity, final Handler mHandler, final double latitude, final double longitude) {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Location mockLocation = new Location(LocationManager.GPS_PROVIDER);
                mockLocation.setLatitude(latitude);
                mockLocation.setLongitude(longitude);
                mockLocation.setAltitude(100);
                mockLocation.setTime(System.currentTimeMillis());
                mockLocation.setAccuracy(1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    mockLocation.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
                }

                LocationServices.getFusedLocationProviderClient(activity).setMockMode(true);
                LocationServices.getFusedLocationProviderClient(activity).setMockLocation(mockLocation);

                // compute next position
                mHandler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}
