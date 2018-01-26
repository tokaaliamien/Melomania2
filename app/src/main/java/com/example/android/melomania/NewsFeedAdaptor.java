package com.example.android.melomania;

import android.content.Context;
import android.content.Intent;
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

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsFeedAdaptor extends RecyclerView.Adapter<NewsFeedAdaptor.MyViewHolder> {

    private Context mContext;
    private List<NewsFeed> newsList;

    public NewsFeedAdaptor(Context mContext, List<NewsFeed> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_feed_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final NewsFeed news = newsList.get(position);
        holder.nameAndAction.setText(news.getUserName());
        holder.nameAndAction.append(" " + news.getAction());
        holder.nameAndAction.append(" to");
        holder.songName.setText(news.getSongName());
        holder.singerName.setText("by " + news.getSingerName());
        //isliked
        if (news.isLiked()) {
            holder.isLiked.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.isLiked.setImageResource(R.drawable.ic_favorite_border);
        }
        //ToDO A3ml el img

        // loading album cover using Glide library

        //Glide.with(mContext).load(mContext.getResources().getIdentifier(news.getProfileImg(), "drawable",mContext.getPackageName())).into(holder.profileImg);
        Picasso.with(mContext).load(news.getProfileImg()).into(holder.profileImg);

        holder.isLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!news.isLiked()) {
                    holder.isLiked.setImageResource(R.drawable.ic_favorite);
                    news.setLiked(true);
                } else {
                    holder.isLiked.setImageResource(R.drawable.ic_favorite_border);
                    news.setLiked(false);
                }
            }
        });

        holder.addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.addToList);

            }
        });

        //ٍSet img action
        holder.profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(news.getUserName(), news.getProfileImg());
                Intent intent = new Intent(mContext, ProfileActivity.class);
                intent.putExtra("user", user);
                mContext.startActivity(intent);
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
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameAndAction, songName, singerName;
        public CircleImageView profileImg;
        public ImageView isLiked;
        public ImageButton addToList;

        public MyViewHolder(View view) {
            super(view);
            nameAndAction = (TextView) view.findViewById(R.id.tv_name_news_feed);
            songName = (TextView) view.findViewById(R.id.tv_song_name_news_feed);
            singerName = (TextView) view.findViewById(R.id.tv_singer_name_news_feed);
            profileImg = (CircleImageView) view.findViewById(R.id.iv_profile_img_news_feed);
            isLiked = (ImageView) view.findViewById(R.id.iv_isLiked);
            addToList = (ImageButton) view.findViewById(R.id.ib_add_to_list);
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