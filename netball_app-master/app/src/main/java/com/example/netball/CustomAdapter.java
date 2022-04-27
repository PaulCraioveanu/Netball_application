package com.example.netball;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> titles;
    ArrayList<String> conditions;
    ArrayList<String> descriptions;
    ArrayList<String> skills;
    ArrayList<String> videos;
    ArrayList<String> images;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> titles, ArrayList<String> conditions, ArrayList<String> descriptions, ArrayList<String> skills, ArrayList<String> videos, ArrayList<String> images) {
        this.titles = titles;
        this.conditions = conditions;
        this.descriptions = descriptions;
        this.skills = skills;
        this.videos = videos;
        this.images = images;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(titles.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           //     Toast.makeText(context, videos.get(position), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,DetailActivity.class);
                i.putExtra("title",titles.get(position));
                i.putExtra("description",descriptions.get(position));
                i.putExtra("condition",conditions.get(position));
                i.putExtra("skills",skills.get(position));
                i.putExtra("videos",videos.get(position));
                i.putExtra("image",images.get(position));
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.textContent);
        }
    }
}
