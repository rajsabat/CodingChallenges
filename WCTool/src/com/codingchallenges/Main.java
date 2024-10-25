package com.codingchallenges;

import java.io.File;

public class Main {

    private static final String COUNT_BYTES = "-c";

    public static void main(String[] args) {
        // Step Zero & One
        String operation = args[0];
        String filepath = args[1];

        if (!operation.equals(COUNT_BYTES)) {
            throw new RuntimeException("Invalid operation provided.");
        }

        File file = new File(filepath);
        System.out.println(file.length());
    }
}
