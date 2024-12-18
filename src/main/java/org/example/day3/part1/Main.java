package org.example.day3.part1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        // Parse input
        List<String> input = new ArrayList<>();
        InputStream inputStream = Main.class.getResourceAsStream("/day3.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        input = bufferedReader.lines().toList();

        // Get a list of "good" instructions and compute the answer
        int answer = 0;
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        for (String instructions : input) {
            Matcher matcher = pattern.matcher(instructions);

            while (matcher.find()) {
                String fullMatch = matcher.group(0);
                String x = matcher.group(1);
                String y = matcher.group(2);

                System.out.println("fullMatch = " + fullMatch);
                System.out.println("x = " + x);
                System.out.println("y = " + y);

                answer = answer + (Integer.parseInt(x) * Integer.parseInt(y));
            }
        }

        System.out.println("answer = " + answer);
    }
}