package com.alocator.Pages;

import com.alocator.Project;
import com.alocator.ProjectList;
import com.alocator.Vote;

import java.util.ArrayList;

public class EnterVotesPage extends Page {
    private Project project;
    private Page page;

    /**
     * Creates the Enter Votes Page object.
     * @param page The main menu page.
     */
    public EnterVotesPage(Page page) {
        this.page = page;
        createView();
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     */
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

    /**
     * The 'member' of the project votes for the remaining 'teamMembers'.
     * If the total votes is less than 100 the user is asked again to eneter
     * the votes.
     * @param teamMembers The list of team members.
     * @param member The members who votes.
     */
    private void voteForRemainingMembers(ArrayList<String> teamMembers,
                                         String member ){
        int totalVotes = 100;
        Vote vote = new Vote(member);
        for (String remainingMember : teamMembers) {
            if (remainingMember.equals(member)) {
                continue;
            }
            System.out.print("\tEnter " + member + "'s points for " +
                    remainingMember + ": " );

            int mark = askForMark();

            //int mark = Integer.parseInt(read());
            totalVotes -= mark;
            vote.addVote(remainingMember, mark);
        }

        if (totalVotes != 0) {
            vote.deleteVotes();
            System.out.println("ERROR: All votes should add up to 100! They " +
                    "add up to " + (100 - totalVotes));
            voteForRemainingMembers(teamMembers, member);
        }

        project.addVoteToProject(vote);
    }

    /**
     * Asks for a mark for a team member.
     * @return return the mark
     */
    private int askForMark() {
        int mark;

        try {
            mark = Integer.parseInt(read());
        } catch(Exception e){
            mark = handleParseError();
        }

        return mark;
    }

    /**
     * Handles case when user enter a wrong value for the mark and ask the
     * user to enter the mark again.
     * @return The mark of the vote.
     */
    private int handleParseError() {
        System.out.print("Reenter points for this member: ");
        return askForMark();
    }

    /**
     * Asks the user to insert the project name.
     */
    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    /**
     * Displays the number of team members of the project.
     */
    private void displayNumberOfTeamMembers() {
        System.out.println("There are " + project.getNoOfMembers() + " team " +
                "members.");
    }

    /**
     * Gets a previously created project from the project list.
     * @param projectName The name of the project.
     */
    private void getCreatedProject(String projectName){
        project = ProjectList.projects.get(projectName);

        if (project == null) {
            System.out.println("ERROR: This project does not exist! \n");
            askForProjectName();
        }
    }

    /**
     * Asks the user to insert the name of the project.
     */
    private void askForProjectName(){
        enterProjectName();
        String projectName = read();
        getCreatedProject(projectName);
    }
}
