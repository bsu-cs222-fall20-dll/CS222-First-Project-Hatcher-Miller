package edu.bsu.cs222;

import java.io.InputStream;
import java.util.ArrayList;

public class URLSearchResults {
    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        ArrayList<Revisions> listOfRevisions = revisionParser.FullListOfRevisions(inputStream);
        if (listOfRevisions != null) {
            for (Revisions entry : listOfRevisions) {
                System.out.println("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp());
            }
        }
    }
}