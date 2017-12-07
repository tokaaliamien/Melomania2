package com.example.android.melomania;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
    private List<NewsFeed>newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO ashel dh w asht8l bl action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_melomania_blue_light);
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recommendedList = (RecyclerView) findViewById(R.id.recommended_list);
        recommendedList.setLayoutManager(layoutManager);

        newsFeedRecycleView=(RecyclerView)findViewById(R.id.rv_news_feed_list);

        newsList=new ArrayList<>();
        newsFeedAdaptor=new NewsFeedAdaptor(this,newsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        newsFeedRecycleView.setLayoutManager(mLayoutManager);
        //newsFeedRecycleView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        newsFeedRecycleView.setItemAnimator(new DefaultItemAnimator());
        newsFeedRecycleView.setAdapter(newsFeedAdaptor);

        setDummyData();

        Button goToLogin = (Button) findViewById(R.id.login_button);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
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


    private void setDummyData() {
        NewsFeed a = new NewsFeed(R.drawable.person_placeholder,"Toka","One more night","Maroon 5",true,"is listining");
        newsList.add(a);

        a = new NewsFeed(R.drawable.person_placeholder,"Rawan","Starboy","The weekend",false,"is listining");
        newsList.add(a);

        newsFeedAdaptor.notifyDataSetChanged();
    }
}
