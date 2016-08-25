package com.fjodors.imgurmvp.api;

import android.app.Application;

import com.fjodors.imgurmvp.BuildConfig;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fjodors.pohodnevs on 8/22/2016.
 */
@Module
public class ImgurApiModule {

    public static final String API_BASE_URL = "https://api.imgur.com/3/";

    public static final String API_CLIENT_ID = BuildConfig.API_CLIENT_ID;
    public static final String API_CLIENT_SECRET = BuildConfig.API_CLIENT_SECRET;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Provides
    @Singleton
    public ImgurSerializer provideImgurSerializer() {
        return new ImgurSerializer();
    }

    @Provides
    @Singleton
    public Gson provideGson(ImgurSerializer imgurSerializer) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ImgurBaseItem.class, imgurSerializer);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        return chain -> {
            Request newRequest = chain.request().newBuilder().addHeader(AUTHORIZATION_HEADER, "Client-id " + API_CLIENT_ID).build();
            return chain.proceed(newRequest);
        };
    }

    @Provides
    @Singleton
    public Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache)
                .interceptors().add(interceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public ImgurApiService provideImgurApiService(Retrofit retrofit) {
        return retrofit.create(ImgurApiService.class);
    }

    @Provides
    @Singleton
    ImgurManager provideImgurManager(ImgurApiService imgurApiService) {
        return new ImgurManager(imgurApiService);
    }

}
