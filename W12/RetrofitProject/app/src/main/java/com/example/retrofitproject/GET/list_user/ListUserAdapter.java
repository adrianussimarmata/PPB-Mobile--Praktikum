package com.example.retrofitproject.GET.list_user;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitproject.R;

import org.w3c.dom.Text;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> list_user;

    public ListUserAdapter(Context context, List<DataItem> list_user) {
        this.context = context;
        this.list_user = list_user;
    }

    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.ViewHolder holder, int position) {
        holder.text_first_name.setText(list_user.get(position).getFirstName());
        holder.text_last_name.setText(list_user.get(position).getLastName());
        holder.text_email.setText(list_user.get(position).getEmail());
        Glide.with(context).load(list_user.get(position).getAvatar()).into(holder.img_avatar);
    }

    @Override
    public int getItemCount() {
        return list_user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_avatar;
        TextView text_first_name;
        TextView text_last_name;
        TextView text_email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_first_name = itemView.findViewById(R.id.text_first_name);
            text_last_name = itemView.findViewById(R.id.text_last_name);
            text_email = itemView.findViewById(R.id.text_email);
            img_avatar = itemView.findViewById(R.id.img_avatar);
        }
    }
}
