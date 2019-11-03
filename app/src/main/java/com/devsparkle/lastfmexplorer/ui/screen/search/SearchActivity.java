package com.devsparkle.lastfmexplorer.ui.screen.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.devsparkle.lastfmexplorer.R;
import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.devsparkle.lastfmexplorer.domain.model.ArtistDTO;
import com.devsparkle.lastfmexplorer.domain.model.TrackDTO;
import com.devsparkle.lastfmexplorer.ui.screen.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;


public class SearchActivity extends BaseActivity<SearchContract.View, SearchContract.Presenter> implements SearchContract.View {
    private final String TAG = SearchActivity.class.toString();

    @Inject
    SearchPresenter mSearchPresenter;

    @Override
    protected SearchContract.Presenter initPresenter() {
        return mSearchPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handleIntent(getIntent());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);


        }
    }


    @Override
    public void showArtist(List<ArtistDTO> artists) {

    }

    @Override
    public void showAlbum(List<AlbumDTO> albums) {

    }

    @Override
    public void showTrack(List<TrackDTO> tracks) {

    }

    @Override
    public void showNotConnected() {
        Toast.makeText(this, getString(R.string.error_not_connected), Toast.LENGTH_SHORT).show();
    }
}
