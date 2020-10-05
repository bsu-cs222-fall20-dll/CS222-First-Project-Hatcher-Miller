package edu.bsu.cs222;

import java.io.InputStream;
import java.net.URL;

public class URLConnection {
    public InputStream acquireConnectionToWikipedia(URL url) {
        try {
            java.net.URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (tmmiller3@bsu.edu)");
            return connection.getInputStream();
        }catch(Exception e) {
            System.out.println("The search you have chosen does not exist. Please try again.");
        }
        return null;
    }

    public URL insertInputToURLConverter(String webSearch) throws Exception {
        String convert = webSearch.replaceAll(" ", "%20");
        System.out.println(convert);
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + convert + "&rvprop=timestamp|user&rvlimit=20&redirects");
        return url;
    }
}
