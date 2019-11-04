package com.devsparkle.lastfmexplorer.data.repository.remote;

import com.devsparkle.lastfmexplorer.BuildConfig;
import com.devsparkle.lastfmexplorer.data.remote.MethodEnum;
import com.devsparkle.lastfmexplorer.data.remote.api.LastFMService;
import com.devsparkle.lastfmexplorer.data.remote.response.AlbumResponse;
import com.devsparkle.lastfmexplorer.data.remote.response.AlbumSearchResponse;
import com.devsparkle.lastfmexplorer.data.remote.response.ImageResponse;
import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.devsparkle.lastfmexplorer.domain.repository.IAlbumRemoteRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class AlbumRemoteRepository implements IAlbumRemoteRepository {

    LastFMService service;

    public AlbumRemoteRepository(LastFMService service) {
        this.service = service;
    }


    @Override
    public Single<List<AlbumDTO>> searchAlbum(String text) {
        return service.searchAlbum(MethodEnum.SEARCH_ALBUM.toString(), text, BuildConfig.API_KEY, "json")
                .map((AlbumSearchResponse a) -> {
                    List<AlbumDTO> result = new ArrayList<>();
                    if(a.getResults().getAlbummatches().getAlbums().size()>0){
                        for (AlbumResponse albumResponse: a.getResults().getAlbummatches().getAlbums()) {
                            AlbumDTO album = new AlbumDTO();
                            album.setName(albumResponse.getName());
                            album.setArtist(albumResponse.getArtist());
                            album.setMbid(albumResponse.getMbid());

                            for(ImageResponse imageResponse: albumResponse.getImage()){
                                if(imageResponse.getSize().equals("small")){
                                    album.setImageSmall(imageResponse.getUrl());
                                }
                                if(imageResponse.getSize().equals("medium")){
                                    album.setImageMedium(imageResponse.getUrl());
                                }
                                if(imageResponse.getSize().equals("large")){
                                    album.setImageLarge(imageResponse.getUrl());
                                }
                                if(imageResponse.getSize().equals("extralarge")){
                                    album.setImageExtraLarge(imageResponse.getUrl());
                                }
                            }

                            result.add(album);

                        }
                        return result;
                    } else {
                        return new ArrayList<>();
                    }
                });
    }
}
