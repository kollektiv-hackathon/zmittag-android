package kollektiv.zmittapp.serverconnections.asynctasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import kollektiv.zmittapp.activity.MainActivity;
import kollektiv.zmittapp.gps.GpsListener;
import kollektiv.zmittapp.serverconnections.ZmittappRestInterface;
import retrofit.RestAdapter;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class SplashAsyncTask extends AsyncTask<Context, String, Object> {


    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param contexts The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Object doInBackground(Context... contexts) {

        //Context rauslesen
        GpsListener mGpsListener = new GpsListener(contexts[0]);

        //Build RestAdapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.zmittapp.ch/")
                .build();

        ZmittappRestInterface mZmittappRestInterface = restAdapter.create(ZmittappRestInterface.class);
        // Network blabli bla bla ausführen

        Intent intent = new Intent(contexts[0], MainActivity.class);
        intent.putExtra("Blabla", "blabala");
        contexts[0].startActivity(intent);



        return null;
    }
}
