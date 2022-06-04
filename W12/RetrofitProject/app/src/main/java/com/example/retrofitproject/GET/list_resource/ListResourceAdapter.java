package com.example.retrofitproject.GET.list_resource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitproject.R;

import java.util.List;

public class ListResourceAdapter extends RecyclerView.Adapter<ListResourceAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> list_resource;

    public ListResourceAdapter(Context context, List<DataItem> list_resource) {
        this.context = context;
        this.list_resource = list_resource;
    }

    @NonNull
    @Override
    public ListResourceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resource_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListResourceAdapter.ViewHolder holder, int position) {
        holder.mName.setText(list_resource.get(position).getName());
        holder.mYear.setText(String.valueOf(list_resource.get(position).getYear()));
        holder.mColor.setText(list_resource.get(position).getColor());
        holder.mPantoneValue.setText(list_resource.get(position).getPantoneValue());
    }

    @Override
    public int getItemCount() {
        return list_resource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mYear, mColor, mPantoneValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mYear = itemView.findViewById(R.id.year);
            mColor = itemView.findViewById(R.id.color);
            mPantoneValue = itemView.findViewById(R.id.pantone_value);
        }
    }
}
