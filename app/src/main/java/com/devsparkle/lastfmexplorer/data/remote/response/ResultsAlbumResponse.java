package com.devsparkle.lastfmexplorer.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class ResultsAlbumResponse {

    @SerializedName("albummatches")
    AlbumsResponse albummatches;

    public AlbumsResponse getAlbummatches() {
        return albummatches;
    }

    public void setAlbummatches(AlbumsResponse albummatches) {
        this.albummatches = albummatches;
    }
}
