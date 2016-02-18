package com.climacidades.asoares.climacidades.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climacidades.asoares.climacidades.R;
import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;

import java.util.List;

/**
 * Created by asoares on 18/02/16.
 */
public class CidadeAdapter extends RecyclerView.Adapter<CidadeAdapter.CidadeAdapterViewHolder>{

    public Context context;
    private List<MonitoramentoCidades> mMonitoramentoCidadesList;


    public CidadeAdapter(Context context, List<MonitoramentoCidades> mMonitoramentoCidadesList) {
        this.context = context;
        this.mMonitoramentoCidadesList = mMonitoramentoCidadesList;
    }

    @Override
    public CidadeAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cidade, viewGroup, false);
        CidadeAdapterViewHolder pvh = new CidadeAdapterViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CidadeAdapterViewHolder holder, int position)
    {
        holder.tvNomeCidade.setText(mMonitoramentoCidadesList.get(position).getNomeCidade());
    }

    @Override
    public int getItemCount() {
        return mMonitoramentoCidadesList.size();
    }

    public static class CidadeAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView tvNomeCidade;

        public CidadeAdapterViewHolder(View itemView) {
            super(itemView);

            tvNomeCidade = (TextView)itemView.findViewById(R.id.tvNomeCidade);
        }
    }

}
