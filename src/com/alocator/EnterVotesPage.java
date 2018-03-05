package com.alocator;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterVotesPage extends Page {
    Project project;

    public EnterVotesPage(Page page) {
        page.createView();
    }

    @Override
    void createView() {
        enterProjectName();
        String projectName = read();
        getProject(projectName);

        displayNumberOfTeamMembers();
        ArrayList<String> teamMembers = project.getMembers();

        for (String member : teamMembers) {
            System.out.println("Enter " + member + "'s votes, points must add" +
                    " up to 100:");
            int totalVotes = 100;
            for (String remainingMember : teamMembers) {
                if (remainingMember == member) {
                    continue;
                }
                System.out.println("Enter " + member + "'s points for " +
                        remainingMember + ":" );

                int vote = Integer.parseInt(read());
                totalVotes -= vote;
            }
            if (totalVotes != 0) {
                System.out.println("ERROR: All votes should add up to 100!");
            } else {

            }
        }


    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    private void displayNumberOfTeamMembers() {
        System.out.print("There are " + project.getNoOfMembers() + " team members.");
    }

    private String read() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        return scanner.next();
    }

    private void getProject(String projectName){
        project = Projects.projects.get(projectName);
    }
}
