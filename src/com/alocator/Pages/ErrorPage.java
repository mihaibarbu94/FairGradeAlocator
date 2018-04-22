package com.alocator.Pages;

public class ErrorPage extends Page {

    /**
     * Creates the Error Page object.
     * @param page The main menu page.
     */
    public ErrorPage(Page page) {
        createView();
        page.createView();
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    @Override
    void createView() {
        System.out.println("\nPlease choose a valid option!!!\n");
    }
}
