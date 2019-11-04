package com.devsparkle.lastfmexplorer.ui.cell;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.devsparkle.lastfmexplorer.R;
import com.devsparkle.lastfmexplorer.domain.model.AlbumDTO;
import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

public class AlbumCell extends SimpleCell<AlbumDTO, AlbumCell.ViewHolder> {

    public AlbumCell(AlbumDTO item) {
        super(item);
    }

    /**
     * Define the layout resource of this cell
     */
    @Override
    protected int getLayoutRes() {
        return R.layout.cell_album;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, View cellView) {
        return new ViewHolder(cellView);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, int position, Context context, Object payload) {
        holder.textViewLineOne.setText(getItem().getName());
        holder.textViewLineTwo.setText(getItem().getArtist());

        Glide.with(context)
                .load(getItem().getImageMedium())
                .apply(RequestOptions.circleCropTransform())
                .fitCenter()
                .into(holder.imageViewAlbumArt);

    }

    /**
     * Optional
     */
    @Override
    protected void onUnbindViewHolder(ViewHolder holder) {
        // do your cleaning jobs here when the item view is recycled.
    }

    /**
     * Define your view holder, which must extend SimpleViewHolder.
     */
    static class ViewHolder extends SimpleViewHolder {
        TextView textViewLineOne;
        TextView textViewLineTwo;
        ImageView imageViewAlbumArt;

        ViewHolder(View itemView) {
            super(itemView);
            textViewLineOne = itemView.findViewById(R.id.t_line_one);
            textViewLineTwo = itemView.findViewById(R.id.t_line_two);
            imageViewAlbumArt = itemView.findViewById(R.id.iv_art);
        }
    }
}