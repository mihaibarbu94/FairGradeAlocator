package com.alocator;

public class ShowProjectPage extends Page {

    Page page;
    String projectName;
    Project project;

    public ShowProjectPage(Page page) {
        this.page = page;
        createView();
    }

    @Override
    void createView() {

        askForProject();
        findProject();

        displayNoOfTeamMembers();
        displayResultsBasedOnVotes();

        System.out.println();

        returnToMainMenu(page);
    }

    private void askForProject() {
        enterProjectName();
        projectName = page.read();
        System.out.println();
    }

    private void displayResultsBasedOnVotes() {
        System.out.println("The point allocation based on votes is:");
        System.out.println();
    }

    private void displayNoOfTeamMembers() {
        int noOfTeamMembers = project.getNoOfMembers();
        System.out.println("There are " + noOfTeamMembers + " team members.");
        System.out.println();
    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    private void findProject() {
        project =  ProjectList.projects.get(projectName);
        if (project == null) {
            System.out.println("ERROROROROROROR");
        }
    }
}
