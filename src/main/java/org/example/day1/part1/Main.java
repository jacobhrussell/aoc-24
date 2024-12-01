package org.example.day1.part1;

// https://adventofcode.com/2024/day/1

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        InputStream inputStream = Main.class.getResourceAsStream("/day1.txt");
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

        // Sort the two lists
        List<Integer> sortedLeft = left.stream().sorted().toList();
        List<Integer> sortedRight = right.stream().sorted().toList();

        // Accumulate the distance between the elements in both lists
        int accumulatedDistance = 0;
        for (int i = 0; i < sortedLeft.size(); i++) {
            accumulatedDistance += Math.abs(sortedLeft.get(i) - sortedRight.get(i));
        }

        System.out.println(accumulatedDistance);

    }
}