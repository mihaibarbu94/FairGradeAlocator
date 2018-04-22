package grade.alocator;

import grade.alocator.pages.WelcomePage;

public class Main {

    public static void main(String[] args) {
        ReaderFomFile.readDataFromFile();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.createView();
    }
}
