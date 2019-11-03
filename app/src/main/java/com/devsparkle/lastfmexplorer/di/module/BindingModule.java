package com.devsparkle.lastfmexplorer.di.module;

import com.devsparkle.lastfmexplorer.di.scope.PerActivity;
import com.devsparkle.lastfmexplorer.ui.screen.search.SearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class BindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract public SearchActivity searchActivity();


}

