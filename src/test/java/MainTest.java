import org.generator.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final Logger logger = Logger.getLogger(MainTest.class.getName());

    public MainTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testMainWithValidUnluckyNumbers() throws IOException {
        String[] args = {"15", "35", "6", "21", "16"};
        Main.main(args);

        File savedFile = new File(("unlucky_numbers.txt"));
        assertTrue(savedFile.exists());

        String content = Files.readString(savedFile.toPath());
        assertTrue(content.contains("15"));
        assertTrue(content.contains("35"));
        assertTrue(content.contains("6"));
        assertTrue(content.contains("21"));
        assertTrue(content.contains("16"));
    }

    @Test
    public void testMainWithInvalidUnluckyNumber() {
        String[] args = {"0"};
        File savedFile = new File("unlucky_numbers.txt");

        if(savedFile.exists()){
            savedFile.delete();
        }
        Main.main(args);
        assertFalse(savedFile.exists());
    }

    @Test
    public void testMainWithMoreThanSixUnluckyNumbers() {
        String[] args = {"1", "2", "3", "4", "5", "6", "7"};
        File savedFile = new File("unlucky_numbers.txt");
        if(savedFile.exists()){
            savedFile.delete();
        }
        Main.main(args);
        logger.log(Level.INFO, String.valueOf(savedFile.exists()));
        assertFalse(savedFile.exists());
    }

    @Test
    public void testMainWithNoUnluckyNumbers() {
        String[] args = {};
        File savedFile = new File("unlucky_numbers.txt");
        if(savedFile.exists()){
            savedFile.delete();
        }
        Main.main(args);
        assertFalse(savedFile.exists());
    }

    @Test
    public void testMainWithNonNumericInput() {
        String[] args = {"abc"};
        File savedFile = new File("unlucky_numbers.txt");
        if(savedFile.exists()){
            savedFile.delete();
        }
        assertThrows(NumberFormatException.class, () -> Main.main(args));
        assertFalse(savedFile.exists());
    }
}