package com.devsparkle.lastfmexplorer.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class ImageResponse {

    @SerializedName("#text")
    String url;

    @SerializedName("size")
    String size;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
