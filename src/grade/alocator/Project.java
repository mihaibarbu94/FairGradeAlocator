package grade.alocator;

import java.util.ArrayList;

public class Project {

    private ArrayList<String> members;
    private String projectName;
    private int noOfMembers;
    private ArrayList<Vote> votes = new ArrayList<>();

    /** Creates a project with the specified name, number of participants.
     * @param projectName The project name.
     * @param noOfMembers The number of people in a team
     */
    public Project(String projectName, int noOfMembers){
        this.projectName = projectName;
        this.noOfMembers = noOfMembers;
        members          = new ArrayList<>();
    }

    /** Creates a project with the specified name, number of participants and
     *  team members.
     * @param projectName The project name.
     * @param noOfMembers The number of people in a team
     * @param members The names of team members.
     */
    public Project(String projectName,
                   int noOfMembers,
                   ArrayList<String> members){
        this.projectName = projectName;
        this.noOfMembers = noOfMembers;
        this.members     = members;
    }

    /**
     * Adds a member to the project.
     * @param name The name of the member.
     */
    public void addMember(String name) {
        members.add(name);
    }

    /**
     * Gets the members from the project.
     * @return The members from the project.
     */
    public ArrayList<String> getMembers() {
        return members;
    }

    /**
     * Gets the name of the project.
     * @return The name of the project.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Gets the number of team members.
     * @return The number of team members.
     */
    public int getNoOfMembers() {
        return noOfMembers;
    }

    /**
     * Adds a vote to the project.
     * @param vote The vote to be added to the project.
     */
    public void addVoteToProject(Vote vote) {
        votes.add(vote);
    }

    /**
     * Gets the votes.
     * @return The list of votes.
     */
    public ArrayList<Vote> getVotes() {
        return votes;
    }
}

