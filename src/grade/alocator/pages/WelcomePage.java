package grade.alocator.pages;

public class WelcomePage extends Page {

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    @Override
    public void createView() {
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

    /**
     * Process the option given and decides next page.
     */
    private void process(){
        String option = read();
        System.out.println();
        decideNextPage(option);
    }

    /**
     * Decides the next page in the control flow of the program.
     * @param input The choice of the user.
     * @return The page that the user wishes to access.
     */
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
