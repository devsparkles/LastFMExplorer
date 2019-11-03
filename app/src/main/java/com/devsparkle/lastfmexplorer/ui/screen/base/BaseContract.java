package com.devsparkle.lastfmexplorer.ui.screen.base;


import com.devsparkle.lastfmexplorer.ui.screen.mvp.BaseMVPContract;

public interface BaseContract {

    interface View extends BaseMVPContract.View {

    }

    interface Presenter<V extends BaseMVPContract.View> extends BaseMVPContract.Presenter<V> {

    }
}
