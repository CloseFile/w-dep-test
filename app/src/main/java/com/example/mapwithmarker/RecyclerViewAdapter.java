package com.example.mapwithmarker;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<NewsObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<NewsObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, null);
        RecyclerViewHolders rvh = new RecyclerViewHolders(layoutView);

        return rvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.newsTitle.setText("Song Title: " + itemList.get(position).getNewsTitle());
        holder.newsText.setText("Song Author: " + itemList.get(position).getNewsText());
        holder.imageId.setImageResource(R.drawable.feay);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
