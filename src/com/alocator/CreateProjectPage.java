package com.alocator;

public class CreateProjectPage extends Page {

    public static final int MAX_MEMBERS = 5;
    public static final int MIN_MEMBERS = 3;
    public static final int MAX_NAME_LENGTH = 30;
    public static final int MIN_NAME_LENGTH  = 1;

    private Project project;
    private Page page;
    private String projectName;
    private int noOfTeamMembers;

    public CreateProjectPage(Page page) {
        this.page = page;
        createView();
    }

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

    private void askForNoOfTeamMembers() {
        enterNumberOfTeamMembers();

        try {
            noOfTeamMembers = Integer.parseInt(read());
        } catch(Exception e){
            handleNoOfTeamMembersError();
        }

        if (MIN_MEMBERS > noOfTeamMembers || noOfTeamMembers > MAX_MEMBERS) {
            handleNoOfTeamMembersError();
        }
    }

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

    private void handleNoOfTeamMembersError() {
        System.out.println("Project can have between 3 and 5 members, try again");
        askForNoOfTeamMembers();
    }

    private void enterProjectName() {
        System.out.print("Enter the project name: ");
    }

    private void enterNumberOfTeamMembers() {
        System.out.print("Enter the number of team members: ");
    }

    private void enterTeamMemberNames(int numberOfMembers) {
        for(int i = 1; i <= numberOfMembers; ++i) {
//            System.out.print("\tEnter the name of team member " + i + ": ");
            askForMembersName(i);
//            String name = read();
//            project.addMember(name);
        }
    }
}
