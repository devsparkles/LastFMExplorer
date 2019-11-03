package com.devsparkle.lastfmexplorer.ui.screen.mvp;

import androidx.lifecycle.ViewModel;

public class BaseViewModel<V extends BaseMVPContract.View, P extends BaseMVPContract.Presenter<V>> extends ViewModel {

    P presenter = null;

    @Override
    protected void onCleared() {
        super.onCleared();
        if (presenter != null) {
            presenter.onPresenterDestroy();
        }
        presenter = null;
    }

}