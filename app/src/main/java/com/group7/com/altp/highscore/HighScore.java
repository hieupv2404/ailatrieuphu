package com.group7.com.altp.highscore;

public class HighScore {
    private int id;
    private String name;
    private int levelPass;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelPass() {
        return levelPass;
    }

    public void setLevelPass(int levelPass) {
        this.levelPass = levelPass;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
