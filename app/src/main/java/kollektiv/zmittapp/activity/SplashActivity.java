package kollektiv.zmittapp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import kollektiv.zmittapp.R;
import kollektiv.zmittapp.serverconnections.asynctasks.FetchNearRestaurantsByCoordinates;


/**
 * Created by tzhware7 on 01.11.14.
 */
public class SplashActivity extends Activity{


    private ProgressBar mProgressbar;
    private ImageView   mImageView;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Hide Actionbar
        if(getActionBar() != null) {
            getActionBar().hide();
        }

        //Casten
        mProgressbar = (ProgressBar) findViewById(R.id.pb_splash);
        mImageView = (ImageView) findViewById(R.id.img_splash);
        mContext = this;

        //Asynctask starten
        FetchNearRestaurantsByCoordinates mRestaurantFetcher = new FetchNearRestaurantsByCoordinates();
            mRestaurantFetcher.execute(this);

    }
}
