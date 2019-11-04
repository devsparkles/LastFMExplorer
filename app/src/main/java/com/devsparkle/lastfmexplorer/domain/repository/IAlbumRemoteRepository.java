package com.devsparkle.lastfmexplorer.domain.repository;

import io.reactivex.Single;

public interface IAlbumRemoteRepository {

   Single searchAlbum(String text);
}
