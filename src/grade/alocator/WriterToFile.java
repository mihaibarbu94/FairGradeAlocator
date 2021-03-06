package grade.alocator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriterToFile {

    /**
     * Store data to a text file.
     */
    public static void storeDataToTextFile() {
        ArrayList<Project> projects = new ArrayList<>(ProjectList.projects.values());

        PrintWriter outputStream;
        try {
            outputStream = new PrintWriter(new FileOutputStream("store.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Error opening, creating or writing to the " +
                    "file store.txt");
            return;
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

            int votesNumber = votes.size();
            int vote1Iterator = 1;
            for (Vote vote : votes) {
                String voter = vote.getVoter();
                outputStream.print(voter + ",");
                int size = vote.getVotes().size();
                int vote2Iterator = 1;
                for (String key : vote.getVotes().keySet()) {
                    //print key e.g. Asim
                    outputStream.print(key + ",");
                    //print vote e.g 50
                    boolean isCommaNeeded = checkIfComaNeeded(votesNumber,
                            vote1Iterator, size,
                            vote2Iterator);
                    outputStream.print(vote.getVotes().get(key) +
                            (isCommaNeeded ? "," : ""));
                    vote2Iterator++;
                }
                vote1Iterator++;
            }
            outputStream.println();
        }

        outputStream.close();
    }

    private static boolean checkIfComaNeeded(int votesNumber, int vote1Iterator,
                                      int size, int vote2Iterator){
        return !(vote1Iterator == votesNumber && size == vote2Iterator);
    }
}
