package org.generator;

import org.generator.lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> unluckyNumbers = new ArrayList<>();
        FileHandler fileHandler = new FileHandler();

        for(String arg : args) {
            int number = Integer.parseInt(arg);
            unluckyNumbers.add(number);
            if(unluckyNumbers.size() > 6) {
                System.out.println("Es können maximal 6 Unglückszahlen angegeben werden.");
                return;
            }
            fileHandler.saveData(String.join(" ", unluckyNumbers.toString()));
        }
        Lotto lotto = new Lotto(fileHandler);
        int[] numbers = lotto.generateNumbers();

        if(numbers.length == 0) {
            return;
        }
        System.out.println("Dein Tipp für 6 aus 49: " + Arrays.toString(numbers));
    }
}
