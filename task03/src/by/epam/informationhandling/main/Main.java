package by.epam.informationhandling.main;

import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.Context;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {

    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "lab3-text.txt";
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public static void main(String[] args) throws MissingWayFileException, IncorrectDataException, NullDataException {

        TextSeparator textSeparator = new TextSeparator();
        textSeparator.separatingText(FILE);
//        String str = "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)";
//        LOGGER.info(5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1));
//        Context context = new Context();
//        int result = context.evaluate(str);
//        LOGGER.info(result);
    }
}
