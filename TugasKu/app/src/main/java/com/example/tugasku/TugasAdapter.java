package com.example.tugasku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.TugasAdapterVH> {

    public TugasAdapter() {
    }

    private List<Tugas> listTugas;
    private Context context;

    public void setData(List<Tugas> listTugas) {
        this.listTugas = listTugas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TugasAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new TugasAdapter.TugasAdapterVH(LayoutInflater.from(context).inflate(R.layout.tugas_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapterVH holder, int position) {
        Tugas tugas = listTugas.get(position);

        holder.tugas_judul.setText(tugas.getJudul_tugas());
        holder.tugas_tgl_masuk.setText(tugas.getTgl_tugas_masuk());
        holder.tugas_deadline.setText(tugas.getTgl_deadline());
        holder.tugas_catatan.setText(tugas.getCatatan());
    }

    @Override
    public int getItemCount() {
        return listTugas.size();
    }

    public class TugasAdapterVH extends RecyclerView.ViewHolder{

        TextView tugas_judul;
        TextView tugas_tgl_masuk;
        TextView tugas_deadline;
        TextView tugas_catatan;

        public TugasAdapterVH(@NonNull View itemView) {
            super(itemView);

            tugas_judul = itemView.findViewById(R.id.text_task);
            tugas_tgl_masuk = itemView.findViewById(R.id.text_tglCreate);
            tugas_deadline = itemView.findViewById(R.id.text_deadline);
            tugas_catatan = itemView.findViewById(R.id.text_note);
        }
    }
}
