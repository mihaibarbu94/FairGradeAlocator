package com.alocator;

import com.alocator.Pages.WelcomePage;

public class Main {

    public static void main(String[] args) {
        ReaderFomFile.readDataFromFile();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.createView();
    }
}
