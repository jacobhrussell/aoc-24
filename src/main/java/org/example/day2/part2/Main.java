package org.example.day2.part2;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// 534 too high
// 481 not right
// 580 not right
// 519 not right

/**
 * Example input:
 * <p>
 * 75 76 77 80 82 85 84
 * 49 52 53 55 58 59 61 61
 * 54 57 60 62 66
 * 4 6 8 10 11 14 19
 * 82 85 86 83 85 87 89
 * 85 86 87 86 89 88
 */
public class Main {
    public static void main(String[] args) {

        // Parse input
        List<String> dayTwoInput = new ArrayList<>();
        InputStream inputStream = org.example.day2.part1.Main.class.getResourceAsStream("/day2.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            dayTwoInput = reader.lines().toList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create an array of arrays based on the input
        List<List<Integer>> levelsList = new ArrayList<>();
        for (String unparsedLevelsString : dayTwoInput) {
            List<Integer> levels = new ArrayList<>();
            List<String> parsedLevelsString = Arrays.stream(unparsedLevelsString.split(" ")).toList();
            parsedLevelsString.stream().forEach(element -> levels.add(Integer.valueOf(element)));
            levelsList.add(levels);
        }

        // Accumulate which reports are "safe"
        int numberOfSafeReports = 0;
        for (int i = 0; i < levelsList.size(); i++) {
            List<Integer> levels = levelsList.get(i);
            boolean isSafe = isSafe(levels);

            if (isSafe) {
                numberOfSafeReports++;
            }
        }

        System.out.println("numberOfSafeReports = " + numberOfSafeReports);

    }

    public static boolean isSafe(List<Integer> levels) {
        boolean isSafe = false;
        LevelsEvaluationResult levelsEvaluationResult = evaluateLevels(levels);

        // If there is a bad level, remove it and process it again
        Integer badLevel = levelsEvaluationResult.badLevel;
        if (!levelsEvaluationResult.isSafe && Objects.nonNull(badLevel)) {
            levels.remove(badLevel.intValue());
            levelsEvaluationResult = evaluateLevels(levels);
        }

        return levelsEvaluationResult.isSafe();
    }

    private record LevelsEvaluationResult(boolean isSafe, Integer badLevel) {
    }

    private static LevelsEvaluationResult evaluateLevels(List<Integer> levels) {
        boolean isSafe = true;
        Boolean isIncreasing = null;
        Integer badLevel = null;
        int previous = levels.get(0);

        for (int i = 1; i < levels.size(); i++) {
            int current = levels.get(i);
            int diff = current - previous;

            // Set the direction if it's the first time
            if (Objects.isNull(isIncreasing)) {
                isIncreasing = diff > 0 ? true : false;

                // If the numbers are the same we can break immediatley
                if (diff == 0) {
                    isSafe = false;
                    badLevel = i;
                    break;
                }
            }

            // See if diff makes level unsafe
            if (isIncreasing && (diff < 1 || diff > 3)) {
                isSafe = false;
                badLevel = i;
                break;
            } else if (!isIncreasing && (Math.abs(diff) < 1 || Math.abs(diff) > 3)) {
                isSafe = false;
                badLevel = i;
                break;
            }

            previous = current;
        }
        LevelsEvaluationResult levelsEvaluationResult = new LevelsEvaluationResult(isSafe, badLevel);
        return levelsEvaluationResult;
    }
}