package com.example.netball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView txtDescription,txtSkills,txtCondition,txtVideos;
    YouTubePlayerView youTubePlayerView;
    ImageView imageBnner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDescription=findViewById(R.id.description);
        txtSkills=findViewById(R.id.skills);
        txtCondition=findViewById(R.id.conditions);
        imageBnner=findViewById(R.id.imageBanner);
        txtVideos=findViewById(R.id.videos);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        String description=extras.getString("description");
        String condition=extras.getString("condition");
        String skills=extras.getString("skills");
        String videos=extras.getString("videos");
        String image=extras.getString("image");

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = videos;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });



       // Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle(title);
        txtDescription.setText(description);
        txtSkills.setText(skills);
        txtCondition.setText(condition);
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.loading)
                .into(imageBnner);


    }
}