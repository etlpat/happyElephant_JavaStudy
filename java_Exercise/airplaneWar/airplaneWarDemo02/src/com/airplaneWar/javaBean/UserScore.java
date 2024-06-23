package com.airplaneWar.javaBean;

public class UserScore {
    private String username;
    private String gameDateTime;
    private int score;
    private int flyDistance;

    public UserScore() {
    }

    public UserScore(String username, String gameDateTime, int score, int flyDistance) {
        this.username = username;
        this.gameDateTime = gameDateTime;
        this.score = score;
        this.flyDistance = flyDistance;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "username='" + username + '\'' +
                ", gameDateTime='" + gameDateTime + '\'' +
                ", score=" + score +
                ", flyDistance=" + flyDistance +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGameDateTime() {
        return gameDateTime;
    }

    public void setGameDateTime(String gameDateTime) {
        this.gameDateTime = gameDateTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFlyDistance() {
        return flyDistance;
    }

    public void setFlyDistance(int flyDistance) {
        this.flyDistance = flyDistance;
    }
}
