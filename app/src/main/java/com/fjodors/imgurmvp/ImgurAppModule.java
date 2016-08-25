package com.fjodors.imgurmvp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Module
public class ImgurAppModule {
    private Application application;

    public ImgurAppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
