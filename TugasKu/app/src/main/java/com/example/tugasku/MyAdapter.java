package com.example.tugasku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String dataTask[], dataDL[], dataCreate[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], String s3[]) {
        context = ct;
        dataTask = s1;
        dataDL = s2;
        dataCreate = s3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(dataTask[position]);
        holder.text2.setText(dataDL[position]);
        holder.text3.setText(dataCreate[position]);
    }

    @Override
    public int getItemCount() {
        return dataTask.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2, text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text_task);
            text2 = itemView.findViewById(R.id.text_deadline);
            text3 = itemView.findViewById(R.id.text_tglCreate);
        }
    }
}
