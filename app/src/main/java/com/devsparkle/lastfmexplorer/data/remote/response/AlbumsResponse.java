package com.devsparkle.lastfmexplorer.data.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumsResponse {


    @SerializedName("album")
    List<AlbumResponse> albums;

    public List<AlbumResponse> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumResponse> albums) {
        this.albums = albums;
    }

}
