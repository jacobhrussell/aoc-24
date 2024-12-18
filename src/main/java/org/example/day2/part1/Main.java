package org.example.day2.part1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example input:
 *
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
        InputStream inputStream = Main.class.getResourceAsStream("/day2.txt");
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
            boolean isAllIncreasingSafely = isAllIncreasingSafely(levels);
            boolean isAllDecreasingSafely = isAllDecreasingSafely(levels);

            if (isAllIncreasingSafely || isAllDecreasingSafely) {
                numberOfSafeReports++;
            }
        }

        System.out.println("numberOfSafeReports = " + numberOfSafeReports);

    }

    public static boolean isAllIncreasingSafely(List<Integer> levels) {
        boolean isIncreasingSafely = true;
        int previous = levels.get(0);

        for (int i = 1; i < levels.size(); i++) {
            int current = levels.get(i);
            int diff = current - previous;

            if (diff < 1 || diff > 3) {
                isIncreasingSafely = false;
                break;
            }

            previous = current;
        }

        return isIncreasingSafely;
    }

    public static boolean isAllDecreasingSafely(List<Integer> levels) {
        boolean isDecreasingSafely = true;
        int previous = levels.get(0);

        for (int i = 1; i < levels.size(); i++) {
            int current = levels.get(i);
            int diff = previous - current;

            if (diff < 1 || diff > 3) {
                isDecreasingSafely = false;
                break;
            }

            previous = current;
        }

        return isDecreasingSafely;
    }
}
