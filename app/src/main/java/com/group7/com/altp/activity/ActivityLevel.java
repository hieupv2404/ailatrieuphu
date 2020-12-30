package com.group7.com.altp.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.group7.com.altp.R;
import com.group7.com.altp.database.DatabaseManager;


public class ActivityLevel extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTiepTuc;
    private TextView tvLevel1, tvLevel2, tvLevel3, tvLevel4, tvLevel5, tvLevel6, tvLevel7, tvLevel8,
            tvLevel9, tvLevel10, tvLevel11, tvLevel12, tvLevel13, tvLevel14, tvLevel15;

    private List<TextView> tv;
    private MediaPlayer mediaLevel51015;
    private MediaPlayer mdaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        if (MainActivity.isPlay == true) {
            mdaPlayer = MediaPlayer.create(this, R.raw.luatchoi_b);
            mdaPlayer.start();
            MainActivity.isPlay = false;
            new CountDownTimer(8000, 1300) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    mdaPlayer.release();
                    Intent intent = new Intent(ActivityLevel.this, ActivityPlayGame.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter,R.anim.exist);


                }
            }.start();
        } else {
            new CountDownTimer(3000, 1000) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    Intent intent = new Intent(ActivityLevel.this, ActivityPlayGame.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter,R.anim.exist);


                }
            }.start();
        }
        inisView();
        inisBackGround();

    }

    @Override
    public void onBackPressed() {
        return;
    }

    private void inisBackGround() {
        switch (DatabaseManager.number) {
            case 1:
                tvLevel1.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 2:
                tvLevel2.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 3:
                tvLevel3.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 4:
                tvLevel4.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 5:
                tvLevel5.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 6:
                tvLevel6.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 7:
                tvLevel7.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 8:
                tvLevel8.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 9:
                tvLevel9.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 10:
                tvLevel10.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 11:
                tvLevel11.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 12:
                tvLevel12.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 13:
                tvLevel13.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 14:
                tvLevel14.setBackgroundResource(R.drawable.bg_choose2);
                break;
            case 15:
                tvLevel15.setBackgroundResource(R.drawable.bg_choose2);
                break;

        }
    }


    private void inisView() {
        tvLevel1 = findViewById(R.id.tvleve1);
        tvLevel2 = findViewById(R.id.tvleve2);
        tvLevel3 = findViewById(R.id.tvleve3);
        tvLevel4 = findViewById(R.id.tvlevel4);
        tvLevel5 = findViewById(R.id.tvlevel5);
        tvLevel6 = findViewById(R.id.tvlevel6);
        tvLevel7 = findViewById(R.id.tvlevel7);
        tvLevel8 = findViewById(R.id.tvlevel8);
        tvLevel9 = findViewById(R.id.tvlevel9);
        tvLevel10 = findViewById(R.id.tvlevel10);
        tvLevel11 = findViewById(R.id.tvlevel11);
        tvLevel12 = findViewById(R.id.tvlevel12);
        tvLevel13 = findViewById(R.id.tvlevel13);
        tvLevel14 = findViewById(R.id.tvlevel14);
        tvLevel15 = findViewById(R.id.tvlevel15);
        tv = new ArrayList<>();
        tv.add(tvLevel1);
        tv.add(tvLevel2);
        tv.add(tvLevel3);
        tv.add(tvLevel4);
        tv.add(tvLevel5);
        tv.add(tvLevel6);
        tv.add(tvLevel7);
        tv.add(tvLevel8);
        tv.add(tvLevel9);
        tv.add(tvLevel10);
        tv.add(tvLevel11);
        tv.add(tvLevel12);
        tv.add(tvLevel13);
        tv.add(tvLevel14);
        tv.add(tvLevel5);

    }

    @Override
    public void onClick(View view) {
        String str = null;
        for (int i = 0; i < tv.size(); i++) {

//            if (DatabaseManager.isCkeckAnswer()==true){
//                it.putExtra(str,"0");
//                str = tv.get(i).getText().toString();
//
//
//                Log.d("bbbbbbbbbbbbbbbbbb",str);
//                DatabaseManager.setCkeckAnswer(false);
//            }

//        }
//
//        startActivity(it);
        }
    }
}
