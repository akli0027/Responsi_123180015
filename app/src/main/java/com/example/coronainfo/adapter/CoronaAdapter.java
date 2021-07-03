package com.example.coronainfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronainfo.R;
import com.example.coronainfo.api.ResponItemData;

import java.util.List;


public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.MyViewHolder> {
    private Context context;
    private List<ResponItemData> listCovid;

    public CoronaAdapter(Context context, List<ResponItemData> listCovid){
        this.context = context;
        this.listCovid = listCovid;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {
        final ResponItemData data = listCovid.get(position);

        holder.tvDate.setText(data.getTanggal());
        holder.tvKonfimasi.setText("Terkonfirmasi : " + data.getConfirmation());
        holder.tvSembuh.setText(   "Sembuh           : " + data.getConfirmationSelesai());
        holder.tvMeninggal.setText("Meninggal       : " + data.getConfirmationMeninggal());
    }

    @Override
    public int getItemCount() {
        return listCovid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvKonfimasi, tvSembuh, tvMeninggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKonfimasi = itemView.findViewById(R.id.tv_Terkonfirmasi);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_death);
        }
    }
}
