package com.alocator;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterVotesPage extends Page {
    Project project;
    Page page;

    public EnterVotesPage(Page page) {
        this.page = page;
        createView();
    }

    @Override
    void createView() {
        askForProjectName();
        displayNumberOfTeamMembers();
        ArrayList<String> teamMembers = project.getMembers();

        for (String member : teamMembers) {
            System.out.println();
            System.out.println("Enter " + member + "'s votes, points must add" +
                    " up to 100:");
            System.out.println();

            voteForRemainingMembers(teamMembers, member);
        }

        System.out.println();

        returnToMainMenu();

    }

    private void voteForRemainingMembers(ArrayList<String> teamMembers, String member ){
        int totalVotes = 100;
        Vote vote = new Vote(member);
        for (String remainingMember : teamMembers) {
            if (remainingMember == member) {
                continue;
            }
            System.out.print("\tEnter " + member + "'s points for " +
                    remainingMember + ": " );

            int mark = Integer.parseInt(read());
            totalVotes -= mark;
            vote.addVote(remainingMember, mark);
        }
        if (totalVotes != 0) {
            vote.deleteVotes();
            System.out.println("ERROR: All votes should add up to 100!");
            voteForRemainingMembers(teamMembers, member);
        }
        project.addVoteToProject(vote);
    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    private void displayNumberOfTeamMembers() {
        System.out.println("There are " + project.getNoOfMembers() + " team " +
                "members.");
    }

    private String read() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        // get their input as a String
        return scanner.next();
    }

    private void getCreatedProject(String projectName){
        project = Projects.projects.get(projectName);

        if (project == null) {
            System.out.println("ERROR: This project does not exist! \n");
            askForProjectName();
        }
    }

    private void askForProjectName(){
        enterProjectName();
        String projectName = read();
        getCreatedProject(projectName);
    }

    private void returnToMainMenu() {
        System.out.print("Press any key to return to the main menu: ");
        read();
        page.createView();
    }
}
