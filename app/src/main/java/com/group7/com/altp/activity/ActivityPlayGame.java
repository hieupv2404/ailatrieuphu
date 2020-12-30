package com.group7.com.altp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import com.group7.com.altp.R;
import com.group7.com.altp.database.DatabaseManager;
import com.group7.com.altp.dialog.DalogCall;
import com.group7.com.altp.dialog.DialogCustom;
import com.group7.com.altp.dialog.SimpleBarDialog;


public class ActivityPlayGame extends AppCompatActivity implements View.OnClickListener {

    private String selectAnswer;
    private DatabaseManager databaseManager;
    private Button btbAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    private TextView btnAsk, tvTimer, tvLevel, tvScores;
    private ImageButton imgbtnCall, ingbtnHelp, imgbtn50Percent, imgbtnRestart, imgbtnStop;
    private ImageButton imgbtnCallX, ingbtnHelpX, imgbtn50PercentX, imgbtnRestartX, imgbtnStopX;
    private MediaPlayer mdiaLevel, mediaAnswer;
    private MediaPlayer mdiaCheckFalse;
    private AnimationDrawable animationDrawable;
    private MediaPlayer mdiaCheckTrue, mediaHelp;
    public static String tvTrue;
    private MediaPlayer mediaImpostant;
    private MediaPlayer mediaClick;
    private boolean checkClick;
    public static boolean isPlay=true;

    public static boolean isShowDialog=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        inisMusic();
        inisView();
        checkClick = true;
        databaseManager = new DatabaseManager(this);
        databaseManager.queryFitTeen();
        inisData();
        inisScores();
        databaseManager.getHightScore();
        timerCountDown(this);

        getTextTrue();
        if (MainActivity.btnCall == false) {
            imgbtnCallX.setVisibility(View.VISIBLE);
        }
        if (MainActivity.btnPercent == false) {
            imgbtn50PercentX.setVisibility(View.VISIBLE);
        }
        if (MainActivity.btnStart == false) {
            imgbtnRestartX.setVisibility(View.VISIBLE);
        }
        if (MainActivity.btnHelp == false) {
            ingbtnHelpX.setVisibility(View.VISIBLE);
        }
    }

    private void inisScores() {
        switch (DatabaseManager.number - 1) {
            case 0:
                tvScores.setText("0");
                break;
            case 1:
                tvScores.setText("200,000");
                break;
            case 2:
                tvScores.setText("400,000");
                break;
            case 3:
                tvScores.setText("600,000");
                break;
            case 4:
                tvScores.setText("1,000,000");
                break;
            case 5:
                tvScores.setText("2,000,000");
                break;
            case 6:
                tvScores.setText("3,000,000");
                break;
            case 7:
                tvScores.setText("6,000,000");
                break;
            case 8:
                tvScores.setText("10,000,000");
                break;
            case 9:
                tvScores.setText("14,000,000");
                break;
            case 10:
                tvScores.setText("20,000,000");
                break;
            case 11:
                tvScores.setText("30,000,000");
                break;
            case 12:
                tvScores.setText("40,000,000");
                break;
            case 13:
                tvScores.setText("60,00,000");
                break;
            case 14:
                tvScores.setText("85,000,000");
                break;
            case 15:
                tvScores.setText("150,000,000");
                break;

            default:
                break;
        }
    }

    private void inisMusic() {
        switch (DatabaseManager.number) {
            case 1:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques1);
                mdiaLevel.start();
                break;

            case 2:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques2);
                mdiaLevel.start();
                break;

            case 3:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques3);
                mdiaLevel.start();
                break;
            case 4:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques4);
                mdiaLevel.start();
                break;
            case 5:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques5);
                mdiaLevel.start();
                delayMediaImpostant();

                break;

            case 6:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques6);
                mdiaLevel.start();
                break;

            case 7:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques7);
                mdiaLevel.start();
                break;

            case 8:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques8);
                mdiaLevel.start();
                break;

            case 9:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques9);
                mdiaLevel.start();
                break;
            case 10:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques10);
                mdiaLevel.start();
                delayMediaImpostant();
                break;
            case 11:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques11);
                mdiaLevel.start();
                break;
            case 12:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques12);
                mdiaLevel.start();
                break;
            case 13:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques13);
                mdiaLevel.start();
                break;
            case 14:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques14);
                mdiaLevel.start();
                break;

            case 15:
                mdiaLevel = MediaPlayer.create(this, R.raw.ques15);
                mdiaLevel.start();
                break;
        }
    }

    private void delayMediaImpostant() {
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                mediaImpostant();
            }
        }.start();
    }

    private void mediaImpostant() {
        mediaImpostant = MediaPlayer.create(this, R.raw.important);
        mediaImpostant.start();
    }


    public static boolean isIsShowDialog() {
        return isShowDialog;
    }

    public static void setIsShowDialog(boolean isShowDialog) {
        ActivityPlayGame.isShowDialog = isShowDialog;
    }
    private void timerCountDown(final Context context) {
        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long l) {
                if (checkClick == true) {
                    tvTimer.setText(l / 1000 + "");
                }

            }
            @Override
            public void onFinish() {
                isPlay = false;
                if (checkClick==true){
                    tvTimer.setText("0");
                    Intent intent = new Intent(ActivityPlayGame.this,MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter,R.anim.exist);

                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                        isShowDialog=true;

                    }

                }

            }

        }.start();

    }

    private void inisData() {
        btnAsk.setText(DatabaseManager.question.getAsk());
        btbAnswer1.setText("A." + DatabaseManager.question.getRa());
        btnAnswer2.setText("B." + DatabaseManager.question.getRb());
        btnAnswer3.setText("C." + DatabaseManager.question.getRc());
        btnAnswer4.setText("D." + DatabaseManager.question.getRd());
        tvTimer = findViewById(R.id.tvtimer);
        //level=1;
//        Log.d("number",""+DatabaseManager.getNumber());
        tvLevel.setText("Câu " + DatabaseManager.getNumber() + "");
    }


    private void inisView() {
        btnAsk = findViewById(R.id.tvquestion);
        btbAnswer1 = findViewById(R.id.answer1);
        btnAnswer2 = findViewById(R.id.answer2);
        btnAnswer3 = findViewById(R.id.answer3);
        btnAnswer4 = findViewById(R.id.answer4);
        btbAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);
        tvLevel = findViewById(R.id.tvlevel);
        imgbtnCall = findViewById(R.id.imgcall);
        imgbtnCallX = findViewById(R.id.imgcallx);
        imgbtnCall.setOnClickListener(this);
        tvScores = findViewById(R.id.scores);
        ingbtnHelp = findViewById(R.id.imghelp);
        ingbtnHelpX = findViewById(R.id.imghelpx);
        ingbtnHelp.setOnClickListener(this);
        imgbtn50Percent = findViewById(R.id.imgpercent50);
        imgbtn50PercentX = findViewById(R.id.imgpercent50x);
        imgbtn50Percent.setOnClickListener(this);
        imgbtnRestart = findViewById(R.id.imgrestart);
        imgbtnRestartX = findViewById(R.id.imgrestartx);
        imgbtnRestart.setOnClickListener(this);
        imgbtnStop = findViewById(R.id.imgstop);
        imgbtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mdiaLevel.release();
        switch (view.getId()) {
            case R.id.answer1:
                btbAnswer1.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_a);
                mediaAnswer.start();
                selectAnswer = btbAnswer1.getText().toString();
                btnAnswer2.setEnabled(false);
                btnAnswer3.setEnabled(false);
                btnAnswer4.setEnabled(false);
                btbAnswer1.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btbAnswer1.getBackground();
                animationDrawable.start();
                if (selectAnswer.substring(2).equals(DatabaseManager.answer)) {
//                    level++;
                    DatabaseManager.number++;
                    DatabaseManager.setCkeckAnswer(true);
//                    releaseMediaTrue();
//                    releaseMediaFalse();
                    mdiaCheckTrue = MediaPlayer.create(this, R.raw.true_a);
                    new CountDownTimer(5000, 1000) {

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {

                            mdiaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000, 1000) {

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                            releaseMediaFalse();
                        }
                    }.start();
                    delay();
//                    DatabaseManager.setNumber(level);
                    DialogCustom.level++;
                } else {

                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                        isShowDialog=true;

                    }
                    MainActivity.isPlay = true;
                    DatabaseManager.number = 1;
                    new CountDownTimer(7000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
//                            releaseMediaFalse();
                            checkTrueAudio();
//                            releaseMediaTrue();

                            new CountDownTimer(6000, 1000) {

                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {

                                    Intent intent = new Intent(ActivityPlayGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
//                            Log.d("fdfdfd", "" + DatabaseManager.isCkeckAnswer());
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                }
                break;
            case R.id.answer2:
                btnAnswer2.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_b);
                mediaAnswer.start();
                selectAnswer = btnAnswer2.getText().toString();
                btbAnswer1.setEnabled(false);
                btnAnswer3.setEnabled(false);
                btnAnswer4.setEnabled(false);
                btnAnswer2.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnAnswer2.getBackground();
                animationDrawable.start();
                if (selectAnswer.substring(2).equals(DatabaseManager.answer)) {
                    mdiaCheckTrue = MediaPlayer.create(this, R.raw.true_b);
                    new CountDownTimer(5000, 1000) {
                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            mdiaCheckTrue.start();
                        }
                    }.start();
//                    level++;
                    DatabaseManager.number++;
                    DatabaseManager.setCkeckAnswer(true);
                    delay();
                    new CountDownTimer(9000, 1000) {
                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                            releaseMediaFalse();
                        }
                    }.start();
                    DialogCustom.level++;
                } else {

                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                        isShowDialog=true;

                    }
                    DatabaseManager.number = 1;
                    MainActivity.isPlay = true;
                    new CountDownTimer(5000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
//                            releaseMediaFalse();
                            checkTrueAudio();
//                            releaseMediaTrue();
                            new CountDownTimer(6000, 1000) {
                                @Override
                                public void onTick(long l) {
                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityPlayGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();
//                            Log.d("fdfdfd", "" + DatabaseManager.isCkeckAnswer());
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                }
                break;
            case R.id.answer3:
                btnAnswer3.setEnabled(false);
                checkClick = false;
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_c2);
                mediaAnswer.start();
                selectAnswer = btnAnswer3.getText().toString();
                btnAnswer2.setEnabled(false);
                btbAnswer1.setEnabled(false);
                btnAnswer4.setEnabled(false);
                btnAnswer3.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnAnswer3.getBackground();
                animationDrawable.start();
                if (selectAnswer.substring(2).equals(DatabaseManager.answer)) {
                    DatabaseManager.number++;
                    DatabaseManager.setCkeckAnswer(true);
                    mdiaCheckTrue = MediaPlayer.create(this, R.raw.true_c);
                    new CountDownTimer(5000, 1000) {
                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            mdiaCheckTrue.start();
                        }
                    }.start();
                    new CountDownTimer(9000, 1000) {

                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                            releaseMediaFalse();
                        }
                    }.start();
                    delay();
                 DialogCustom.level++;
                } else {

                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                        isShowDialog=true;

                    }
                    MainActivity.isPlay = true;
                    DatabaseManager.number = 1;
                    new CountDownTimer(5000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
//                            releaseMediaFalse();
                            checkTrueAudio();
                            // releaseMediaTrue();

                            new CountDownTimer(6000, 1000) {
                                @Override
                                public void onTick(long l) {
                                }

                                @Override
                                public void onFinish() {
                                    Intent intent = new Intent(ActivityPlayGame.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }.start();

//                            Log.d("fdfdfd", "" + DatabaseManager.isCkeckAnswer());
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();


                }


                break;
            case R.id.answer4:
                btnAnswer4.setEnabled(false);
                checkClick = false;
//                releaseMediaTrue();
//                releaseMediaFalse();
                mediaAnswer = MediaPlayer.create(this, R.raw.ans_d2);
                mediaAnswer.start();
                selectAnswer = btnAnswer4.getText().toString();

                btnAnswer2.setEnabled(false);
                btnAnswer3.setEnabled(false);
                btbAnswer1.setEnabled(false);

                btnAnswer4.setBackgroundResource(R.drawable.drawable_choose);
                animationDrawable = (AnimationDrawable) btnAnswer4.getBackground();
                animationDrawable.start();
                if (selectAnswer.substring(2).equals(DatabaseManager.answer)) {
//                    releaseMediaFalse();
//                    level++;
                    DatabaseManager.number++;
                    DatabaseManager.setCkeckAnswer(true);
                    mdiaCheckTrue = MediaPlayer.create(this, R.raw.true_d2);
                    new CountDownTimer(5000, 1000) {

                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
//                            releaseMediaFalse();
                            mdiaCheckTrue.start();
                        }

                    }.start();
                    new CountDownTimer(9000, 1000) {

                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            releaseMediaTrue();
                            releaseMediaFalse();
                        }
                    }.start();
                    delay();
//                    DatabaseManager.setNumber(level);
                    DialogCustom.level++;
                } else {


                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                        isShowDialog=true;

                    }
                    MainActivity.isPlay = true;
                    DatabaseManager.number = 1;
                    new CountDownTimer(5000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
//                            releaseMediaFalse();
                            checkTrueAudio();
//                            releaseMediaTrue();
                            new CountDownTimer(6000, 1000) {
                                @Override
                                public void onTick(long l) {
                                }

                                @Override
                                public void onFinish() {

                                    Intent intent = new Intent(ActivityPlayGame.this, MainActivity.class);
                                    if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                                        isShowDialog=true;

                                    }
                                    startActivity(intent);
                                }
                            }.start();
//                            Log.d("fdfdfd", "" + DatabaseManager.isCkeckAnswer());
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                }
                break;

            case R.id.imgcall:
                mediaClick();
                releaseMediaHelp();
                releaseMediaFalse();
                releaseMediaTrue();
                mediaHelp = MediaPlayer.create(this, R.raw.help_call);
                mediaHelp.start();
                DalogCall dialogUser = new DalogCall(this);
                dialogUser.setCancelable(true);
                dialogUser.setCanceledOnTouchOutside(true);
                dialogUser.show();
                imgbtnCall.setEnabled(false);
                imgbtnCallX.setVisibility(View.VISIBLE);
                MainActivity.btnCall = false;
                break;

            case R.id.imgpercent50:
                mediaClick();
                releaseMediaFalse();
                releaseMediaTrue();
                releaseMediaHelp();
                mediaHelp = MediaPlayer.create(this, R.raw.sound5050);
                mediaHelp.start();
                imgbtn50Percent.setEnabled(false);
                imgbtn50PercentX.setVisibility(View.VISIBLE);
                new CountDownTimer(3500, 1000) {

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        percent50();
                    }
                }.start();

                MainActivity.btnPercent = false;
                imgbtn50PercentX.setVisibility(View.VISIBLE);
                break;

            case R.id.imgrestart:
                mediaClick();
                databaseManager.queryFitTeen();
                inisData();
                MainActivity.btnStart = false;
                imgbtnRestartX.setVisibility(View.VISIBLE);
                break;
            case R.id.imghelp:
                mediaClick();
                releaseMediaFalse();
                releaseMediaTrue();
                releaseMediaHelp();
                mediaHelp = MediaPlayer.create(this, R.raw.khan_gia);
                mediaHelp.start();
                final SimpleBarDialog simpleBar_dialog = new SimpleBarDialog(this);
                new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        simpleBar_dialog.show();
                    }
                }.start();

                MainActivity.btnHelp = false;
                ingbtnHelpX.setVisibility(View.VISIBLE);
                break;
            case R.id.imgstop:
                checkClick=false;
                Intent intent = new Intent(ActivityPlayGame.this,MainActivity.class);

                if (databaseManager.getHighScores().get(0).getLevelPass()<DialogCustom.level){
                    isShowDialog=true;

                }
                startActivity(intent);


                break;
            default:
                break;
        }
    }

    private void mediaClick() {
        mediaClick = MediaPlayer.create(this, R.raw.touch_sound);
        mediaClick.start();
    }

    private void releaseMediaHelp() {
        if (mediaHelp != null) {
            mediaHelp.release();
        }
    }

    private void releaseMediaFalse() {
        if (mdiaCheckFalse != null) {
            mdiaCheckFalse.release();
        }
    }

    private void delay() {
        new CountDownTimer(5000, 1000) {
            public void onFinish() {
                // When timer is finished
                // Execute your code here
                checkTrueAnswer();
                new CountDownTimer(4000, 1000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(ActivityPlayGame.this, ActivityLevel.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter,R.anim.exist);
                    }
                }.start();

            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();
    }

    private void checkTrueAnswer() {
        List<TextView> tv = new ArrayList<>();
        tv.add(btbAnswer1);
        tv.add(btnAnswer2);
        tv.add(btnAnswer3);
        tv.add(btnAnswer4);
        String t;
        for (int i = 0; i < tv.size(); i++) {
            t = tv.get(i).getText().toString();
            if (t.contains(DatabaseManager.answer)) {

                tv.get(i).setBackgroundResource(R.drawable.drawable_choose_true);
                AnimationDrawable animationDrawable = (AnimationDrawable) tv.get(i).getBackground();
                animationDrawable.start();
            }
        }

    }

    private void getTextTrue() {
        List<TextView> tv = new ArrayList<>();
        tv.add(btbAnswer1);
        tv.add(btnAnswer2);
        tv.add(btnAnswer3);
        tv.add(btnAnswer4);
        String t;
        for (int i = 0; i < tv.size(); i++) {
            t = tv.get(i).getText().toString();
            if (t.substring(2).equals(DatabaseManager.answer)) {

                tvTrue = tv.get(i).getText().toString();
            }
        }
    }

    private void checkTrueAudio() {

        List<TextView> tv = new ArrayList<>();
        tv.add(btbAnswer1);
        tv.add(btnAnswer2);
        tv.add(btnAnswer3);
        tv.add(btnAnswer4);
        String t;
        for (int i = 0; i < tv.size(); i++) {
            t = tv.get(i).getText().toString();
            if (t == "") {
                        return;
            } else {
                if (t.substring(2).contains(DatabaseManager.answer)) {
                    switch (i) {
                        case 0:
                            mdiaCheckFalse = MediaPlayer.create(this, R.raw.lose_a);
                            mdiaCheckFalse.start();
                            break;
                        case 1:
                            mdiaCheckFalse = MediaPlayer.create(this, R.raw.lose_b2);
                            mdiaCheckFalse.start();
                            break;
                        case 2:
                            mdiaCheckFalse = MediaPlayer.create(this, R.raw.lose_c2);
                            mdiaCheckFalse.start();
                            break;
                        case 3:
                            mdiaCheckFalse = MediaPlayer.create(this, R.raw.lose_d2);
                            mdiaCheckFalse.start();
                            break;
                        default:
                            break;
                    }
                    tv.get(i).setBackgroundResource(R.drawable.drawable_choose_true);
                    AnimationDrawable animationDrawable = (AnimationDrawable) tv.get(i).getBackground();
                    animationDrawable.start();
                }
            }
        }
    }

    private void releaseMediaTrue() {
        if (mdiaCheckTrue != null) {
            mdiaCheckTrue.release();
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

    private void percent50() {
        List<TextView> tv1 = new ArrayList<>();
        tv1.add(btbAnswer1);
        tv1.add(btnAnswer2);
        tv1.add(btnAnswer3);
        tv1.add(btnAnswer4);
        String t;
        for (int i = 0; i < tv1.size(); i++) {
            t = tv1.get(i).getText().toString();
            if (t.substring(2).equals(DatabaseManager.answer)) {
                tv1.remove(i);
            }
        }
        Random rd = new Random();
        Vector v = new Vector();
        int iNew = 0;
        for (int i = 0; i < 2; ) {
            iNew = rd.nextInt(tv1.size());
            if (!v.contains(iNew)) {
                i++;
                v.add(iNew);
                tv1.get(i).setText("");
            }
        }
    }
}
