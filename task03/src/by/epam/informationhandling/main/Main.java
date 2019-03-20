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
        String str = "(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78";
        System.out.println((71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78);
        Context context = new Context();
        Expression result = context.evaluate(str);
    }
}
