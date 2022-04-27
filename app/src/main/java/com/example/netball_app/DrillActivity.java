package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DrillActivity extends AppCompatActivity {
    TextView tvbasicdrill, tvintermediatedrill, tvadvanceddrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill);
        tvbasicdrill = (TextView) findViewById(R.id.tvbasicdrill);
        tvbasicdrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrillActivity.this, BasicDrillActivity.class);
                startActivity(intent);

            }
        });
        tvintermediatedrill = (TextView) findViewById(R.id.tvintermediatedrill);
        tvintermediatedrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrillActivity.this, IntermediateDrillActivity.class);
                startActivity(intent);
            }
        });
        tvadvanceddrill = (TextView) findViewById(R.id.tvadvanceddrill);
        tvadvanceddrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrillActivity.this, AdvancedDrillActivity.class);
                startActivity(intent);
            }
        });
    }
}