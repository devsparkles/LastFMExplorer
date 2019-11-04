package com.devsparkle.lastfmexplorer.ui.screen.search;

import com.blankj.utilcode.util.NetworkUtils;
import com.devsparkle.lastfmexplorer.domain.interactor.SearchInteractor;
import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.devsparkle.lastfmexplorer.ui.screen.base.BasePresenter;

import java.util.List;

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
        if (NetworkUtils.isConnected()) {
            fetch(interactor.searchAlbum(text), (List<AlbumDTO> albums) -> {
                        getView().showAlbum(albums);
                    }, (Throwable equipementDTO) -> {
                        getView().showError();
                    }
            );

        } else {
            getView().showNotConnected();
        }

    }

    @Override
    public void searchAlbum(String text) {
        if (NetworkUtils.isConnected()) {
            fetch(interactor.searchAlbum(text), (List<AlbumDTO> albums) -> {
                        getView().showAlbum(albums);
                    }, (Throwable equipementDTO) -> {
                        getView().showError();
                    }
            );

        } else {
            getView().showNotConnected();
        }
    }

    @Override
    public void searchTrack(String text) {

    }
}
