package com.devsparkle.lastfmexplorer.ui.screen.album;

import com.devsparkle.lastfmexplorer.ui.screen.base.BasePresenter;

import javax.inject.Inject;

public class ShowAlbumPresenter extends BasePresenter<ShowAlbumContract.View> implements ShowAlbumContract.Presenter {
    private static final String TAG = "ShowAlbumPresenter";

    @Inject
    public ShowAlbumPresenter() {
    }

    @Override
    public void getAlbumDetailByMbid(String mbId) {

    }
}
