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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.R.attr.thumbnail;
import static com.example.android.melomania.R.id.imageView;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class NewsFeedAdaptor extends RecyclerView.Adapter<NewsFeedAdaptor.MyViewHolder> {

    private Context mContext;
    private List<NewsFeed> newsList;

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
        holder.singerName.setText("by "+news.getSingerName());
        //TODO a3ml el isliked
        //ToDO A3ml el img

        // loading album cover using Glide library

        //Glide.with(mContext).load(mContext.getResources().getIdentifier(news.getProfileImg(), "drawable",mContext.getPackageName())).into(holder.profileImg);
        Picasso.with(mContext).load(news.getProfileImg()).into(holder.profileImg);

        holder.isLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (news.isLiked()) {
                    holder.isLiked.setImageResource(R.drawable.ic_favorite);
                    news.setLiked(false);
                } else {
                    holder.isLiked.setImageResource(R.drawable.ic_favorite_border);
                    news.setLiked(true);
                }
            }
        });

        holder.addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.addToList);

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
        inflater.inflate(R.menu.add_to_list, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
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
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}