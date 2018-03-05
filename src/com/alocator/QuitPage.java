package com.alocator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuitPage extends Page {

    public QuitPage() {
        storeDataIntoTextFile();
        System.exit(0);
    }

    @Override
    void createView() {}

    private void storeDataIntoTextFile(){
        ArrayList<Project> projects = new ArrayList<>(Projects.projects.values());

        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream("store.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening or creating the file store.txt.");
        }


        for (Project project : projects){
            String projectName = project.getProjectName();
            outputStream.print(projectName + ",");

            int noOfMembers = project.getNoOfMembers();
            outputStream.print(noOfMembers + ",");

            ArrayList<String> members = project.getMembers();
            for (String member : members) {
                outputStream.print(member + ",");
            }

            ArrayList<Vote> votes = project.getVotes();

            for (Vote vote : votes) {
                String voter = vote.getVoter();
                outputStream.print(voter + ",");
                for (String key : vote.getVotes().keySet()) {
                    //print key e.g. Asim
                    outputStream.print(key + ",");
                    //print vote e.g 50
                    outputStream.print(vote.getVotes().get(key) + ",");
                }
            }
            outputStream.println();
        }

        outputStream.close();
    }
}
