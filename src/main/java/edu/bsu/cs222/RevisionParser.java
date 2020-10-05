package edu.bsu.cs222;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class RevisionParser {
    ArrayList<Revisions> listOfRevisions = new ArrayList<>();
    public ArrayList<Revisions> FullListOfRevisions(InputStream inputStream) {
        //InputStream inputStream2 = inputStream;
        JsonElement rootElement = getRootElement(inputStream);
        tryRedirect(rootElement);

        try {
            JsonObject pages = createJsonParser(rootElement);
            //checkForRedirects(inputStream);
            JsonArray revisionArray = createJsonArray(pages);
            listOfRevisions = createListOfRevisions(revisionArray);
            return listOfRevisions;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Page was not found");
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    private JsonElement getRootElement(InputStream inputStream) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        return rootElement;
    }

    private JsonObject createJsonParser(JsonElement rootElement) {
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        return pages;
    }

    private JsonArray createJsonArray(JsonObject pages) {
        JsonArray revisionArray = null;
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionArray = entryObject.getAsJsonArray("revisions");
        }
        return revisionArray;
    }

    private ArrayList<Revisions> createListOfRevisions(JsonArray revisionArray) {
        for (JsonElement entry : revisionArray) {
            String user = entry.getAsJsonObject().get("user").getAsString();
            String timeStamp = entry.getAsJsonObject().get("timestamp").getAsString();
            Revisions revision = new Revisions(user, timeStamp);
            listOfRevisions.add(revision);
        }
        return listOfRevisions;
    }

    @SuppressWarnings("deprecation")
    private void checkForRedirects(JsonElement rootElement) {
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject();
        String from = redirects.get("from").getAsString();
        String to = redirects.get("to").getAsString();
        System.out.println("From: " + from + "\nTo: " + to + "\n");
    }

    private void tryRedirect(JsonElement rootElement) {
        try{
            checkForRedirects(rootElement);
        }catch(Exception f){
            System.out.println("here");
        }
    }
}
