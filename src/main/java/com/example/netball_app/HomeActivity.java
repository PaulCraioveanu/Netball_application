package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.InetSocketAddress;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private
    ImageButton idBtnLogout, ibResources, ibSchedule, ibQuicktraining, ibDiary;
    UserLocalStore userLocalStore;
    TextView etName, etUsername, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName = (TextView) findViewById(R.id.etName);
        etUsername = (TextView) findViewById(R.id.etUsername);
        etEmail = (TextView) findViewById(R.id.etEmail);

        ibResources = (ImageButton) findViewById(R.id.ibResources);
        ibResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ResourcesActivity.class);
                startActivity(intent);
            }
        });

        ibQuicktraining = (ImageButton) findViewById(R.id.ibQuicktraining);
        ibQuicktraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });

        ibDiary = (ImageButton) findViewById(R.id.ibDiary);
        ibDiary.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DiaryActivity.class);
                startActivity(intent);
            }
        });

        ibSchedule = (ImageButton) findViewById(R.id.ibSchedule);
        ibSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        idBtnLogout = (ImageButton) findViewById(R.id.idBtnLogout);
        idBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        userLocalStore = new UserLocalStore(this);

        //test

        //test

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        etName.setText(name);
        etUsername.setText(username);
        etEmail.setText(email);

    }

    @Override
    public void onClick(View view) {

    }
}