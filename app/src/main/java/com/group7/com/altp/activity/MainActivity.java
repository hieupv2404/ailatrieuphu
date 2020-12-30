package com.group7.com.altp.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.group7.com.altp.MyApplication;
import com.group7.com.altp.R;
import com.group7.com.altp.database.DatabaseManager;
import com.group7.com.altp.dialog.DialogCustom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyApplication.PostScore {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnPlay;
    private Button btnHightScore;
    public static boolean isPlay = true;
    public static boolean btnStart;
    public static boolean btnStop = true;
    public static boolean btnCall;
    public static boolean btnPercent;
    public static boolean btnHelp;
    private MediaPlayer musicMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisView();
        btnCall = true;
        btnPercent = true;
        btnStart = true;
        btnHelp = true;

        DatabaseManager.number = 1;
        if (ActivityPlayGame.isIsShowDialog() == true) {
            DialogCustom dialog_custom = new DialogCustom(MainActivity.this);
            dialog_custom.setCancelable(false);
            dialog_custom.setCanceledOnTouchOutside(false);
            dialog_custom.show();
            ActivityPlayGame.setIsShowDialog(false);
        }

        ((MyApplication) getApplicationContext()).setPostScore(this);
    }

    private void inisView() {
        btnPlay = findViewById(R.id.btnplay);
        btnPlay.setOnClickListener(this);
        btnHightScore = findViewById(R.id.btnhightscores);
        btnHightScore.setOnClickListener(this);
        musicMain = MediaPlayer.create(this, R.raw.bgmusic);
        musicMain.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnplay:
                Intent itPlay = new Intent(MainActivity.this, ActivityLevel.class);
                startActivity(itPlay);
                overridePendingTransition(R.anim.enter, R.anim.exist);
                musicMain.release();
                break;
            case R.id.btnhightscores:
                Intent itH = new Intent(MainActivity.this, HightScoreActivity.class);
                startActivity(itH);
                overridePendingTransition(R.anim.enter, R.anim.exist);
                musicMain.release();
        }

    }

    @Override
    public void postscore(int score) {
        Log.d(TAG, "postscore score: " + score);
    }

}
