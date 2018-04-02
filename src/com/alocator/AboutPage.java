package com.alocator;

public class AboutPage extends Page {

    private Page page;

    public AboutPage(Page page) {
        this.page = page;
        createView();
        returnToMainMenu(page);
    }

    void createView() {
        //TODO
        System.out.println("About Page");
    }
}
