package kollektiv.zmittapp.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by tzhware7 on 04.11.14.
 */
public class ZmittapApplication extends Application {

    private  ZmittapApplication instance;

    public ZmittapApplication() {
        this.instance = this;
    }

    public Context getContext() {
        return instance;
    }
}
