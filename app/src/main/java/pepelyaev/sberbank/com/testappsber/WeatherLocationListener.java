package pepelyaev.sberbank.com.testappsber;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import static pepelyaev.sberbank.com.testappsber.AsyncTaskWeather.update;

/**
 * Created by Anton on 04.02.2018.
 */

public class WeatherLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
          update(location.getLatitude(), location.getLongitude());
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
