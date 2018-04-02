package com.alocator;

public class WelcomePage extends Page {

    @Override
    void createView() {
        System.out.println("Welcome to Split-it");
        System.out.println();

        System.out.println("\tAbout (A)");
        System.out.println("\tCreate Project (C)");
        System.out.println("\tEnter Votes (V)");
        System.out.println("\tShow Project (S)");
        System.out.println("\tQuit (Q)");

        System.out.println();
        System.out.print("\tPlease Choose an option: ");

        process();
    }

    private void process(){
        String option = read();
        System.out.println();
        decideNextPage(option);
    }

    private Page decideNextPage(String input) {
        switch (input) {
            case "A":
                return new AboutPage(this);
            case "C":
                return new CreateProjectPage(this);
            case "V":
                return new EnterVotesPage(this);
            case "S":
                return new ShowProjectPage(this);
            case "Q":
                return new QuitPage();
            default :
                return new ErrorPage(this);
        }
    }
}
