package kollektiv.zmittapp.serverconnections;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;

import kollektiv.zmittapp.activity.SplashActivity;

/**
 * Created by tzhware7 on 05.11.14.
 *
 * Abkürzungen für Requests
 * 1: getAllRestaurants()
 * 2: getRestaurantById()
 * 3: getMenusByRestaurant()
 * 4: subscribeToRestaurant()
 * 5: unsubscribeFromRestaurant()
 * 6: getRestaurantsBySubscription()
 *
 */
public class RequestGenerator {

    public static final String RequestMethod = "requestmethod";
    public static final String RequestRestaurantId = "requestrestaurantid";
    public static final String RequestAndroidId = "requestandroidid";


    public static Bundle createRestaurantsRequest(){
        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 1);
        return mBundle;
    }

    public static Bundle createRestaurantByIdRequest(int restaurant_id){
        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 2);
        mBundle.putInt(RequestRestaurantId, restaurant_id);
        return mBundle;
    }

    public static Bundle createMenusByRestaurantRequest(int restaurant_id){
        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 3);
        mBundle.putInt(RequestRestaurantId, restaurant_id);
        return mBundle;
    }

    public static Bundle createSubscribeToRestaurantRequest(int restaurant_id, Context ctx){
        String android_id = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 4);
        mBundle.putInt(RequestRestaurantId, restaurant_id);
        mBundle.putString(RequestAndroidId, android_id);
        return mBundle;
    }

    public static Bundle createUnsubscribeToRestaurantRequest(int restaurant_id, Context ctx){
        String android_id = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 5);
        mBundle.putInt(RequestRestaurantId, restaurant_id);
        mBundle.putString(RequestAndroidId, android_id);
        return mBundle;
    }

    public static Bundle createGetRestaurantBySubscriptionRequest(Context ctx){
        String android_id = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Bundle mBundle = new Bundle();
        mBundle.putInt(RequestMethod, 5);
        mBundle.putString(RequestAndroidId, android_id);
        return mBundle;
    }
}
