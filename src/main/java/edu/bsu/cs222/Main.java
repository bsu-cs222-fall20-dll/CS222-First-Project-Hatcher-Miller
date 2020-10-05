package edu.bsu.cs222;

import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URLConnection urlConnection = new URLConnection();
        Menu menu = new Menu();
        URLSearchResults urlSearchResults = new URLSearchResults();
        String userInput = menu.getUserInput();
        URL url = urlConnection.insertInputToURLConverter(userInput);
        urlSearchResults.RevisionList(urlConnection.acquireConnectionToWikipedia(url));
    }
}
