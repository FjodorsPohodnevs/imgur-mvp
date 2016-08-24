package com.fjodors.imgurmvp;

import android.app.Application;

import com.fjodors.imgurmvp.api.dependencyInjection.AppModule;
import com.fjodors.imgurmvp.api.dependencyInjection.DaggerNetworkComponent;
import com.fjodors.imgurmvp.api.dependencyInjection.NetworkComponent;
import com.fjodors.imgurmvp.api.dependencyInjection.ImgurNetworkModule;

/**
 * Created by fjodors.pohodnevs on 8/24/2016.
 */
public class App extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new ImgurNetworkModule())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}