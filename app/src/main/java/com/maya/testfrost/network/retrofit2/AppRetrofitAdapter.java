package com.maya.testfrost.network.retrofit2;


import com.maya.testfrost.constants.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gokul Kalagara on 11/29/2017.
 */

public class AppRetrofitAdapter
{
    public static Retrofit getRetrofit()
    {
        return (new Retrofit.Builder().client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build());
    }

    public static Retrofit getRetrofitByBaseUrl(String baseUrl)
    {
        return (new Retrofit.Builder().client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build());
    }





    private static OkHttpClient getClient()
    {
        RetrofitNetworkLogger logging = new RetrofitNetworkLogger();
        // set your desired log level -> NONE
        logging.setLevel(RetrofitNetworkLogger.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .build();


        return client;
    }
}
