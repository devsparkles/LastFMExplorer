package com.devsparkle.lastfmexplorer.ui.screen.mvp;


import androidx.lifecycle.Lifecycle;

public interface BaseMVPContract {
    interface View {

    }

    interface Presenter<V extends View> {
        void attachView(V view);

        void detachView();

        V getView();

        void onPresenterCreate();

        void onPresenterDestroy();

        void attachLifecycle(Lifecycle lifecycle);

        void detachLifecycle(Lifecycle lifecycle);
    }
}