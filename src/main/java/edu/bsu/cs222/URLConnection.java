package edu.bsu.cs222;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.net.URL;

public class URLConnection {
    public InputStream acquireConnectionToWikipedia(URL url, VBox parent) {
        try {
            java.net.URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (tmmiller3@bsu.edu)");
            return connection.getInputStream();
        }catch(Exception e) {
            HBox noWikipediaConnection = new HBox(new Label("Failed to connect to Wikipedia"));
            parent.getChildren().add(noWikipediaConnection);
        }
        return null;
    }

    public URL insertInputToURLConverter(String webSearch) throws Exception {
        String convert = webSearch.replaceAll(" ", "%20");
        return new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + convert + "&rvprop=timestamp|user&rvlimit=20&redirects");
    }
}
