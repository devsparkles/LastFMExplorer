package com.devsparkle.lastfmexplorer.ui.screen.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

public abstract class BaseMVPPresenter<V extends BaseMVPContract.View> implements LifecycleObserver, BaseMVPContract.Presenter<V> {

    V view;

    Boolean isViewAttached;

    public Boolean getViewAttached() {
        return view != null;
    }

    @Override
    public void attachLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    public void detachLifecycle(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onPresenterCreate() {

    }

    @Override
    public V getView() {
        return view;
    }

}