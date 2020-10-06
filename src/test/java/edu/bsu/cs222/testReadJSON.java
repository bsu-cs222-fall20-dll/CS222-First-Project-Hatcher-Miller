package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class testReadJSON {

    @SuppressWarnings("deprecation")
    @Test
    public void testJSON(){
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        assert inputStream != null;
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;
        for(Map.Entry<String,JsonElement> entry: pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        assert array != null;
        System.out.println(array.get(0).getAsJsonObject().get("user").getAsString());
        Assertions.assertEquals(4, array.size());
    }
    @SuppressWarnings("deprecation")
    @Test
    public void testCountRedirects() {
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        assert inputStream != null;
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
        JsonObject holder = redirects.get(redirects.size() - 1).getAsJsonObject();
        String user = holder.get("to").getAsString();
        Assertions.assertEquals("Frank Zappa", user);
    }
}