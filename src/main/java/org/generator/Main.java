package org.generator;

import org.generator.lotto.EuroLotto;
import org.generator.lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;

/**
* Main class to start the program
*
**/
public class Main {
    /**
     * Main method to start the program
     * @param args The unlucky numbers
     * **/
    public static void main(String[] args) {
        ArrayList<Integer> unluckyNumbers = new ArrayList<>();
        FileHandler fileHandler = new FileHandler();

        for(String arg : args) {
            int number = Integer.parseInt(arg);
            unluckyNumbers.add(number);
            if (number < 1 || number > 50) {
                System.out.println("Die Unglückszahlen müssen zwischen 1 und 50 liegen.");
                return;
            }
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

        EuroLotto euroLotto = new EuroLotto(fileHandler);
        numbers = euroLotto.generateNumbers();
        if(numbers.length == 0) {
            return;
        }
        int[] euroNumbers = Arrays.copyOfRange(numbers, 0, 5);
        int[] euroStars = Arrays.copyOfRange(numbers, 5, 7);
        System.out.println("Dein Tipp für 5 aus 50: " + Arrays.toString(euroNumbers) + "\nUnd deine 2 aus 10: " + Arrays.toString(euroStars));
    }
}
