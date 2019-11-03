package com.devsparkle.lastfmexplorer.di.component;

import android.app.Application;

import com.devsparkle.lastfmexplorer.App;
import com.devsparkle.lastfmexplorer.di.module.ApiModule;
import com.devsparkle.lastfmexplorer.di.module.AppModule;
import com.devsparkle.lastfmexplorer.di.module.BindingModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {BindingModule.class,
                AppModule.class,
                ApiModule.class,
                AndroidSupportInjectionModule.class
        }
)
public interface AppComponent {

    void inject(App application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application Application);

        AppComponent build();
    }

}
