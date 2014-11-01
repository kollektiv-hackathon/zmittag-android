package kollektiv.zmittapp.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import kollektiv.zmittapp.R;
import kollektiv.zmittapp.serverconnections.asynctasks.SplashAsyncTask;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class SplashActivity extends Activity {


    ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       mProgressbar = (ProgressBar) findViewById(R.id.pb_splash);

        //Asynctask ausführen für den Download der Locationbased Daten.
        SplashAsyncTask mTask = new SplashAsyncTask();
        mTask.execute(this);
    }


}
