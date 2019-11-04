package com.devsparkle.lastfmexplorer.ui.screen.album;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.devsparkle.lastfmexplorer.R;
import com.devsparkle.lastfmexplorer.domain.model.AlbumDetailDTO;
import com.devsparkle.lastfmexplorer.ui.screen.base.BaseActivity;
import com.devsparkle.lastfmexplorer.ui.screen.search.SearchActivity;

import javax.inject.Inject;

public class ShowAlbumActivity extends BaseActivity<ShowAlbumContract.View, ShowAlbumContract.Presenter> implements ShowAlbumContract.View {
    private final String TAG = SearchActivity.class.toString();


    @Inject
    ShowAlbumPresenter mShowAlbumPresenter;

    @Override
    protected ShowAlbumContract.Presenter initPresenter() {
        return mShowAlbumPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_album);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        loadView();
    }

    private void loadView(){

    }

    @Override
    public void showAlbum(AlbumDetailDTO albumDetail) {

    }

    @Override
    public void showNotConnected() {

    }

    @Override
    public void showError() {

    }


}
