package com.group7.com.altp;

import android.app.Application;


public class MyApplication extends Application {
    private PostScore postScore;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void postScore(int score) {
        if (postScore == null) {
            return;
        }
        postScore.postscore(score);
    }

    public void setPostScore(PostScore postScore) {
        this.postScore = postScore;
    }

    public interface PostScore {
        void postscore(int score);
    }
}
