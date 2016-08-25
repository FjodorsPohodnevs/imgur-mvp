package com.fjodors.imgurmvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
public class ImgurApp extends Application {


    private ImgurAppComponent imgurAppComponent;

    public static ImgurApp get(Context context) {
        return (ImgurApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        imgurAppComponent = DaggerImgurAppComponent.builder()
                .imgurAppModule(new ImgurAppModule(this))
                .build();
    }

    public ImgurAppComponent getImgurAppComponent() {
        return imgurAppComponent;
    }
}
