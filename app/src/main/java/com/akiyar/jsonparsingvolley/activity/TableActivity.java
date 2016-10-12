package com.akiyar.jsonparsingvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akiyar.jsonparsingvolley.R;
import com.akiyar.jsonparsingvolley.adapter.SensorAdapter;
import com.akiyar.jsonparsingvolley.model.AllData;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    private List<AllData> allDatas= new ArrayList<AllData>();
    private RecyclerView recyclerView;
    private SensorAdapter sensorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_ph);

        sensorAdapter = new SensorAdapter(allDatas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sensorAdapter);

        allDatas.add(new AllData("2", "15", "12", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("5", "50", "14", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("13", "80", "3", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("7", "22", "5", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("9", "44", "10", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("4", "78", "7", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("8", "12", "6", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("11", "35", "7", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("12", "60", "14", "normal", "12 january 2017","87"));

        sensorAdapter.notifyDataSetChanged();
    }
}
