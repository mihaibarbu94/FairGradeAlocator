package com.alocator;

import java.util.ArrayList;

public class Project {
    private ArrayList<String> members;
    private String projectName;
    private int noOfMembers;

    public Project(String projectName, int noOfMembers){
        this.projectName = projectName;
        this.noOfMembers = noOfMembers;
        members = new ArrayList<String>();
    }

    public void addMember(String name) {
        members.add(name);
    }
}

