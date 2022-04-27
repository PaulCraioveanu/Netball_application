package com.example.netball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PostionActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> descriptions = new ArrayList<>();
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<String> conditions = new ArrayList<>();
    ArrayList<String> videos = new ArrayList<String>();
    ArrayList<String> images=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postion);

        getSupportActionBar().setTitle("Positions");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray posArray = obj.getJSONArray("positions");
            // implement for loop for getting users list data
            for (int i = 0; i < posArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject posDetail = posArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                titles.add(posDetail.getString("title"));
                conditions.add(posDetail.getString("condition"));
                descriptions.add(posDetail.getString("description"));
                skills.add(posDetail.getString("skills"));
                videos.add(posDetail.getString("videos"));
                images.add(posDetail.getString("image"));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(PostionActivity.this,titles,conditions,descriptions,skills,videos,images);
        recyclerView.setAdapter(customAdapter);

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("positions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}