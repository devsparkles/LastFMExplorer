package com.devsparkle.lastfmexplorer;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class App  extends Application implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
    //    DaggerAppComponent.builder().application(this).build().inject(this);
        Stetho.initializeWithDefaults(this);
        Utils.init(this);

    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}

