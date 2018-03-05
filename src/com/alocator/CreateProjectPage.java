package com.alocator;

import java.util.Scanner;

public class CreateProjectPage extends Page {

    private Project project;
    private Page page;

    public CreateProjectPage(Page page) {
        this.page = page;
        createView();
    }

    @Override
    void createView() {
        enterProjectName();
        String projectName = read();

        enterNumberOfTeamMembers();
        int noOfTeamMembers = Integer.parseInt(read());

        System.out.println();

        project = new Project(projectName, noOfTeamMembers);

        enterTeamMemberNames(noOfTeamMembers);

        Projects.projects.put(projectName, project);

        System.out.println();

        returnToMainMenu();
    }

    private void returnToMainMenu() {
        System.out.print("Press any key to return to the main menu: ");
        read();
        page.createView();
    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    private void enterNumberOfTeamMembers() {
        System.out.print("Enter the number of team members: ");
    }

    private void enterTeamMemberNames(int numberOfMembers) {
        for(int i = 1; i <= numberOfMembers; ++i) {
            System.out.print("\tEnter the name of team member " + i + ": ");
            String name = read();
            project.addMember(name);
        }
    }

    private String read() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        return scanner.next();
    }
}
