package com.example.android.melomania;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Demo on 2018-01-21.
 */

public class SongAdaptor extends RecyclerView.Adapter<SongAdaptor.ViewHolder> {
    private Context mContext;
    private List<Song> recommendationList;

    public SongAdaptor(Context mContext, List<Song> recommendationList) {
        this.mContext = mContext;
        this.recommendationList = recommendationList;
    }

    @Override
    public com.example.android.melomania.SongAdaptor.ViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            final com.example.android.melomania.SongAdaptor.ViewHolder holder, final int position) {
        final Song song = recommendationList.get(position);
        holder.songName.setText(song.getSongName() + "");
        holder.singerName.setText("by " + song.getSignerName());
        //ToDO A3ml el img

        // loading album cover using Glide library

        //Glide.with(mContext).load(mContext.getResources().getIdentifier(news.getProfileImg(), "drawable",mContext.getPackageName())).into(holder.songImg);
        //Picasso.with(mContext).load(song.getSongImg()).into(holder.songImg);


        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.more);

            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.more_options, popup.getMenu());
        popup.setOnMenuItemClickListener(new com.example.android.melomania.SongAdaptor.MyMenuItemClickListener());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return recommendationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView songName, singerName;
        public ImageView songImg;
        public ImageButton more;

        public ViewHolder(View view) {
            super(view);
            songName = (TextView) view.findViewById(R.id.tv_song_name_recommend);
            singerName = (TextView) view.findViewById(R.id.tv_singer_name_recommend);
            more = (ImageButton) view.findViewById(R.id.ib_more_recommend);
        }
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            //TODO ashel el hbl dh w azbotha
            switch (menuItem.getItemId()) {

            }
            return false;
        }
    }
}
