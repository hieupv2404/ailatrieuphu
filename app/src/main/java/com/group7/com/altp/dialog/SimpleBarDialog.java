package com.group7.com.altp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group7.com.altp.R;
import com.group7.com.altp.activity.ActivityPlayGame;


public class SimpleBarDialog extends Dialog {
    private BarChart barChart;
    private int yA, yB, yC, yD;
    private Random rd;

    public SimpleBarDialog(@NonNull Context context) {
        super(context);
        inisView();
        inisAnswerTrue();
        inisData();
    }

    private void random() {
        rd = new Random();
    }

    private void inisView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_simplebar);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        barChart = findViewById(R.id.simplebar);
    }


    private void inisAnswerTrue() {
        switch (ActivityPlayGame.tvTrue.substring(0, 1)) {
            case "A":
                random();
                yB = rd.nextInt(20);
                yC = rd.nextInt(20);
                yD = rd.nextInt(20);
                yA = rd.nextInt(100 - yB - yC - yD);

                break;
            case "B":
                random();
                yA = rd.nextInt(20);
                yC = rd.nextInt(20);
                yD = rd.nextInt(20);
                yB = rd.nextInt(100 - yA - yC - yD);
                break;
            case "C":
                random();
                yA = rd.nextInt(20);
                yB = rd.nextInt(20);
                yD = rd.nextInt(20);
                yC = rd.nextInt(100 - yB - yA - yD);
                break;
            case "D":
                random();
                yA = rd.nextInt(20);
                yC = rd.nextInt(20);
                yB = rd.nextInt(20);
                yD = rd.nextInt(100 - yB - yC - yA);
                break;
        }
    }

    private void inisData() {
        List<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(0f, yA));
        barEntries.add(new BarEntry(1f, yB));
        barEntries.add(new BarEntry(2f, yC));
        barEntries.add(new BarEntry(3f, yD));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
    }
}
