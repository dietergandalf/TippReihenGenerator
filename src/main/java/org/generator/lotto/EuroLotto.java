package org.generator.lotto;

import org.generator.FileHandler;

import java.util.ArrayList;

public class EuroLotto extends Lotto implements GenerateGuess{ // extend Lotto is not necessary but asked for

    public final FileHandler fileHandler;
    private final ArrayList<Integer> numbersWithoutUnluckyNumbers50 = new ArrayList<>();
    private final ArrayList<Integer> numbersWithoutUnluckyNumbers10 = new ArrayList<>();

    public EuroLotto(FileHandler fileHandler) {
        super(fileHandler);
        this.fileHandler = fileHandler;
    }

    /**
    * Generate the numbers for the EuroLotto
    * @return The generated numbers, 5 numbers between 1 and 50 and 2 numbers between 1 and 10
     **/
    @Override
    public int[] generateNumbers() {
        if(!setUnluckyNumbers()){
            System.out.println("Fehler beim Setzen der Unglückszahlen. Die Zahlen müssen zwischen 1 und 50 sein.");
            return new int[0];
        }
        int[] numbers = new int[7];
        ArrayList<Integer> numbersArray = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int index = (int)(Math.random() * numbersWithoutUnluckyNumbers50.size());
            numbersArray.add(numbersWithoutUnluckyNumbers50.remove(index));
        }
        numbersArray.sort(Integer::compareTo);
        for(int i = 0; i < 5; i++){
            numbers[i] = numbersArray.get(i);
        }
        numbersArray.clear();
        for(int i = 5; i < 7; i++){
            int index = (int)(Math.random() * numbersWithoutUnluckyNumbers10.size());
            numbersArray.add(numbersWithoutUnluckyNumbers10.remove(index));
        }
        numbersArray.sort(Integer::compareTo);
        for(int i = 5; i < 7; i++){
            numbers[i] = numbersArray.get(i - 5);
        }
        return numbers;
    }

    /**
    * Set the unlucky numbers
    * @return true if the unlucky numbers are set
    * false if the unlucky numbers are not valid
     **/
    private boolean setUnluckyNumbers() {
        ArrayList<Integer> unluckyNumbers50 = fileHandler.getUnluckyNumbers50();
        ArrayList<Integer> unluckyNumbers10 = fileHandler.getUnluckyNumbers10();

        numbersWithoutUnluckyNumbers50.clear();
        numbersWithoutUnluckyNumbers10.clear();

        for(int i = 1; i <= 50; i++) {
            if(i <= 10) {
                numbersWithoutUnluckyNumbers10.add(i);
            }
            numbersWithoutUnluckyNumbers50.add(i);
        }
        numbersWithoutUnluckyNumbers50.removeAll(unluckyNumbers50);
        numbersWithoutUnluckyNumbers10.removeAll(unluckyNumbers10);
        return true;
    }
}
