package com.fjodors.imgurmvp.api;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by fjodors.pohodnevs on 8/22/2016.
 */
@Singleton
@Component(modules = {ImgurNetworkModule.class})
public interface NetworkComponent {
//    Retrofit getRetrofit();
}