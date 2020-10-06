package edu.bsu.cs222;

public class Author {
    public String user;
    public String timeStamp;

    public String getUser() {
        return user;
    }

    public void setAuthor(String userSet, String timeStampSet){
        user=userSet.replaceAll("\"" , "");
        timeStamp=timeStampSet.replaceAll("\"" , "");
    }

    public Author(String userSet, String timestampSet){
        setAuthor(userSet, timestampSet);
    }
}
