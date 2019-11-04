package com.devsparkle.lastfmexplorer.ui.screen.album;


import com.devsparkle.lastfmexplorer.domain.model.AlbumDetailDTO;
import com.devsparkle.lastfmexplorer.ui.screen.base.BaseContract;

public interface ShowAlbumContract {
    interface View extends BaseContract.View {

        /**
         * Show detail album by mbid
         * @param albumDetail
         */
        void showAlbum(AlbumDetailDTO albumDetail);


        /**
         * Show not connected
         */
        void showNotConnected();

        /**
         * Show error
         */

        void showError();
    }


    interface Presenter extends BaseContract.Presenter<ShowAlbumContract.View> {

        /**
         * Get Album detail by mbId
         * @param mbId
         */
        void getAlbumDetailByMbid(String mbId);

    }
}
