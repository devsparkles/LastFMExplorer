package com.devsparkle.lastfmexplorer.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class AlbumSearchResponse {

    @SerializedName("results")
    ResultsAlbumResponse results;

    public AlbumSearchResponse(ResultsAlbumResponse results) {
        this.results = results;
    }

    public ResultsAlbumResponse getResults() {
        return results;
    }

    public void setResults(ResultsAlbumResponse results) {
        this.results = results;
    }
}
