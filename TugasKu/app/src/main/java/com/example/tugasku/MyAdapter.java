package com.example.tugasku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String dataTask[], dataDL[], dataCreate[], dataCatatan[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], String s3[], String s4[]) {
        context = ct;
        dataTask = s1;
        dataCreate = s2;
        dataDL = s3;
        dataCatatan = s4;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.task_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textTitle.setText(dataTask[position]);
        holder.textCreate.setText(dataCreate[position]);
        holder.textDeadline.setText(dataDL[position]);
        holder.textNote.setText(dataCatatan[position]);
    }

    @Override
    public int getItemCount() {
        return dataTask.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle, textCreate, textDeadline, textNote;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_task);
            textCreate = itemView.findViewById(R.id.text_tglCreate);
            textDeadline = itemView.findViewById(R.id.text_deadline);
            textNote = itemView.findViewById(R.id.text_note);
        }
    }
}
