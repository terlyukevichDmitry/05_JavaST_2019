package by.epam.informationhandling.main;

import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionCalculator;
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

    public static void main(String[] args) throws MissingWayFileException, IncorrectDataException {

        TextSeparator textSeparator = new TextSeparator();
        textSeparator.separatingText(FILE);
        String str = "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)";
        LOGGER.info(5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1));
        PolishNotationCreator polishNotationCreator = new PolishNotationCreator();
        try {
            ExpressionCalculator calculator = new ExpressionCalculator(polishNotationCreator.polishCreating(str));
            LOGGER.info(calculator.calculate());
        } catch (NullDataException e) {
            LOGGER.error(
                    "We have null object in expression!", e);
        }

    }
}
