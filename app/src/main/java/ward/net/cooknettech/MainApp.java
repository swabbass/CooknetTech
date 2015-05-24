package ward.net.cooknettech;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ward.net.networkcorew.Network;

/**
 * Created by ward on 5/8/2015.
 */
public class MainApp extends Application {

    public static Network network;
    public static Gson gson;
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        network=Network.getInstance(getApplicationContext());
        gson=new GsonBuilder().create();


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        network=null;
    }
}
