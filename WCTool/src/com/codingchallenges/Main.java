package com.codingchallenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final String COUNT_BYTES = "-c";
    private static final String COUNT_NUMBER_OF_LINES = "-l";
    private static final String COUNT_NUMBER_OF_WORDS = "-w";

    public static void main(String[] args) {
        // Step Zero & One
        String operation = args[0];
        String filepath = args[1];

        switch (operation) {
            case COUNT_BYTES:
                countBytes(filepath);
                return;
            case COUNT_NUMBER_OF_LINES:
                countNoOfLines(filepath);
                return;
            case COUNT_NUMBER_OF_WORDS:
                countNoOfWords(filepath);
                return;
            default:
                throw new IllegalArgumentException("Invalid operation provided.");
        }

    }

    private static void countBytes(String filepath) {
        File file = new File(filepath);
        if (isFileExists(filepath, file)) return;
        System.out.println(file.length());
    }


    private static void countNoOfLines(String filepath) {
        File file = new File(filepath);

        // Check if file exists
        if (isFileExists(filepath, file)) return;

        //Step 3
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void countNoOfWords(String filepath) {
    }

    private static boolean isFileExists(String filepath, File file) {
        if (!file.exists()) {
            System.err.println("File not found: " + filepath);
            return true;
        }
        return false;
    }


}
