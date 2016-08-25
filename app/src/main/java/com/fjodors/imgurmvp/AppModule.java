package com.fjodors.imgurmvp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return app;
    }
}
