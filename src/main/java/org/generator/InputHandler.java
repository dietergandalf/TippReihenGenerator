package org.generator;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class to handle the input
 **/
public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Set the input stream
     * @param inputStream The input stream
     * Use this method to set the input stream for the scanner
     * Only used for testing
     **/
    public static void setInputStream(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    /**
     * Read the input
     * @return The input as a string
     **/
    public static String readInput() {
        return scanner.nextLine();
    }
}
