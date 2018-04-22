package grade.alocator.pages;

import grade.alocator.GradeAllocator;
import grade.alocator.Project;
import grade.alocator.ProjectList;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShowProjectPage extends Page {

    private Page page;
    private String projectName;
    private Project project;
    private ArrayList<Double> shareOfScores = new ArrayList<>();

    /**
     * Creates the Show Project Page object.
     * @param page The main menu page.
     */
    public ShowProjectPage(Page page) {
        this.page = page;
        createView();
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    @Override
    void createView() {
        askForProject();
        displayNoOfTeamMembers();
        displayResultsBasedOnVotes();
        System.out.println();
        returnToMainMenu(page);
    }

    /**
     * Asks the user for a project to search. If no projects are available
     * the user is taken to main menu.
     */
    private void askForProject() {
        if (ProjectList.projects.isEmpty()) {
            System.out.println("There are not projects available! Taking you " +
                    "back to main menu!");
            returnToMainMenu(page);
        }
        enterProjectName();
        projectName = page.read();
        System.out.println();

        project =  ProjectList.projects.get(projectName);
        if (project == null) {
            System.out.println("ERROR: This project does not exist!");
            askForProject();
        }
    }

    /**
     * Displays the results based on the votes. If the votes do not add up to
     * 1 a message will be prompted to announce this.
     */
    private void displayResultsBasedOnVotes() {
        System.out.println("The point allocation based on votes is:");
        System.out.println();

        GradeAllocator allocator = new GradeAllocator(project);
        shareOfScores = allocator.calculateShareOfScore();
        if (shareOfScores.isEmpty()){
            System.out.println("Error showing up the scores!");
            return;
        }
        ArrayList<String> members = project.getMembers();

        int memberIndex = 0;
        DecimalFormat df  = new DecimalFormat("0.00");
        double totalScore = 0;
        for(String member : members){
            totalScore += shareOfScores.get(memberIndex);
            System.out.println(member + ": " +
                               df.format(shareOfScores.get(memberIndex++)));
        }

        if (totalScore != 1) {
            System.out.println("The scores do not add up to 1! They add " +
                    "up to: " + totalScore + " There is a big" +
                    " discrepancy in the votes!");
        }
    }

    /**
     * Displays the number of team members.
     */
    private void displayNoOfTeamMembers() {
        int noOfTeamMembers = project.getNoOfMembers();
        System.out.println("There are " + noOfTeamMembers + " team members.");
        System.out.println();
    }

    /**
     * Asks the user to enter the project name.
     */
    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }
}
