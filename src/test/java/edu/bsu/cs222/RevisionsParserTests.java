package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

public class RevisionsParserTests {
    @Test
    @SuppressWarnings("deprecation")
    public void RevisionsParserTest() throws IOException {
        URL wiki = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=20&redirects");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (tmmiller3@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        connection.connect();
        JsonParser parser = new JsonParser();
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisionArray = null;
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionArray = entryObject.getAsJsonArray("revisions");
        }
        ArrayList<Revisions> listOfRevisions = new ArrayList<>();
        assert revisionArray != null;
        for (JsonElement entry : revisionArray) {
            String user = entry.getAsJsonObject().get("user").getAsString();
            String timeStamp = entry.getAsJsonObject().get("timestamp").getAsString();
            Revisions revision = new Revisions(user, timeStamp);
            listOfRevisions.add(revision);
        }
        for (Revisions entry : listOfRevisions) {
            System.out.println("User: " + entry.getUser() + "     TimeStamp: " + entry.getTimeStamp());
        }
    }
}
