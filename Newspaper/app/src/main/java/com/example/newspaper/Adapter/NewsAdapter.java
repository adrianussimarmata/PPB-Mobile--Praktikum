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
import com.example.newspaper.Models.NewsHeadlines;
import com.example.newspaper.NewsDetail;
import com.example.newspaper.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    List<NewsHeadlines> articles;

    public NewsAdapter(Context context, List<NewsHeadlines> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_title.setText(articles.get(position).getTitle());
        holder.text_content.setText(articles.get(position).getContent());
        holder.text_author.setText(articles.get(position).getAuthor());
        holder.text_time.setText("Published At: " + articles.get(position).getPublishedAt());
        holder.text_source.setText("Source: " + articles.get(position).getUrl());
        Glide.with(context).load(articles.get(position).getUrlToImage()).into(holder.img_news);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetail.class);
                intent.putExtra("title", articles.get(position).getTitle());
                intent.putExtra("author", articles.get(position).getAuthor());
                intent.putExtra("publisher", articles.get(position).getSource().getName());
                intent.putExtra("time", articles.get(position).getPublishedAt());
                intent.putExtra("description", articles.get(position).getDescription());
                intent.putExtra("url", articles.get(position).getUrl());
                intent.putExtra("image", articles.get(position).getUrlToImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_title, text_content, text_author, text_time, text_source;
        ImageView img_news;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.mainHeaading);
            text_content = itemView.findViewById(R.id.content);
            text_author = itemView.findViewById(R.id.author);
            text_time = itemView.findViewById(R.id.time);
            text_source = itemView.findViewById(R.id.source);
            img_news = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
