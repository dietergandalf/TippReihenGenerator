import org.generator.InputHandler;
import org.generator.Main;
            import org.junit.jupiter.api.BeforeEach;
            import org.junit.jupiter.api.Test;

            import java.io.ByteArrayInputStream;
            import java.io.File;
            import java.io.IOException;
            import java.nio.file.Files;
            import java.util.logging.Level;
            import java.util.logging.Logger;

            import static org.junit.jupiter.api.Assertions.*;

            public class MainTest {

                private final Logger logger = Logger.getLogger(MainTest.class.getName());

                @BeforeEach
                public void setUp() {
                    // Resetting input stream before each test
                    InputHandler.setInputStream(System.in);
                }

                @Test
                public void testMainWithValidUnluckyNumbers() throws IOException {
                    String[] args = {"15", "35", "6", "21", "16"};
                    ByteArrayInputStream in = new ByteArrayInputStream("j\nn\n".getBytes());
                    InputHandler.setInputStream(in);
                    Main.main(args);

                    File savedFile = new File("unlucky_numbers.txt");
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

                    if (savedFile.exists()) {
                        savedFile.delete();
                    }
                    Main.main(args);
                    assertFalse(savedFile.exists());
                }

                @Test
                public void testMainWithMoreThanSixUnluckyNumbers() {
                    String[] args = {"1", "2", "3", "4", "5", "6", "7"};
                    File savedFile = new File("unlucky_numbers.txt");
                    if (savedFile.exists()) {
                        savedFile.delete();
                    }
                    Main.main(args);
                    logger.log(Level.INFO, String.valueOf(savedFile.exists()));
                    assertFalse(savedFile.exists());
                }

                @Test
                public void testMainLottoWithNoUnluckyNumbers() {
                    String[] args = {};
                    File savedFile = new File("unlucky_numbers.txt");
                    if (savedFile.exists()) {
                        savedFile.delete();
                    }

                    ByteArrayInputStream in = new ByteArrayInputStream("j\nn\n".getBytes());
                    InputHandler.setInputStream(in);

                    Main.main(args);
                    assertFalse(savedFile.exists());
                }

                @Test
                public void testMainEuroWithNoUnluckyNumbers() {
                    String[] args2 = {"euro"};
                    File savedFile2 = new File("unlucky_numbers.txt");
                    if (savedFile2.exists()) {
                        savedFile2.delete();
                    }

                    ByteArrayInputStream in2 = new ByteArrayInputStream("j\nn\n".getBytes());
                    InputHandler.setInputStream(in2);

                    Main.main(args2);
                    assertFalse(savedFile2.exists());
                }

                @Test
                public void testMainEuroWithUnluckyNumbers() {
                    String[] args2 = {"euro", "15", "35", "6", "21", "16"};
                    File savedFile2 = new File("unlucky_numbers.txt");
                    if (savedFile2.exists()) {
                        savedFile2.delete();
                    }

                    ByteArrayInputStream in2 = new ByteArrayInputStream("j\nn\n".getBytes());
                    InputHandler.setInputStream(in2);

                    Main.main(args2);
                    assertTrue(savedFile2.exists());
                }

                @Test
                public void testMainWithNonNumericInput() {
                    String[] args = {"abc"};
                    File savedFile = new File("unlucky_numbers.txt");
                    if (savedFile.exists()) {
                        savedFile.delete();
                    }
                    assertThrows(NumberFormatException.class, () -> Main.main(args));
                    assertFalse(savedFile.exists());
                }

                @Test
                public void testMainWithHelpArgument() {
                    String[] args = {"help"};
                    File savedFile = new File("unlucky_numbers.txt");
                    if (savedFile.exists()) {
                        savedFile.delete();
                    }

                    Main.main(args);
                    assertFalse(savedFile.exists());
                }

                @Test
                public void testMainWithDeleteArgument() {
                    String[] args = {"delete"};
                    File savedFile = new File("unlucky_numbers.txt");
                    if (!savedFile.exists()) {
                        try {
                            savedFile.createNewFile();
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Error creating file", e);
                        }
                    }

                    Main.main(args);
                    assertFalse(savedFile.exists());
                }
            }