package org.example.day5.part1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> inputOne = new ArrayList<>();
        InputStream inputStreamOne = Main.class.getResourceAsStream("/day5_1.txt");
        InputStreamReader inputStreamReaderOne = new InputStreamReader(inputStreamOne);
        BufferedReader bufferedReaderOne = new BufferedReader(inputStreamReaderOne);
        inputOne = bufferedReaderOne.lines().toList();

        List<String> inputTwo = new ArrayList<>();
        InputStream inputStreamTwo = Main.class.getResourceAsStream("/day5_2.txt");
        InputStreamReader inputStreamReaderTwo = new InputStreamReader(inputStreamTwo);
        BufferedReader bufferedReaderTwo = new BufferedReader(inputStreamReaderTwo);
        inputTwo = bufferedReaderTwo.lines().toList();

        

    }
}
