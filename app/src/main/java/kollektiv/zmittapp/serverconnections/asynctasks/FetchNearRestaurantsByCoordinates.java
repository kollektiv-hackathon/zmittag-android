package kollektiv.zmittapp.serverconnections.asynctasks;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

import kollektiv.zmittapp.activity.MainActivity;
import kollektiv.zmittapp.activity.SplashActivity;
import kollektiv.zmittapp.entities.Restaurant;
import kollektiv.zmittapp.serverconnections.ZmittappRestInterface;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by tzhware7 on 04.11.14.
 */
public class FetchNearRestaurantsByCoordinates extends AsyncTask<Context, Integer, List<Restaurant>> {

    public double latitude = 0.0;
    public double longitude = 0.0;

    public LocationManager mLocationManager;
    public VeggsterLocationListener mVeggsterLocationListener;


    @Override
    protected void onPreExecute() {
        mVeggsterLocationListener = new VeggsterLocationListener();
        mLocationManager = (LocationManager) SplashActivity.mContext.getSystemService(Context.LOCATION_SERVICE);

            mLocationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 0, 0,
                    mVeggsterLocationListener);
    }

    @Override
    protected void onCancelled(){
        System.out.println("Cancelled by user!");
        mLocationManager.removeUpdates(mVeggsterLocationListener);
    }



    @Override
    protected List doInBackground(Context... contexts) {

        while (this.latitude == 0.0) {

        }

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.zmittapp.ch/app_dev.php")
                .setLogLevel(RestAdapter.LogLevel.FULL) //Delete Afterwards
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        request.addHeader("Accept", "application/json");
                        request.addHeader("Content-Type  ", "application/json");
                    }
                }).build();

        ZmittappRestInterface mZmittappRestInterface = restAdapter.create(ZmittappRestInterface.class);
        List<Restaurant> restaurants = mZmittappRestInterface.getRestaurantsByLocation(latitude, longitude);

        Log.d("Fetcher", "So viele Restaurants haben wir = " + restaurants.size() + " das sind folgende:");
        for (int i = 0; i < restaurants.size(); i++) {
            Log.d("Fetcher", "Restaurant " + restaurants.get(i).getName());
        }

        Intent intent = new Intent(contexts[0], MainActivity.class);
        //intent.putExtra("restaurant", (List<restaurant>) restaurants);
        contexts[0].startActivity(intent);

        mLocationManager.removeUpdates(mVeggsterLocationListener);
        return restaurants;
    }

    public class VeggsterLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

            double lat = location.getLatitude(); // * 1E6);
            double log = location.getLongitude(); // * 1E6);
            double acc = location.getAccuracy();
            String info = location.getProvider();
            Log.d("Fetcher", "lat: " + lat + " log: " + log + " acc: " + acc + " provider: " + info);

            try {

                latitude = location.getLatitude();
                longitude = location.getLongitude();

            } catch (Exception e) {
                Log.d("Fetcher", "Fehler: " + e.getStackTrace() );
            }

        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.i("OnProviderDisabled", "OnProviderDisabled");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.i("onProviderEnabled", "onProviderEnabled");
        }

        @Override
        public void onStatusChanged(String provider, int status,
                                    Bundle extras) {
            Log.i("onStatusChanged", "onStatusChanged");

        }

    }
}