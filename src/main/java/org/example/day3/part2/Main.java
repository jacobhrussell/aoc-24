package org.example.day3.part2;

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

        int answer = 0;
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        for (String instructions : input) {
            Matcher matcher = pattern.matcher(instructions);

            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                answer = answer + (x * y);
            }
        }

        System.out.println("answer = " + answer);
    }
}