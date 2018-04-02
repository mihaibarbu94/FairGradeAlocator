package com.alocator;

import java.util.Scanner;

public abstract class Page {

    abstract void createView();

    String read() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        return scanner.next();
    }

    void returnToMainMenu(Page page) {
        System.out.print("Press any key to return to the main menu: ");
        read();
        page.createView();
    }
}
