package com.group7.com.altp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.group7.com.altp.R;
import com.group7.com.altp.adpter.AdapterHighScore;
import com.group7.com.altp.database.DatabaseManager;
import com.group7.com.altp.highscore.HighScore;

public class HightScoreActivity extends AppCompatActivity implements AdapterHighScore.IGetH {
    DatabaseManager databaseManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hight_score);
        databaseManager = new DatabaseManager(this);
        AdapterHighScore adapterHighScore = new AdapterHighScore(this);
        recyclerView = findViewById(R.id.rc_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterHighScore);
        init();
    }

    private void init() {
        if (databaseManager != null) {
            databaseManager.getHightScore();

        }

    }

    @Override
    public int getCount() {
        if (databaseManager == null) {
            return 0;
        }
        return databaseManager.getHighScores().size();
    }

    @Override
    public HighScore getItems(int position) {
        return databaseManager.getHighScores().get(position);
    }
}
