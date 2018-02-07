package com.alocator;

public class ErrorPage extends Page {

    public ErrorPage(Page page) {
        createView();
        page.createView();
    }

    @Override
    void createView() {
        System.out.println("\nPlease choose a valid option!!!\n");
    }
}
