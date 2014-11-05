package kollektiv.zmittapp.serverconnections.asynctasks;

import android.os.AsyncTask;
import android.os.Bundle;

import kollektiv.zmittapp.entities.Menu;
import kollektiv.zmittapp.entities.Restaurant;
import kollektiv.zmittapp.serverconnections.RequestGenerator;
import kollektiv.zmittapp.serverconnections.ZmittappRestInterface;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by tzhware7 on 05.11.14.
 */
public class DataFetcher extends AsyncTask<Bundle, String, Object[]> {


    /**
     * Abkürzungen für Requests
     * 1: getAllRestaurants()
     * 2: getRestaurantById()
     * 3: getMenusByRestaurant()
     * 4: subscribeToRestaurant()
     * 5: unsubscribeFromRestaurant()
     * 6: getRestaurantsBySubscription()
     *
     * Entsprechene Arrays können im RequestGenerator erstellt werden.
     */
    @Override
    protected Object[] doInBackground(Bundle... bundles) {

        Bundle mRequestBundle = bundles[0];

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.zmittapp.ch/app_dev.php")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestInterceptor.RequestFacade request) {
                        request.addHeader("Accept", "application/json");
                        request.addHeader("Content-Type  ","application/json");
                    }
                }).build();
        ZmittappRestInterface mZmittappRestInterface = restAdapter.create(ZmittappRestInterface.class);

        switch (mRequestBundle.getInt(RequestGenerator.RequestMethod)){
            case 1:
                Restaurant[] mRestaurants = mZmittappRestInterface.getAllRestaurants();
                return mRestaurants;

            case 2:
                Restaurant mRestaurant = mZmittappRestInterface.getRestaurant(mRequestBundle.getInt(RequestGenerator.RequestRestaurantId));
                Object[] obj = new Object[] { mRestaurant };
                return obj;

            case 3:
                Menu[] mMenus = mZmittappRestInterface.getMenus(mRequestBundle.getInt(RequestGenerator.RequestRestaurantId));
                return mMenus;

            case 4:
                mZmittappRestInterface.subscribeRestaurant(mRequestBundle.getInt(RequestGenerator.RequestRestaurantId), mRequestBundle.getString(RequestGenerator.RequestAndroidId));
                //TODO: Response checken?
                return null;

            case 5:
                mZmittappRestInterface.unsubscribeRestaurant(mRequestBundle.getInt(RequestGenerator.RequestRestaurantId), mRequestBundle.getString(RequestGenerator.RequestAndroidId));
                //TODO: Response checken?
                return null;

            case 6:
                Restaurant[] mSuscribenRestaurants = mZmittappRestInterface.getSubscribenRestaurants(mRequestBundle.getString(RequestGenerator.RequestAndroidId));
                return mSuscribenRestaurants;
        }

        return null;
    }
}
