package com.devsparkle.lastfmexplorer.domain.model;

import java.io.Serializable;

public class ArtistDTO implements Serializable {
    String name;
    String mbid;
    String url;

    public ArtistDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
