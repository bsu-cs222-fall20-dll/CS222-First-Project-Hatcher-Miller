package firstProject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.InputStream;

public class URLSearchResults {
    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        for (JsonArray entry : revisionParser.FullListOfRevisions(inputStream)) {
            for(JsonElement user : entry) {
                System.out.println(user);
            }
        }
    }
}
