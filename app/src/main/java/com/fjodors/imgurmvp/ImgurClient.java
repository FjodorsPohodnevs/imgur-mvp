package com.fjodors.imgurmvp;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurClient {
    public static final String API_BASE_URL = "https://api.imgur.com/3/";

    public static final String CLIENT_ID = "3a1f607e0fe2628";
    public static final String CLIENT_SECRET = "04ac4992adbe0f726e2d30ca2b839ebd9bac7823";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("Authorization", "Client-id " + CLIENT_ID).build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
