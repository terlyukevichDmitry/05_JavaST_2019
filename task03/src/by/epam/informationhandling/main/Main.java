package by.epam.informationhandling.main;

import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.separator.TextSeparator;

import java.io.File;

public class Main {

    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "lab3-text.txt";

    public static void main(String[] args) throws MissingWayFileException {

        TextSeparator textSeparator = new TextSeparator();
        textSeparator.separatingText(FILE);

    }
}
