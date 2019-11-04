package com.devsparkle.lastfmexplorer.di.module;

import android.app.Application;
import android.content.Context;

import com.devsparkle.lastfmexplorer.data.remote.api.LastFMService;
import com.devsparkle.lastfmexplorer.data.repository.remote.AlbumRemoteRepository;
import com.devsparkle.lastfmexplorer.domain.repository.IAlbumRemoteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .create();
    }




    @Provides
    @Singleton
    public IAlbumRemoteRepository provideAlbumRemoteRepository(LastFMService service) {
        return new AlbumRemoteRepository(service);
    }

}
