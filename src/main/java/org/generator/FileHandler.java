package org.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private static final Logger logger = Logger.getLogger(FileHandler.class.getName());
    private String path;

    public FileHandler(){
        System.out.println("Wo möchtest du die Unglückszahlen speichern?");
        path = InputHandler.readInput();
        path = path + "/unluckyNumbers.txt";
    }

    public void saveData(String data) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fehler beim Schreiben der Datei.", e);
        }
    }

    private String readData() {
        String data = "";
        try {
            data = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path)));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fehler beim Lesen der Datei.", e);
        }
        data = data.substring(1, data.length() - 1);
        return data;
    }

    public ArrayList<Integer> getUnluckyNumbers() {
        String data = readData();
        ArrayList<Integer> unluckyNumbers = new ArrayList<>();
        for(String number : data.split(", ")) {
            unluckyNumbers.add(Integer.parseInt(number));
        }
        return unluckyNumbers;
    }
}
