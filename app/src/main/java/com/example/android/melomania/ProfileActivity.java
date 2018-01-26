package com.example.android.melomania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private CircleImageView profileImageView;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        profileImageView = (CircleImageView) findViewById(R.id.iv_profile_img_profile);
        nameTextView = (TextView) findViewById(R.id.tv_name_profile);

        setData(user);
    }

    private void setData(User user) {
        profileImageView.setImageResource(user.getImg());
        nameTextView.setText(user.getName());
    }
}
