package edu.bsu.cs222;

public class Revisions {
    private String user;
    private String timeStamp;

    public Revisions(String user, String timestamp) {
        this.user = user;
        this.timeStamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
