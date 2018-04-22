package grade.alocator;

import java.util.ArrayList;
import java.util.HashMap;

public class GradeAllocator {

    Project project;
    private ArrayList<String> participants  = new ArrayList<>();
    private ArrayList<Vote> votes           = new ArrayList<>();
    private HashMap<String, Double> scores  = new HashMap<>();
    private ArrayList<Double> shareOfScores = new ArrayList<>();

    /**
     * Creates the Grade Allocator object.
     * @param project The project for each the grades are calculated.
     */
    public GradeAllocator(Project project){
        this.project = project;
        participants = project.getMembers();
        votes        = project.getVotes();
    }

    /**
     * Calculates the share of scores by a given formula which works only if
     * the number of team members is 3.
     * @return A list of the share of scores.
     */
    public ArrayList<Double> calculateShareOfScore() {
        if (votes.isEmpty() || participants.isEmpty()){
            System.out.println("Not enough info to calculate the shares!");
            return shareOfScores;
        }

        String participant1 = participants.get(0);
        String participant2 = participants.get(1);
        String participant3 = participants.get(2);

        Vote vote;
        double vote1;
        double vote2;
        double r1;
        double r2;

        //votes of the first participant
        vote  = votes.get(0);
        vote1 = vote.getVotes().get(participant2);
        vote2 = vote.getVotes().get(participant3);
        r1 = vote1/vote2;
        r2 = vote2/vote1;
        scores.put("r123", r1);
        scores.put("r132", r2);

        //votes of the second participant
        vote  = votes.get(1);
        vote1 = vote.getVotes().get(participant1);
        vote2 = vote.getVotes().get(participant3);
        r1 = vote1/vote2;
        r2 = vote2/vote1;
        scores.put("r213", r1);
        scores.put("r231", r2);

        //votes of the third participant
        vote  = votes.get(2);
        vote1 = vote.getVotes().get(participant1);
        vote2 = vote.getVotes().get(participant2);
        r1 = vote1/vote2;
        r2 = vote2/vote1;
        scores.put("r312", r1);
        scores.put("r321", r2);

        shareOfScores.add(1/(1 + scores.get("r321") + scores.get("r231")));
        shareOfScores.add(1/(1 + scores.get("r132") + scores.get("r312")));
        shareOfScores.add(1/(1 + scores.get("r123") + scores.get("r213")));

        return shareOfScores;
    }
}
