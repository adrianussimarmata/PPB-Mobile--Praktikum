package com.example.newspaper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newspaper.Adapter.WebAdapter;
import com.example.newspaper.Room.WebViewModel;
import com.example.newspaper.Room.Website;

import java.util.List;

public class BookmarkFragment extends Fragment {

    private WebViewModel webViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_bookmark);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        WebAdapter adapter = new WebAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        webViewModel = new ViewModelProvider(getActivity()).get(WebViewModel.class);
        webViewModel.getAllBookmarks().observe(getActivity(), new Observer<List<Website>>() {
            @Override
            public void onChanged(List<Website> websites) {
                adapter.setWebsites(websites);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                webViewModel.delete(adapter.getWebAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "Bookmark telah dihapus!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        return view;
    }
}