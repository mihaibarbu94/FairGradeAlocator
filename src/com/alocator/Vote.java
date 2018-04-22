package com.alocator;

import java.util.HashMap;

public class Vote {

    private String voter;
    private HashMap<String, Integer> votes = new HashMap<>();

    /**
     * Creates the Vote object.
     * @param voter The voter who votes for the rest in the team.
     */
    public Vote(String voter){
        this.voter = voter;
    }

    /**
     * Adds a vote to a member (voted) with a score (vote)
     * @param voted The person who receives the vote.
     * @param vote The number which represents the vote.
     */
    public void addVote(String voted, int vote) {
        votes.put(voted, vote);
    }

    /**
     * Deletes all the votes.
     */
    public void deleteVotes() {
        votes.clear();
    }

    /**
     * Gets the voter (the person who voted for the other team members).
     * @return The voter.
     */
    public String getVoter() {
        return voter;
    }

    /**
     * Gets the votes list.
     * @return The list of votes.
     */
    public HashMap<String, Integer> getVotes() {
        return votes;
    }
}
