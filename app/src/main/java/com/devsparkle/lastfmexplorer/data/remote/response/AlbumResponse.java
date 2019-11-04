package com.devsparkle.lastfmexplorer.data.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumResponse {

    @SerializedName("name")
    String name;

    @SerializedName("artist")
    String artist;

    @SerializedName("mbid")
    String mbid;


    @SerializedName("image")
    List<ImageResponse> image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public List<ImageResponse> getImage() {
        return image;
    }

    public void setImage(List<ImageResponse> image) {
        this.image = image;
    }
}
