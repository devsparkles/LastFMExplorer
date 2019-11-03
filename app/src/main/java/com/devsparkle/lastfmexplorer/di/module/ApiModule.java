package com.devsparkle.lastfmexplorer.di.module;

import com.devsparkle.lastfmexplorer.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    @Named("okHttpClient")
    public OkHttpClient.Builder provideOkHttpBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        return builder.readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .callTimeout(1, TimeUnit.MINUTES);
    }


    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, @Named("okHttpClient") OkHttpClient.Builder builder) {
        return new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://localhost.com") // will be override with @Url at runtime
                .build();
    }


}
