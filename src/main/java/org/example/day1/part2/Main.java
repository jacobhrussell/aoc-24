package org.example.day1.part2;

// https://adventofcode.com/2024/day/1

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example input:
 *
 * 88159   51481
 * 66127   31794
 * 71500   84893
 * 59372   58807
 * 97356   27409
 *
 */
public class Main {
    public static void main(String[] args) {

        // Parse input
        List<String> dayOneInput = new ArrayList<>();
        InputStream inputStream = org.example.day1.part1.Main.class.getResourceAsStream("/day1.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            dayOneInput = reader.lines().toList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create two lists based on the input
        final List<Integer> left = new ArrayList<>();
        final List<Integer> right = new ArrayList<>();
        dayOneInput.stream().forEach(element -> {
            List<String> splitElement = Arrays.stream(element.split("   ")).toList();
            left.add(Integer.valueOf(splitElement.get(0)));
            right.add(Integer.valueOf(splitElement.get(1)));
        });

        // Accumulate the two lists similarity score
        int accumulatedSimilarityScore = 0;
        for (int i = 0; i < left.size(); i++) {
            int leftElement = left.get(i);
            int similarityScore = right.stream()
                    .filter(rightElement -> leftElement == rightElement)
                    .mapToInt(Integer::intValue)
                    .sum();

            accumulatedSimilarityScore += similarityScore;
        }

        System.out.println(accumulatedSimilarityScore);

    }
}
