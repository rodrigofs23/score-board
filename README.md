# Live Football World Cup Score Board

The Live Football World Cup Score Board is a Java application that allows users to keep track of football matches and their scores. The application provides functionality for starting matches, updating scores, finishing matches, and getting summaries of matches in progress.

## Development Strategies
I'm going to list some strategies and assumptions that I used that might be worth to mention.
1. I used Test Driven Development (TDD) to write the tests and the later code. In that way I manage to keep the implementation clean.
2. To keep the simplicity of the library, I only considered the Match Status as "IN_PROGRESS" or "FINISHED". However, it should be extended if it was a real project.
3. The matches finished are not removed from the list of matches. I decided to keep them there to be able to get a summary of all the matches that happened.

## Usage
* Make sure you have Java 17 installed.

To use the Football Scoreboard, you can open the project in your Java IDE and run the `FootballScoreboardTest` class. This will run a suite of tests that demonstrate the functionality of the `FootballScoreboard` class.

Alternatively, you can use the `FootballScoreboard` class directly in your own Java application. You just need to add the dependency to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>com.livefootball</groupId>
        <artifactId>score-board</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```

Here's an example of how to use the `FootballScoreboard` class:

```java
FootballScoreboard scoreboard = new FootballScoreboard();

scoreboard.startMatch("Mexico", "Canada");
scoreboard.updateScore("Mexico", "Canada", 2, 1);

List<String> summary = scoreboard.getMatchesInProgressSummary();
System.out.println(summary);
```

This code creates a new `FootballScoreboard` object, starts a match between Mexico and Canada, updates the score to 2-1 in favor of Mexico, and gets a summary of matches in progress. The output of the `System.out.println(summary)` statement should be something like this:

```
[Mexico 2 - 1 Canada]
```
