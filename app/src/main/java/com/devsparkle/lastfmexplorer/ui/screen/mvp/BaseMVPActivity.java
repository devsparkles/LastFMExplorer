package com.devsparkle.lastfmexplorer.ui.screen.mvp;


import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

abstract public class BaseMVPActivity<V extends BaseMVPContract.View, P extends BaseMVPContract.Presenter<V>> extends AppCompatActivity implements BaseMVPContract.View {

    public P presenter;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        @SuppressWarnings("unchecked") BaseViewModel<V, P> viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
        boolean isPresenterCreated = false;

        if (viewModel.presenter == null) {
            viewModel.presenter = initPresenter();
            isPresenterCreated = true;
        }
        presenter = viewModel.presenter;
        presenter.attachLifecycle(getLifecycle());
        presenter.attachView((V) this);
        if (isPresenterCreated)
            presenter.onPresenterCreate();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        presenter.detachLifecycle(getLifecycle());
        presenter.detachView();
        super.onDestroy();
        presenter.onPresenterDestroy();
    }

    protected abstract P initPresenter();


}