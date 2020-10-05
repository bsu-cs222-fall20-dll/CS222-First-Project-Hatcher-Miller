package edu.bsu.cs222;

import java.util.Scanner;

public class Menu {
    public String getUserInput() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your desired search term(s):");
        String userSearch = console.nextLine();
        return userSearch;
    }
}
