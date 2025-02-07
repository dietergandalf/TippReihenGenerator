package org.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to handle the file saving and reading
 **/
public class FileHandler {
    protected static final Logger logger = Logger.getLogger(FileHandler.class.getName());
    private final String path;


    public FileHandler(String path){
        this.path = path;
    }

    /**
     * Save the unlucky numbers to a file
     * @param data The unlucky numbers
     **/
    public void saveData(String data) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fehler beim Schreiben der Datei.", e);
        }
    }

    /**
     * Read the unlucky numbers from a file
     * @return The saved data as a string
     **/
    private String readData() {
        String data = "";
        try {
            data = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path)));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fehler beim Lesen der Datei.", e);
        }
        if(data.isEmpty()) {
            return data;
        }
        data = data.substring(1, data.length() - 1);
        return data;
    }

    /**
     * Get the unlucky numbers from the file
     * @return The unlucky numbers as an ArrayList
     **/
    public ArrayList<Integer> getUnluckyNumbers() {
        String data = readData();
        if (data.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> unluckyNumbers = new ArrayList<>();
        for(String number : data.split(", ")) {
            unluckyNumbers.add(Integer.parseInt(number));
        }
        return unluckyNumbers;
    }

    /**
     * Get the unlucky numbers for the EuroLotto 5 of 50
     * @return The unlucky numbers as an ArrayList
     **/
    public ArrayList<Integer> getUnluckyNumbers50(){
        return getUnluckyNumbers();
    }

    /**
     * Get the unlucky numbers for the Lotto 6 of 49
     * @return The unlucky numbers up to 49 as an ArrayList
     **/
    public ArrayList<Integer> getUnluckyNumbers49(){
        ArrayList<Integer> unluckyNumbers = getUnluckyNumbers();
        // Remove all elements greater than 49
        unluckyNumbers.removeIf(n -> n > 49 || n < 1);
        return unluckyNumbers;
    }

    /**
     * Get the unlucky numbers for the EuroLotto 2 of 10
     * @return The unlucky numbers up to 10 as an ArrayList
     **/
    public ArrayList<Integer> getUnluckyNumbers10(){
        ArrayList<Integer> unluckyNumbers = getUnluckyNumbers();
        // Remove all elements greater than 10
        unluckyNumbers.removeIf(n -> n > 10 || n < 1);
        return unluckyNumbers;
    }

    /**
     * Delete the file
     * @return true if the file was deleted
     **/
    public boolean deleteFile() {
        return new java.io.File(path).delete();
    }
}
