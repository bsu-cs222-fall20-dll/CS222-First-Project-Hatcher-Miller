package firstProject;

import java.util.Date;

public class Author {

    public String user;
    public String timeStamp;

    public Author(String user, String timeStamp){
        user=user.replaceAll("\"" , "");
        timeStamp=timeStamp.replaceAll("\"" , "");
    }
}
