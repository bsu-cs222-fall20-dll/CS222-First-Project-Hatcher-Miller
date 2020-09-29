package firstProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisplayRecentAuthors extends AuthorListParser{
    public void displayAuthors(){

        ArrayList<Author> authorList = parseJSON();
        if(authorList.size()<20){
            for (int i = 0; i < authorList.size(); i++){
                String user = authorList.get(i).getUser();
                String timestamp = authorList.get(i).getTimeStamp();
                System.out.println(user + "\n" + timestamp);
            }

        }else {
            for (int i = 0; i < 20; i++) {
                String user = authorList.get(i).getUser();
                String timestamp = authorList.get(i).getTimeStamp();
                System.out.println(user + "\n" + timestamp);
            }
        }
    }
}