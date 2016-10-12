package com.akiyar.jsonparsingvolley.adapter;

/**
 * Created by ALDI on 10/13/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akiyar.jsonparsingvolley.R;
import com.akiyar.jsonparsingvolley.model.AllData;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {
    private List<AllData> sensorList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView no, nilai, waktu;
        public ViewHolder(View view) {
            super(view);
            no = (TextView) view.findViewById(R.id.no);
            nilai = (TextView) view.findViewById(R.id.nilai);
            waktu = (TextView) view.findViewById(R.id.waktu);
        }
    }

    public SensorAdapter(List<AllData> sensorList) {
        this.sensorList = sensorList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sensor_data_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AllData allData = sensorList.get(position);
        holder.no.setText(String.valueOf(position+1));
        holder.nilai.setText(allData.getPh());
        holder.waktu.setText(allData.getWaktu());
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }
}