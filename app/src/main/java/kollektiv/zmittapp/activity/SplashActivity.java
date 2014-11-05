package kollektiv.zmittapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

import kollektiv.zmittapp.R;
import kollektiv.zmittapp.serverconnections.asynctasks.FetchNearRestaurantsByCoordinates;
import kollektiv.zmittapp.serverconnections.asynctasks.SplashAsyncTask;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class SplashActivity extends Activity{


    private ProgressBar mProgressbar;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mProgressbar = (ProgressBar) findViewById(R.id.pb_splash);
        mContext = this;

        FetchNearRestaurantsByCoordinates mRestaurantFetcher = new FetchNearRestaurantsByCoordinates();
            mRestaurantFetcher.execute(this);

    }
}
