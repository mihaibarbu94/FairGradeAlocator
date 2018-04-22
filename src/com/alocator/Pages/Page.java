package com.alocator.Pages;

import java.util.Scanner;

public abstract class Page {

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    abstract void createView();

    /**
     * Reads a String from the command-line input.
     * @return the String that was read.
     */
    String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * Returns to main menu.
     * @param page The main menu page.
     */
    void returnToMainMenu(Page page) {
        System.out.print("Press any key followed by <Enter> to " +
                         "return to the main menu:");
        read();
        page.createView();
    }
}
