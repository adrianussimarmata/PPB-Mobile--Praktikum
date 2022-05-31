package com.example.newspaper;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newspaper.Adapter.NewsAdapter;
import com.example.newspaper.Models.NewsApiResponse;
import com.example.newspaper.Models.NewsHeadlines;
import com.example.newspaper.networking.JsonPlaceHolderApi;
import com.example.newspaper.networking.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private List<NewsHeadlines> list_news;
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;
    private SearchView search_news;
    String country = "id";
    String category = "general";
    String keyword = "";
    String apiKey = "edcd21a3226a4948896177da3b99bd0d";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        search_news = view.findViewById(R.id.searchView);

        LoadData("");
        setSearchNews();

        return view;
    }

    public void LoadData(String keyword) {

        if (keyword.length() > 0) {
            RestClient.getService().getSearchNews(keyword, apiKey).enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if (response.isSuccessful() && response.body().getArticles() != null) {
                        list_news = response.body().getArticles();
                        newsAdapter = new NewsAdapter(getContext(), list_news);
                        recyclerView.setAdapter(newsAdapter);
                        newsAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {

                }
            });
        } else {
            RestClient.getService().getNewsList(country, category, keyword, apiKey).enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if (response.isSuccessful() && response.body().getArticles() != null) {
                        list_news = response.body().getArticles();
                        newsAdapter = new NewsAdapter(getContext(), list_news);
                        recyclerView.setAdapter(newsAdapter);
                        newsAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {

                }
            });
        }
    }

    private void setSearchNews() {

        search_news.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 0) {
                    LoadData(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                LoadData(newText);
                return false;
            }
        });
    }
}