package kollektiv.zmittapp.serverconnections;

import kollektiv.zmittapp.entities.Menu;
import kollektiv.zmittapp.entities.Restaurant;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by tzhware7 on 01.11.14.
 */
public interface ZmittappRestInterface {


    @GET("/restaurants/")
    Restaurant[] getAllRestaurants();


    @GET("/restaurants/{id}")
    Restaurant getRestaurant(@Path("id") int restaurantId);


    @GET("/restaurants/{id}/menuitems")
    Menu[] getMenus(@Path("id") int restaurantId);




}
