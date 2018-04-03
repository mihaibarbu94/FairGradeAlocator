package com.alocator;

import java.util.Scanner;

public abstract class Page {

    abstract void createView();

    protected String read() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        return scanner.next();
    }

    protected void returnToMainMenu(Page page) {
        System.out.print("Press any key followed by <Enter> to " +
                         "return to the main menu:");
        read();
        page.createView();
    }
}
