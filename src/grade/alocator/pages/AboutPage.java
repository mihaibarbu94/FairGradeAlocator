package grade.alocator.pages;

/**
 * The type About page.
 */
public class AboutPage extends Page {

    /**
     * Creates the About Page object.
     *
     * @param page The main menu page.
     */
    public AboutPage(Page page) {
        createView();
        returnToMainMenu(page);
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    @Override
    void createView() {
        System.out.println("\t Split-it is an easy-to-use tool that fairly allocates credit");
        System.out.println("\t for a project among members of a team.By taking into account");
        System.out.println("\t each member's votes for everyone in the team, the application");
        System.out.println("\t determines the contribution of each person, so that all parties");
        System.out.println("\t agree with the final result.");
        System.out.println("\t The process starts by introducing all the names of the ");
        System.out.println("\t participants to the project and their votes for each of ");
        System.out.println("\t their colleagues, including themselves. Split-it then comes ");
        System.out.println("\t up with the point allocation based on the votes provided, ");
        System.out.println("\t completely impartial and fair. ");
        System.out.println();
    }
}