package com.example.coronainfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.coronainfo.R;
import com.example.coronainfo.api.ResponeDataRs;

import java.util.List;

public class RsAdapter extends RecyclerView.Adapter<RsAdapter.MyViewHolder> {
    private Context context;
    private List<ResponeDataRs> listRS;

    public RsAdapter(Context context, List<ResponeDataRs> listRS){
        this.context = context;
        this.listRS = listRS;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_rs, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ResponeDataRs data = listRS.get(position);
        holder.tvAlamat.setText(data.getAlamat());
        holder.tvName.setText(data.getNama());
        holder.btnMaps.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse(
                    "geo:"+ data.getLongitude().toString() +
                            "," + data.getLatitude() +
                            "?q="+data.getNama());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return listRS.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAlamat;
        Button btnMaps;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_rs);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btnMap);
        }
    }
}
