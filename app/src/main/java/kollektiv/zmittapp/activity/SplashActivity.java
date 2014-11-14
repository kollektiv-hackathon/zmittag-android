package kollektiv.zmittapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;

import kollektiv.zmittapp.R;
import kollektiv.zmittapp.serverconnections.asynctasks.FetchNearRestaurantsByCoordinates;


/**
 * Created by tzhware7 on 01.11.14.
 */
public class SplashActivity extends Activity{


    private ProgressBar mProgressbar;
    public static Context mContext;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        //Hide Actionbar
        getActionBar().hide();


        mProgressbar = (ProgressBar) findViewById(R.id.pb_splash);
        mContext = this;

        FetchNearRestaurantsByCoordinates mRestaurantFetcher = new FetchNearRestaurantsByCoordinates();
            mRestaurantFetcher.execute(this);

    }
}
