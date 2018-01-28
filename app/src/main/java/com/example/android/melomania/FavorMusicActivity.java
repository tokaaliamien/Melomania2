package com.example.android.melomania;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;


public class FavorMusicActivity extends AppCompatActivity {

    private TagFlowLayout mFlowLayout;
    private TagAdapter<String> mAdapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favor_music);

        list = new ArrayList<>();
        setDummyData();

        mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        final LayoutInflater mInflater = LayoutInflater.from(this);


        mFlowLayout.setAdapter(mAdapter = new TagAdapter<String>(list) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.favor_item_view,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                //TODO delete this shit & send selected items to next activity
                Toast.makeText(FavorMusicActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        LinearLayout skipLayout = (LinearLayout) findViewById(R.id.skip);
        skipLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO go to next activity
            }
        });

    }

    private void setDummyData() {
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
        list.add("Imagin dragons");
        list.add("a");
        list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list.add("a");
        list.add("aaaaaa");
        list.add("alw;k;wkrokewrow");
    }
}
