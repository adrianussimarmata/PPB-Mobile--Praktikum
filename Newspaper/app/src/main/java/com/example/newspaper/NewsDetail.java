package com.example.newspaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.newspaper.Room.WebViewModel;
import com.example.newspaper.Room.Website;

public class NewsDetail extends AppCompatActivity {

    TextView mTitle, mAuthor, mPublisher, mTime, mDescription, mUrl;
    String title, author, publisher, time, description, url, image_url;
    ImageView mImage, mBookmark;
    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        mTitle = findViewById(R.id.detail_title);
        mAuthor = findViewById(R.id.detail_author);
        mPublisher = findViewById(R.id.detail_publisher);
        mTime = findViewById(R.id.detail_time);
        mDescription = findViewById(R.id.detail_description);
        mUrl = findViewById(R.id.detail_source);
        mImage = findViewById(R.id.detail_image);

        getData();
        setData();

        mBookmark = findViewById(R.id.addBookmark);
        mBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Website web = new Website(url, title, image_url);
                WebViewModel viewModel = new ViewModelProvider(NewsDetail.this).get(WebViewModel.class);
                viewModel.insert(web);

                Toast.makeText(NewsDetail.this, "Berhasil ditambah ke bookmark", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        author = intent.getStringExtra("author");
        publisher = intent.getStringExtra("publisher");
        time = intent.getStringExtra("time");
        description = intent.getStringExtra("description");
        url = intent.getStringExtra("url");
        image_url = intent.getStringExtra("image");
    }

    private void setData() {
        mTitle.setText(title);
        mAuthor.setText("Author: " + author);
        mPublisher.setText("Publisher: " + publisher);
        mTime.setText("Published At: " + time);
        mDescription.setText(description);
        mUrl.setText("Source: " + url);
        Glide.with(mImage).load(image_url).into(mImage);
    }

    public void baca_berita(View view) {
        Intent intent = new Intent(this, webView.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}