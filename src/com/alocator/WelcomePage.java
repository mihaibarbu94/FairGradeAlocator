package com.alocator;

import java.util.Scanner;

public class WelcomePage extends Page {

    public WelcomePage() {

    }

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
        String option = readOption();
        System.out.println();
        decideNextPage(option);
    }

    private String readOption() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        String option = scanner.next();

        return option;
    }

    private Page decideNextPage(String input) {
        switch (input) {
            case "A":
                return new AboutPage();
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
