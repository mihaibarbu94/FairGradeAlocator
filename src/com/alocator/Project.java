package com.alocator;

import java.util.ArrayList;

public class Project {

    private ArrayList<String> members;
    private String projectName;
    private int noOfMembers;
    private ArrayList<Vote> votes = new ArrayList<>();

    public Project(String projectName, int noOfMembers){
        this.projectName = projectName;
        this.noOfMembers = noOfMembers;
        members = new ArrayList<>();
    }

    public Project(String projectName,
                   int noOfMembers,
                   ArrayList<String> members){
        this.projectName = projectName;
        this.noOfMembers = noOfMembers;
        this.members     = members;
    }

    public void addMember(String name) {
        members.add(name);
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getNoOfMembers() {
        return noOfMembers;
    }

    public void addVoteToProject(Vote vote) {
        votes.add(vote);
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }
}

