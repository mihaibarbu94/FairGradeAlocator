package com.alocator.Pages;

import com.alocator.GradeAllocator;
import com.alocator.Project;
import com.alocator.ProjectList;

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

    private void askForProject() {
        enterProjectName();
        projectName = page.read();
        System.out.println();

        project =  ProjectList.projects.get(projectName);
        if (project == null) {
            System.out.println("ERROR: This project does not exist!");
            askForProject();
        }
    }

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
        for(String member : members){
            System.out.println(member + ": " +
                               df.format(shareOfScores.get(memberIndex++)));
        }
    }

    private void displayNoOfTeamMembers() {
        int noOfTeamMembers = project.getNoOfMembers();
        System.out.println("There are " + noOfTeamMembers + " team members.");
        System.out.println();
    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }
}
