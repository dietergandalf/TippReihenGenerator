package org.generator.lotto;

/**
 * Interface for Lotto Games guess generation
 * **/
public interface GenerateGuess {
    /**
     * Generate a guess for a lotto game.
     * @return the generated guess
     * **/
    int[] generateNumbers();

}
