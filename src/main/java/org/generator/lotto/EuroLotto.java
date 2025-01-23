package org.generator.lotto;

import org.generator.FileHandler;

public class EuroLotto implements GenerateGuess{

    public final FileHandler fileHandler;

    public EuroLotto(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public int[] generateNumbers() {
        return new int[0];
    }
}
