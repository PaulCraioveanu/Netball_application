package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.net.InetSocketAddress;

public class ResourcesActivity extends AppCompatActivity {
    private ImageButton ibGuide, ibExercises, ibDrilllibrary, ibSkills, ibPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        ibGuide = (ImageButton) findViewById(R.id.ibGuide);
        ibGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });

        ibExercises = (ImageButton) findViewById(R.id.ibExercises);
        ibExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, ExercisesActivity.class);
                startActivity(intent);
            }
        });

        ibDrilllibrary = (ImageButton) findViewById(R.id.ibDrilllibrary);
        ibDrilllibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, DrillActivity.class);
                startActivity(intent);
            }
        });

        ibSkills = (ImageButton) findViewById(R.id.ibSkills);
        ibSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, SkillsActivity.class);
                startActivity(intent);
            }
        });

        ibPositions = (ImageButton) findViewById(R.id.ibPositions);
        ibPositions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResourcesActivity.this, PositionsActivity.class);
                startActivity(intent);
            }
        });


    }

}