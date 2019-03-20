package by.epam.informationhandling.main;

import by.epam.informationhandling.exception.IncorrectDataException;
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

    public static void main(String[] args) throws MissingWayFileException, IncorrectDataException {

//        TextSeparator textSeparator = new TextSeparator();
//        textSeparator.separatingText(FILE);
        String str = "(111^5|1&2<<(2|5>>2&71))|1200";
        System.out.println((111^5|1&2<<(2|5>>2&71))|1200);
        Context context = new Context();
        int result = context.evaluate(str);
        System.out.println(result);
    }
}
