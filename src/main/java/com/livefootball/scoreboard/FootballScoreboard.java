package com.livefootball.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FootballScoreboard {

    private final List<FootballMatch> matches;

    public FootballScoreboard() {
        this.matches = new ArrayList<>();
    }

    public void startMatch(String homeTeam, String awayTeam) {
        FootballMatch match = new FootballMatch(homeTeam, awayTeam);
        matches.add(match);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        matches.stream()
                .filter(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(match -> match.updateScore(homeScore, awayScore));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.stream()
                .filter(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(match -> match.setStatus(MatchStatus.FINISHED));
    }

    public List<String> getMatchesInProgressSummary() {
        return matches.stream()
                .filter(match -> match.getStatus() == MatchStatus.IN_PROGRESS)
                .sorted(Comparator.comparingInt(FootballMatch::getTotalScore)
                        .reversed()
                        .thenComparing(FootballMatch::getStartTime, Comparator.reverseOrder()))
                .map(FootballMatch::toString)
                .toList();
    }

}
