package com.livefootball.scoreboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballScoreboardTest {

    FootballScoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new FootballScoreboard();
    }

    @Test
    public void givenAMatch_shouldGetSummaryOfTheMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals("Mexico 0 - 0 Canada", summary.get(0));
    }

    @Test
    public void givenANewScore_shouldUpdateTheSummary() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        assertEquals("Mexico 0 - 5 Canada", summary.get(0));
    }

    @Test
    public void testFinishMatch() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.finishMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getMatchesInProgressSummary();
        Assertions.assertEquals(0, summary.size());
    }
}
