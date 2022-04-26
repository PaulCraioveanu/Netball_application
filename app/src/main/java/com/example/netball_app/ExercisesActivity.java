package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spanned;
import android.widget.TextView;

public class ExercisesActivity extends AppCompatActivity {
    private TextView tvJogging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        tvJogging = (TextView) findViewById(R.id.tvJogging);

    }

}