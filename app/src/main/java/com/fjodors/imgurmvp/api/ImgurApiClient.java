package com.fjodors.imgurmvp.api;


import com.fjodors.imgurmvp.BuildConfig;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurApiClient {
    public static final String API_BASE_URL = "https://api.imgur.com/3/";

    public static final String API_CLIENT_ID = BuildConfig.API_CLIENT_ID;
    public static final String API_CLIENT_SECRET = BuildConfig.API_CLIENT_SECRET;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {
            Request newRequest = chain.request().newBuilder().addHeader(AUTHORIZATION_HEADER, "Client-id " + API_CLIENT_ID).build();
            return chain.proceed(newRequest);
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(getConverter())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    private static GsonConverterFactory getConverter() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ImgurBaseItem.class, new ImgurSerializer())
                .create();

        return GsonConverterFactory.create(gson);
    }
}
