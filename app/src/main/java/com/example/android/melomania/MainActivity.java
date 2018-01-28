package com.example.android.melomania;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsFeedRecycleView;
    private NewsFeedAdaptor newsFeedAdaptor;
    private List<NewsFeed> newsList;

    private RecyclerView recommedationRecycleView;
    private SongAdaptor songAdaptor;
    private List<Song> recommendationList;

    private RecyclerView mostPopularRecycleView;
    private List<Song> mostPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO ashel dh w asht8l bl action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_melomania_blue_light);
        setSupportActionBar(toolbar);

        //Recommendation List
        LinearLayoutManager recommendLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recommedationRecycleView = (RecyclerView) findViewById(R.id.recommendation_list);
        recommedationRecycleView.setLayoutManager(recommendLayoutManager);
        recommedationRecycleView.setItemAnimator(new DefaultItemAnimator());

        recommendationList = new ArrayList<>();
        songAdaptor = new SongAdaptor(this, recommendationList);
        recommedationRecycleView.setAdapter(songAdaptor);
        setSongDummyData(recommendationList);

        //Most Popular List
        LinearLayoutManager mostPopularLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mostPopularRecycleView = (RecyclerView) findViewById(R.id.rv_most_popular_list);
        mostPopularRecycleView.setLayoutManager(mostPopularLayoutManager);
        mostPopularRecycleView.setItemAnimator(new DefaultItemAnimator());

        mostPopularList = new ArrayList<>();
        songAdaptor = new SongAdaptor(this, mostPopularList);
        mostPopularRecycleView.setAdapter(songAdaptor);
        setSongDummyData(mostPopularList);

        //NewsFeed List
        newsFeedRecycleView = (RecyclerView) findViewById(R.id.rv_news_feed_list);

        newsList = new ArrayList<>();
        newsFeedAdaptor = new NewsFeedAdaptor(this, newsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        newsFeedRecycleView.setLayoutManager(mLayoutManager);
        newsFeedRecycleView.setItemAnimator(new DefaultItemAnimator());
        newsFeedRecycleView.setAdapter(newsFeedAdaptor);

        setNewsDummyData();

        Button goToLogin = (Button) findViewById(R.id.login_button);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        Button goToFavor = (Button) findViewById(R.id.favor_button);
        goToFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavorArtistsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search_button).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    private void setNewsDummyData() {
        NewsFeed a = new NewsFeed(R.drawable.gilfoile_placeholder_temp, "Gilfoile", "One more night", "Maroon 5", false, "is listining");
        newsList.add(a);

        a = new NewsFeed(R.drawable.floki, "Floki", "If i had a heart", "Fever Ray", true, "is listining");
        newsList.add(a);

        a = new NewsFeed(R.drawable.gilfoile_placeholder_temp, "Rawan", "Starboy", "The weekend", false, "is listining");
        newsList.add(a);

        a = new NewsFeed(R.drawable.gilfoile_placeholder_temp, "Rawan", "Starboy", "The weekend", true, "is listining");
        newsList.add(a);

        a = new NewsFeed(R.drawable.gilfoile_placeholder_temp, "Rawan", "Starboy", "The weekend", false, "is listining");
        newsList.add(a);

        newsFeedAdaptor.notifyDataSetChanged();
    }

    private void setSongDummyData(List<Song> list) {
        Song a = new Song(R.drawable.thunder_placeholder_temp, "Thunder", "Imagin darongs");
        list.add(a);

        a = new Song(R.drawable.thunder_placeholder_temp, "What ever it takes", "Imagin darongs");
        list.add(a);

        a = new Song(R.drawable.thunder_placeholder_temp, "aaa", "Imagin darongs");
        list.add(a);

        a = new Song(R.drawable.thunder_placeholder_temp, "akj/sfdij;;fjafjwaoejwiojoirewroiweoiruioewr", "Imagin darw;erk;ewkr;kwe;rkongs");
        list.add(a);

        a = new Song(R.drawable.thunder_placeholder_temp, "aa", "Imagin darongs");
        list.add(a);

        a = new Song(R.drawable.thunder_placeholder_temp, "er", "Imagin darongs");
        list.add(a);

        songAdaptor.notifyDataSetChanged();
    }
}
