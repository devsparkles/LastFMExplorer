package com.devsparkle.lastfmexplorer.data.remote.api;

import com.devsparkle.lastfmexplorer.data.remote.response.AlbumSearchResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface LastFMService {



    @GET("2.0")
    Single<AlbumSearchResponse> searchAlbum(@Query("method") String method, @Query("album") String text,@Query("api_key") String apiKey,
                                            @Query("format") String format);



}
