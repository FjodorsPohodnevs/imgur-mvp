package com.fjodors.imgurmvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
public class App extends Application {

    private AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
