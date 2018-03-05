package com.alocator;

import java.util.HashMap;

public class Vote {

    private String voter;
    private HashMap<String, Integer> votes = new HashMap<>();

    public Vote(String voter){
        this.voter = voter;
    }

    public void addVote(String voted, int vote) {
        votes.put(voted, vote);
    }

    public void deleteVotes() {
        votes.clear();
    }

    public String getVoter() {
        return voter;
    }

    public HashMap<String, Integer> getVotes() {
        return votes;
    }
}
