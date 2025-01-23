package org.generator;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        return scanner.nextLine();
    }

    public static String[] getInput() {
        return readInput().split(" ");
    }
}
