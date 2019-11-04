package com.devsparkle.lastfmexplorer.data.remote;

public enum MethodEnum {
    SEARCH_ALBUM("album.search"),
    SEARCH_ARTIST("artist_search"),
    SEARCH_TRACK("track.search");

    private String value;

    MethodEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
