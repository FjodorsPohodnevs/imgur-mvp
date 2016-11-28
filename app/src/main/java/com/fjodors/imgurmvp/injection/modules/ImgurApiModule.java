package com.fjodors.imgurmvp.injection.modules;

import android.app.Application;

import com.fjodors.imgurmvp.BuildConfig;
import com.fjodors.imgurmvp.data.AlbumRepository;
import com.fjodors.imgurmvp.data.GalleryRepository;
import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.data.remote.ImgurSerializer;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
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

    private static final String API_BASE_URL = "https://api.imgur.com/3/";
    private static final String API_CLIENT_ID = BuildConfig.API_CLIENT_ID;
    private static final String API_CLIENT_SECRET = BuildConfig.API_CLIENT_SECRET;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Provides
    @Singleton
    ImgurSerializer provideImgurSerializer() {
        return new ImgurSerializer();
    }

    @Provides
    @Singleton
    Gson provideGson(ImgurSerializer imgurSerializer) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ImgurBaseItem.class, imgurSerializer);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Interceptor provideInterceptor() {
        return chain -> {
            Request newRequest = chain.request().newBuilder().addHeader(AUTHORIZATION_HEADER, "Client-id " + API_CLIENT_ID).build();
            return chain.proceed(newRequest);
        };
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Interceptor interceptor, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache)
                .interceptors().add(interceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ImgurApiService provideImgurApiService(Retrofit retrofit) {
        return retrofit.create(ImgurApiService.class);
    }

    //TODO: place repository in other place???

    @Provides
    @Singleton
    GalleryRepository provideGalleryRepository(ImgurApiService imgurApiService) {
        return new GalleryRepository(imgurApiService);
    }

    @Provides
    @Singleton
    AlbumRepository provideAlbumRepository(ImgurApiService imgurApiService) {
        return new AlbumRepository(imgurApiService);
    }
}
