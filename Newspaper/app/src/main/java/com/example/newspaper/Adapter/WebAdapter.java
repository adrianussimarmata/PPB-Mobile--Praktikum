package com.example.newspaper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newspaper.R;
import com.example.newspaper.Room.Website;
import com.example.newspaper.webView;

import java.util.ArrayList;
import java.util.List;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.WebHolder> {

    private Context context;
    private List<Website> websites = new ArrayList<>();

    public WebAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public WebHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bookmark_item, parent, false);
        return new WebHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebHolder holder, int position) {
        holder.text_title.setText(websites.get(position).getTitle());
        holder.text_url.setText(websites.get(position).getUrl());
        Glide.with(context).load(websites.get(position).getUrl_image()).into(holder.img_bookmark);
        holder.cardview_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", websites.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return websites.size();
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
        notifyDataSetChanged();
    }

    public Website getWebAt(int position) {
        return websites.get(position);
    }

    public class WebHolder extends RecyclerView.ViewHolder {
        TextView text_title, text_url;
        ImageView img_bookmark;
        CardView cardview_bookmark;

        public WebHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_url = itemView.findViewById(R.id.url);
            img_bookmark = itemView.findViewById(R.id.web_image);
            cardview_bookmark = itemView.findViewById(R.id.cardview_bookmark);
        }
    }

}
