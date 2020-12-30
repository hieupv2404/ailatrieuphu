package com.group7.com.altp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.group7.com.altp.R;
import com.group7.com.altp.activity.ActivityPlayGame;


public class DalogCall extends Dialog implements View.OnClickListener {
    private ImageButton imgBtnCongVinh, imgBtnRonaldo, imgBtnSuarez;
    private TextView tvAdvice;

    public DalogCall(@NonNull Context context) {
        super(context);
        inisView();
    }

    private void inisView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_call);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        imgBtnRonaldo = findViewById(R.id.imgronaldo);
        imgBtnCongVinh = findViewById(R.id.congvinh);
        imgBtnSuarez = findViewById(R.id.suarez);
        tvAdvice = findViewById(R.id.tvadvice);

        imgBtnRonaldo.setOnClickListener(this);
        imgBtnCongVinh.setOnClickListener(this);
        imgBtnSuarez.setOnClickListener(this);
        tvAdvice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.suarez:
                tvAdvice.setText("Suarez khuyên bạn chọn đáp án " + ActivityPlayGame.tvTrue.substring(0, 1));
                break;
            case R.id.congvinh:

                tvAdvice.setText("Công Vinh khuyên bạn chọn đáp án " + ActivityPlayGame.tvTrue.substring(0, 1));
                break;

            case R.id.imgronaldo:
                tvAdvice.setText("Ronaldo khuyên bạn chọn đáp án " + ActivityPlayGame.tvTrue.substring(0, 1));
                break;

            default:
                break;

        }
    }
}
