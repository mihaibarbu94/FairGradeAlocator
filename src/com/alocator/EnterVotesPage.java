package com.alocator;

import java.util.ArrayList;

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

        returnToMainMenu(page);

    }

    private void voteForRemainingMembers(ArrayList<String> teamMembers,
                                         String member ){
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

    private void getCreatedProject(String projectName){
        project = ProjectList.projects.get(projectName);

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
}
