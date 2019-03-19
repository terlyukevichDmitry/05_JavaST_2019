package by.epam.informationhandling.main;

import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.interpreter.Context;
import by.epam.informationhandling.interpreter.Expression;
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
//        String str = "43|30>>>354";
//        Context context = new Context();
//        Expression result = context.evaluate(str);
    }
}
