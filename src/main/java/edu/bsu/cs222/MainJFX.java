package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class MainJFX extends Application {
    URLConnection urlConnection = new URLConnection();
    RevisionParser revisionParser = new RevisionParser();
    VBox parent = new VBox();
    TextField textField = new TextField();
    ComboBox<String> revisionSelector = new ComboBox<>();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        parent.getChildren().add(new Label("Please enter your search term(s)"));

        createSearchBox();

        Button searchButton = new Button("Search");
        searchWikipedia(searchButton);
        parent.getChildren().add(searchButton);

        primaryStage.setScene(new Scene(parent, 450, 650));
        primaryStage.show();
    }

