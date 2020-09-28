package firstProject;

import java.util.ArrayList;
import java.util.List;

public class DisplayRecentAuthors extends AuthorListParser{
    public void displayAuthors(){

        ArrayList<Author> authorlist = parseJSON();
        if(authorlist.size()<20){
            for (int i = 0; i < authorlist.size(); i++){
                String user = authorlist.get(i).getUser();
                String timestamp = authorlist.get(i).getTimeStamp();
                System.out.println(user + "/n" + timestamp);
            }
        }else {
            for (int i = 0; i < 20; i++) {
                String user = authorlist.get(i).getUser();
                String timestamp = authorlist.get(i).getTimeStamp();
                System.out.println(user + "/n" + timestamp);
            }
        }
    }
}