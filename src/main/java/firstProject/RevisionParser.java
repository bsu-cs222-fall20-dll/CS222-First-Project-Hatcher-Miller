package firstProject;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

public class RevisionParser {
    @SuppressWarnings("deprecation")
    public ArrayList<JsonArray> FullListOfRevisions(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        ArrayList<JsonArray> ListOfRevisions = new ArrayList<>();
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            ListOfRevisions.add(entryObject.getAsJsonArray("revisions"));
        }
        return ListOfRevisions;
    }
}
