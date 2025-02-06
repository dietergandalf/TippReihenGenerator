package org.generator;

import org.generator.lotto.EuroLotto;
import org.generator.lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import static org.generator.FileHandler.logger;

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
        FileHandler fileHandler = new FileHandler("unlucky_numbers.txt");

        boolean euro = false;
        if(args.length == 1){
            switch (args[0]) {
                case "euro":
                    euro = true;
                    break;
                case "help":
                    System.out.println("Usage: java -jar generator.jar [euro] [number1] [number2] ...");
                    System.out.println("Standard: Generiere eine Lotto Reihe mit den Unglückszahlen");
                    System.out.println("euro: Generiere eine EuroLotto Reihe mit den Unglückszahlen");
                    System.out.println("number1, number2, ...: Die Unglückszahlen");
                    System.out.println("delete: Lösche die alten Unglückszahlen");
                    System.out.println("help: Zeige diese Hilfe an");
                    return;
                case "delete":
                    fileHandler.deleteFile();
                    System.out.println("Die alten Unglückszahlen wurden gelöscht.");
                    return;
                default:
                    break;
            }
        }

        for(String arg : args) {
            int number;
            try {number = Integer.parseInt(arg);}
            catch (NumberFormatException e) {
                if(arg.equals("euro")) {
                    euro = true;
                    continue;
                }
                System.out.println("Die Unglückszahlen müssen Zahlen sein.");
                logger.log(Level.SEVERE, "Fehler beim Parsen der Zahl: " + arg);
                throw e;
            }
            unluckyNumbers.add(number);
            if (number < 1 || number > 50) {
                System.out.println("Die Unglückszahlen müssen zwischen 1 und 50 liegen.");
                return;
            }
            if(unluckyNumbers.size() > 6) {
                System.out.println("Es können maximal 6 Unglückszahlen angegeben werden.");
                return;
            }
        }
        fileHandler.saveData(String.join(" ", unluckyNumbers.toString()));

        while(true){
            if(euro) playEuro(fileHandler);
            else playLotto(fileHandler);
            System.out.println("Möchtest du eine neue Reihe generieren? (j/n)");
            String input;
            while(true){
                input = InputHandler.readInput();
                if(input.equals("n")) {
                    break;
                } else if (input.equals("j")) {
                    break;
                } else {
                    System.out.println("Bitte gib j oder n ein.");
                }
            }
            if(input.equals("n")) {
                break;
            }
        }

        // delete the file if there are no unlucky numbers
        if(fileHandler.getUnluckyNumbers().isEmpty()){
            fileHandler.deleteFile();
        }
    }

    private static void playLotto(FileHandler fileHandler){
        Lotto lotto = new Lotto(fileHandler);
        int[] numbers = lotto.generateNumbers();
        if(numbers.length == 0) {
            return;
        }
        System.out.println("Dein Tipp für 6 aus 49: " + Arrays.toString(numbers));
    }

    private static void playEuro(FileHandler fileHandler){
        EuroLotto euroLotto = new EuroLotto(fileHandler);
        int[] numbers = euroLotto.generateNumbers();
        if(numbers.length == 0) {
            return;
        }
        int[] euroNumbers = Arrays.copyOfRange(numbers, 0, 5);
        int[] euroStars = Arrays.copyOfRange(numbers, 5, 7);
        System.out.println("Dein Tipp für 5 aus 50: " + Arrays.toString(euroNumbers) + "\nUnd deine 2 aus 10: " + Arrays.toString(euroStars));
    }
}
