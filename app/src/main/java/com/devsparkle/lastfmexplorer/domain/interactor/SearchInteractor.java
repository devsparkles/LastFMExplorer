package com.devsparkle.lastfmexplorer.domain.interactor;

import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.devsparkle.lastfmexplorer.domain.repository.IAlbumRemoteRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class SearchInteractor {

    IAlbumRemoteRepository albumRemoteRepository;
    @Inject
    public SearchInteractor(IAlbumRemoteRepository repo){

        this.albumRemoteRepository = repo;
    }

    public Single<List<AlbumDTO>> searchAlbum(String text) {
        return albumRemoteRepository.searchAlbum(text);
    }

    

}
