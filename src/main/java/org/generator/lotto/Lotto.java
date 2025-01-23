package org.generator.lotto;

import org.generator.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto implements GenerateGuess {
    private final FileHandler fileHandler;
    private ArrayList<Integer> numbersWithoutUnluckyNumbers = new ArrayList<>();

    public Lotto(FileHandler fileHandler){this.fileHandler = fileHandler;}

    public int[] generateNumbers(){
        if(!setUnluckyNumbers(fileHandler.getUnluckyNumbers())){
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

    private boolean checkUnluckyNumbers(ArrayList<Integer> unluckyNumbers) {
        for(int unluckyNumber : unluckyNumbers) {
            if(unluckyNumber < 1 || unluckyNumber > 49) {
                return false;
            }
        }
        return true;
    }

    private boolean setUnluckyNumbers(ArrayList<Integer> unluckyNumbers) {
        if(!checkUnluckyNumbers(unluckyNumbers)) {
            return false;
        }
        numbersWithoutUnluckyNumbers.clear();
        for(int i = 1; i <= 49; i++) {
            numbersWithoutUnluckyNumbers.add(i);
        }
        try {
            numbersWithoutUnluckyNumbers.removeAll(unluckyNumbers);
        } catch (Exception e) {
            System.out.println("Fehler beim Entfernen der Unglückszahlen. Die Zahlen dürfen nur einmal vorkommen und nur zwischen 1 und 49 sein.");
        }

        return true;
    }
}
