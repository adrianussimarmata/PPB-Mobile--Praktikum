package com.example.tugasku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private List<Task> tasks = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public TaskAdapter(Context context) {
        this.context = context;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public Task getTaskAt(int position) {
        return tasks.get(position);
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.task_item, parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task currentTask = tasks.get(position);
        holder.textViewTitle.setText(currentTask.getTitle());
        holder.textViewCreate.setText(currentTask.getCreate_date());
        holder.textViewDeadline.setText(currentTask.getDeadline());
//        holder.textViewNote.setText(currentTask.getNote());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailTaskActivity.class);
                intent.putExtra("judulTugas", currentTask.getTitle());
                intent.putExtra("tgl_deadline", currentTask.getDeadline());
                intent.putExtra("catatan_tugas", currentTask.getNote());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDeadline;
        private TextView textViewCreate;
//        private TextView textViewNote;
        ConstraintLayout constraintLayout;

        public TaskHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_task);
            textViewCreate = itemView.findViewById(R.id.text_tglCreate);
            textViewDeadline = itemView.findViewById(R.id.text_deadline);
//            textViewNote = itemView.findViewById(R.id.text_note);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
