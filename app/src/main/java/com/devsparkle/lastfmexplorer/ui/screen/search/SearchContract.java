package com.devsparkle.lastfmexplorer.ui.screen.search;

import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.devsparkle.lastfmexplorer.domain.model.ArtistDTO;
import com.devsparkle.lastfmexplorer.domain.model.TrackDTO;
import com.devsparkle.lastfmexplorer.ui.screen.base.BaseContract;

import java.util.List;

public interface SearchContract {

    interface View extends BaseContract.View {

        /**
         * List artist
         * @param artists
         */
        void showArtist(List<ArtistDTO> artists);

        /**
         * List album
         * @param albums
         */
        void showAlbum(List<AlbumDTO> albums);

        /**
         * List tracks
         * @param tracks
         */
        void showTrack(List<TrackDTO> tracks);

        /**
         * Show not connected
         */
        void showNotConnected();

        /**
         * Show error
         */

        void showError();
    }


    interface Presenter extends BaseContract.Presenter<SearchContract.View> {

        /**
         * Search Artist
         * @param text
         */
        void searchArtist(String text);

        /**
         * Search Album
         * @param text
         */
        void searchAlbum(String text);

        /**
         * Search Track
         * @param text
         */
        void searchTrack(String text);



    }
}
