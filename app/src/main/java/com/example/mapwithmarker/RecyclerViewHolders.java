package com.example.mapwithmarker;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView newsTitle;
    public TextView newsText;
    public ImageView imageId;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        newsTitle = (TextView) itemView.findViewById(R.id.names);
        newsText = (TextView) itemView.findViewById(R.id.texts);
        imageId = (ImageView) itemView.findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View view) {

    }

}
