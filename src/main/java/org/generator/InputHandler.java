package org.generator;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static void setInputStream(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public static String readInput() {
        return scanner.nextLine();
    }
}
