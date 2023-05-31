package com.livefootball.scoreboard;

import java.util.ArrayList;
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
                .sorted((match1, match2) -> {
                    int score1 = match1.getHomeScore() + match1.getAwayScore();
                    int score2 = match2.getHomeScore() + match2.getAwayScore();
                    if (score1 == score2) {
                        return match2.getStartTime().compareTo(match1.getStartTime());
                    }
                    return score2 - score1;
                })
                .map(FootballMatch::toString)
                .toList();
    }

}
