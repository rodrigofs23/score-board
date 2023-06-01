package com.livefootball.scoreboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatch {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private LocalDateTime startTime;
    private MatchStatus status;

    public FootballMatch(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = LocalDateTime.now();
        this.status = MatchStatus.IN_PROGRESS;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public String toString() {
        return String.format("%s %d - %d %s", homeTeam, homeScore, awayScore, awayTeam);
    }

}
