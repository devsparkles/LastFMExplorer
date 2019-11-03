package com.devsparkle.lastfmexplorer.ui.screen.mvp;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

abstract class BaseMVPFragment<V extends BaseMVPContract.View, P extends BaseMVPContract.Presenter<V>> extends Fragment implements BaseMVPContract.View {

    P presenter;

    @CallSuper
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseViewModel<V, P> viewModel = (BaseViewModel<V, P>) ViewModelProviders.of(this).get(BaseViewModel.class);

        Boolean isPresenterCreated = false;
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
    public void onDestroy() {
        presenter.detachLifecycle(getLifecycle());
        presenter.detachView();
        super.onDestroy();
    }

    protected abstract P initPresenter();

}