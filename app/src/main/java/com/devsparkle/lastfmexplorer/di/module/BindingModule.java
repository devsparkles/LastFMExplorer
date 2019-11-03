package com.devsparkle.lastfmexplorer.di.module;

import com.devsparkle.lastfmexplorer.MainActivity;
import com.devsparkle.lastfmexplorer.di.scope.PerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class BindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract public MainActivity mainActivity();


}

