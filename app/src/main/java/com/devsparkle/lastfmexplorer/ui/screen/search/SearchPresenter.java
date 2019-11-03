package com.devsparkle.lastfmexplorer.ui.screen.search;

import com.blankj.utilcode.util.NetworkUtils;
import com.devsparkle.lastfmexplorer.domain.interactor.SearchInteractor;
import com.devsparkle.lastfmexplorer.ui.screen.base.BasePresenter;

import javax.inject.Inject;

public class SearchPresenter extends BasePresenter<SearchContract.View> implements SearchContract.Presenter {
    private static final String TAG = "SearchPresenter";


    SearchInteractor interactor;

    @Inject
    public SearchPresenter(SearchInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void searchArtist(String text) {
       if(NetworkUtils.isConnected()){

       } else {
           getView().showNotConnected();
       }

    }

    @Override
    public void searchAlbum(String text) {

    }

    @Override
    public void searchTrack(String text) {

    }
}
