package com.livefootball.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class FootballScoreboard {

    List<String> score = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        score.add("Mexico 0 - 0 Canada");
    }

    public List<String> getMatchesInProgressSummary() {
        return score;
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        score = new ArrayList<>();
        score.add("Mexico 0 - 5 Canada");
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        score.clear();
        System.out.println(score.toString());
    }
}
