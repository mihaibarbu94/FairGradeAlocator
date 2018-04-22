package com.alocator.Pages;

import com.alocator.Project;
import com.alocator.ProjectList;

public class CreateProjectPage extends Page {

    public static final int NO_MEMBERS = 3;
    public static final int MAX_NAME_LENGTH = 30;
    public static final int MIN_NAME_LENGTH  = 1;

    private Project project;
    private Page page;
    private String projectName;
    private int noOfTeamMembers;

    /**
     * Creates the Create Project Page object.
     * @param page The main menu page.
     */
    public CreateProjectPage(Page page) {
        this.page = page;
        createView();
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
    @Override
    void createView() {
        askForProjectName();
        askForNoOfTeamMembers();

        System.out.println();

        project = new Project(projectName, noOfTeamMembers);
        enterTeamMemberNames(noOfTeamMembers);
        ProjectList.projects.put(projectName, project);

        System.out.println();

        returnToMainMenu(page);
    }

    /**
     * Asks for the name of the project which must be formed by  alphanumeric
     * characters and be between 1 and 30 characters. It will ask for a good
     * name until it is provided.
     */
    private void askForProjectName() {
        enterProjectName();
        projectName = read();
        int nameLength = projectName.length();
        //https://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric/11243952
        if (MIN_NAME_LENGTH > nameLength || nameLength > MAX_NAME_LENGTH ||
            !projectName.matches("^[a-zA-Z0-9]*$")) {
            System.out.println("A name must contain only alphanumeric " +
                    "characters and be between 1 and 30 characters, try again");
            askForProjectName();
        }
    }

    /**
     * Asks for the number of team members for a project and accepts only if
     * the number number provided is NO_MEMBERS. It will ask the user until the
     * condition is met.
     */
    private void askForNoOfTeamMembers() {
        enterNumberOfTeamMembers();

        try {
            noOfTeamMembers = Integer.parseInt(read());
        } catch(Exception e){
            handleNoOfTeamMembersError();
        }

        if (NO_MEMBERS != noOfTeamMembers) {
            handleNoOfTeamMembersError();
        }
    }

    /**
     * Asks for the name of the the participants from the project which must be
     * formed by  alphanumeric characters and be between 1 and 30 characters.
     * It will ask for a good name until it is provided.
     */
    private void askForMembersName(int i) {
        System.out.print("\tEnter the name of team member " + i + ": ");
        String name = read();

        int nameLength = name.length();
        //https://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric/11243952
        if (MIN_NAME_LENGTH > nameLength || nameLength > MAX_NAME_LENGTH ||
                !name.matches("^[a-zA-Z0-9]*$")) {
            System.out.println("A name must contain only alphanumeric " +
                    "characters and be between 1 and 30 characters, try again");
            askForMembersName(i);
        }

        project.addMember(name);
    }

    /**
     * Handles the case when the users inserts a number different then
     * NO_MEMBERS and displays a message to introduce the correct number and
     * asks for the number of team members.
     */
    private void handleNoOfTeamMembersError() {
        System.out.println("Project can have 3 members, try again");
        askForNoOfTeamMembers();
    }

    /**
     * Asks the user to insert the project name.
     */
    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    /**
     * Asks the user to insert the number of team members.
     */
    private void enterNumberOfTeamMembers() {
        System.out.print("Enter the number of team members: ");
    }

    /**
     * Asks the user to introduce the names od the team members
     * numberOfMembers times.
     * @param numberOfMembers The number of team members.
     */
    private void enterTeamMemberNames(int numberOfMembers) {
        for(int i = 1; i <= numberOfMembers; ++i) {
            askForMembersName(i);
        }
    }
}
