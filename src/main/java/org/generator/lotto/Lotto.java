package org.generator.lotto;

import org.generator.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to generate the numbers for the Lotto
 **/
public class Lotto implements GenerateGuess {
    private final FileHandler fileHandler;
    private final ArrayList<Integer> numbersWithoutUnluckyNumbers = new ArrayList<>();

    public Lotto(FileHandler fileHandler){this.fileHandler = fileHandler;}

    /**
     * Generate the numbers for the Lotto
     * @return The generated numbers, 6 numbers between 1 and 49
     **/
    @Override
    public int[] generateNumbers(){
        if(!setUnluckyNumbers()){
            System.out.println("Fehler beim Setzen der Unglückszahlen. Die Zahlen müssen zwischen 1 und 49 sein.");
            return new int[0];
        }
        int[] numbers = new int[6];
        for(int i = 0; i < 6; i++){
            int index = (int)(Math.random() * numbersWithoutUnluckyNumbers.size());
            numbers[i] = numbersWithoutUnluckyNumbers.remove(index);
        }
        return Arrays.stream(numbers).sorted().toArray();
    }

    /**
     * Set the unlucky numbers
     * @return true if the unlucky numbers are set;
     **/
    private boolean setUnluckyNumbers() {
        ArrayList<Integer> unluckyNumbers = fileHandler.getUnluckyNumbers49();
        numbersWithoutUnluckyNumbers.clear();
        for(int i = 1; i <= 49; i++) {
            numbersWithoutUnluckyNumbers.add(i);
        }
        numbersWithoutUnluckyNumbers.removeAll(unluckyNumbers);
        return true;
    }
}
