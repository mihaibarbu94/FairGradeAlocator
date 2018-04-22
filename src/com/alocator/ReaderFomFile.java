package com.alocator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderFomFile {

    /**
     * Reads the project name, number of team members ,the team members and
     * their respective votes from a store.txt file.
     * If the file does not exists it does nothing.
     */
    static void readDataFromFile() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("store.txt"));
        } catch(FileNotFoundException e) {
            return;
        }

        // we want to match exactly one newline or comma at a time
        scanner.useDelimiter(",|\r?\n|\r");
        while(scanner.hasNext()){
            String projectName = scanner.next();
            int noOfMembers;

            try {
                noOfMembers = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Error reading file!");
                return;
            }

            ArrayList<String> members = new ArrayList<>();
            for (int i = 0; i < noOfMembers; i++) {
                members.add(scanner.next());
            }

            Project project = new Project(projectName, noOfMembers, members);

            for (int i = 0; i < noOfMembers; i++) {
                String voter = scanner.next();
                Vote vote = new Vote(voter);
                for (int n = 0; n < noOfMembers - 1; n++) {
                    String voted = scanner.next();
                    int voteScore;
                    try {
                        voteScore = Integer.parseInt(scanner.next());
                    } catch (Exception e) {
                        System.out.println("Error reading file!");
                        return;
                    }
                    vote.addVote(voted, voteScore);
                }
                project.addVoteToProject(vote);
            }
            ProjectList.projects.put(projectName, project);

        }
        scanner.close();
    }
}
