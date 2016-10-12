package com.akiyar.jsonparsingvolley.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.akiyar.jsonparsingvolley.R;
import com.akiyar.jsonparsingvolley.model.AllData;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DetailActivity extends AppCompatActivity {
    List<AllData> allDatas;
    LineChart chartPH, chartSuhu, chartDO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        allDatas = new ArrayList<AllData>();

        allDatas.add(new AllData("2", "15", "12", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("5", "50", "14", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("13", "80", "3", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("7", "22", "5", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("9", "44", "10", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("4", "78", "7", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("8", "12", "6", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("11", "35", "7", "normal", "12 january 2017","87"));
        allDatas.add(new AllData("12", "60", "14", "normal", "12 january 2017","87"));

        setupChart();

    }
    private void setupChart(){
        chartSuhu = (LineChart) findViewById(R.id.chart_suhu);
        chartPH = (LineChart) findViewById(R.id.chart_ph);
        chartDO = (LineChart) findViewById(R.id.chart_do);
        chartSuhu.setDescription("");
        chartPH.setDescription("");
        chartDO.setDescription("");

        updateChart();

    }
    private void updateChart(){
        ArrayList<Entry> entryPH = new ArrayList<>();
        ArrayList<String> labelPH = new ArrayList<>();

        ArrayList<Entry> entrySuhu = new ArrayList<>();
        ArrayList<String> labelSuhu = new ArrayList<>();

        ArrayList<Entry> entryDO = new ArrayList<>();
        ArrayList<String> labelDO = new ArrayList<>();

        entrySuhu.clear();
        labelSuhu.clear();

        // Date formater
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateFormat.setTimeZone(TimeZone.getDefault());

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setTimeZone(TimeZone.getDefault());
        // end date formater

        for(int i = 0; i<allDatas.size();i++){
            AllData dat = allDatas.get(i);
            float phh = Float.parseFloat(dat.getPh());
            float suhu = Float.parseFloat(dat.getSuhu());
            float dooo = Float.parseFloat(dat.getDoo());
            entryPH.add(new Entry(phh,i));
            labelPH.add(String.valueOf(i+1));

            entrySuhu.add(new Entry(suhu,i));
            labelSuhu.add(String.valueOf(i+1));

            entryDO.add(new Entry(dooo,i));
            labelDO.add(String.valueOf(i+1));
        }

        LineDataSet dataSetPH = new LineDataSet(entryPH, "Derajat keasaman");
        dataSetPH.setColor(Color.parseColor("#009688"));
        dataSetPH.setCircleColor(Color.parseColor("#ffcdd2"));
        dataSetPH.setCircleColorHole(Color.parseColor("#f44336"));

        LineDataSet dataSetSuhu = new LineDataSet(entrySuhu, "Derajat celcius");
        dataSetSuhu.setColor(Color.parseColor("#009688"));
        dataSetSuhu.setCircleColor(Color.parseColor("#ffcdd2"));
        dataSetSuhu.setCircleColorHole(Color.parseColor("#f44336"));

        LineDataSet dataSetDO = new LineDataSet(entryDO, "mg/L");
        dataSetDO.setColor(Color.parseColor("#009688"));
        dataSetDO.setCircleColor(Color.parseColor("#ffcdd2"));
        dataSetDO.setCircleColorHole(Color.parseColor("#f44336"));

        LineData dataPH = new LineData(labelPH, dataSetPH);
        LineData dataSuhu = new LineData(labelSuhu, dataSetSuhu);
        LineData dataDO = new LineData(labelDO, dataSetDO);

        chartPH.setData(dataPH);
        chartPH.notifyDataSetChanged();
        chartPH.animateY(1000);

        chartSuhu.setData(dataSuhu);
        chartSuhu.notifyDataSetChanged();
        chartSuhu.animateY(1000);

        chartDO.setData(dataDO);
        chartDO.notifyDataSetChanged();
        chartDO.animateY(1000);


    }
}
