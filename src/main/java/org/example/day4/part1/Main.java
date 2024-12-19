package org.example.day4.part1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        InputStream inputStream = Main.class.getResourceAsStream("/day4.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        input = bufferedReader.lines().toList();

        System.out.println(input);
    }
}
