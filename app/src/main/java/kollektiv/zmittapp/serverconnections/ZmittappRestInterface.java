package kollektiv.zmittapp.serverconnections;

import kollektiv.zmittapp.entities.Menu;
import kollektiv.zmittapp.entities.Restaurant;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by tzhware7 on 01.11.14.
 */
public interface ZmittappRestInterface {

    // Restaurants & Menus allgemein

    @GET("/restaurants/")
    Restaurant[] getAllRestaurants();

    @GET("/restaurants/{restaurant_id}")
    Restaurant getRestaurant(@Path("restaurant_id") int restaurantId);

    @GET("/restaurants/{restaurant_id}/menuitems")
    Menu[] getMenus(@Path("restaurant_id") int restaurantId);

    @GET("/restaurants/location")
    Restaurant[] getRestaurantsByLocation(@Query("lat") double lat, @Query("lon") double lon);

    @GET("/user/{user_id}/subscriptions")
    Restaurant[] getSubscribenRestaurants(@Path("user_id") String user_id);


    // Suscribe / Unsuscribe

    @POST("/restaurants/{restaurant_id}/subscribe/{user_id}")
    void subscribeRestaurant(@Path("id") int restaurantId, @Path("user_id") String user_id);

    @POST("/restaurants/{restaurant_id}/unsubscribe/{user_id}")
    void unsubscribeRestaurant(@Path("id") int restaurantId, @Path("user_id") String user_id);

}
