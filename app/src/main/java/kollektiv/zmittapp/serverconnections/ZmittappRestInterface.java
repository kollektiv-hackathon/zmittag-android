package kollektiv.zmittapp.serverconnections;

import kollektiv.zmittapp.entities.Menu;
import kollektiv.zmittapp.entities.Restaurant;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by tzhware7 on 01.11.14.
 */
public interface ZmittappRestInterface {

    // Restaurants Allgemein

    @GET("/restaurants/")
    Restaurant[] getAllRestaurants();

    @GET("/restaurants/{restaurant_id}")
    Restaurant getRestaurant(@Path("restaurant_id") int restaurantId);

    @GET("/restaurants/{restaurant_id}/menuitems")
    Menu[] getMenus(@Path("restaurant_id") int restaurantId);

    @GET("restaurants/location?lat={lat}?lon={lon}")
    Restaurant[] getRestaurantsByLocation(@Path("lat") double lat, @Path("lon") double lon);



    // Suscribe / Unsuscribe

    @POST("/restaurants/{restaurant_id}/subscribe/{user_id}")
    void SubscribeRestaurant(@Path("id") String restaurantId);

    @POST("/restaurants/{restaurant_id}/unsubscribe/{user_id}")
    void UnsubscribeRestaurant(@Path("id") String restaurantId);

}
