package firstProject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

public class AuthorListParser {
    public ArrayList parseJSON(){
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;

        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }

        ArrayList<Author> authorList = new ArrayList<>();

        for (JsonElement author : array) {
            String user = author.getAsJsonObject().get("user").getAsString();
            String timestamp = author.getAsJsonObject().get("timestamp").getAsString();
            Author placeholder = new Author(user, timestamp);
            authorList.add(placeholder);
        }

        return authorList;
    }
}
