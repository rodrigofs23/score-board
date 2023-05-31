package com.livefootball.scoreboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballScoreboardTest {

    FootballScoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new FootballScoreboard();
    }

    @Test
    void givenAMatch_shouldGetSummaryOfTheMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals("Mexico 0 - 0 Canada", summary.get(0));
    }

    @Test
    void givenANewScore_shouldUpdateTheSummary() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals("Mexico 0 - 5 Canada", summary.get(0));
    }

    @Test
    void givenTheMatch_shouldFinishAndRemoveMatch() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.finishMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals(0, summary.size());
    }

    @Test
    void givenSomeMatches_shouldReturnTheSummarySorted() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.startMatch("Germany", "France");
        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);
        scoreboard.updateScore("Argentina", "Australia", 3, 1);
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.finishMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals(4, summary.size());
        assertEquals("Uruguay 6 - 6 Italy", summary.get(0));
        assertEquals("Spain 10 - 2 Brazil", summary.get(1));
        assertEquals("Argentina 3 - 1 Australia", summary.get(2));
        assertEquals("Germany 2 - 2 France", summary.get(3));
    }
}
