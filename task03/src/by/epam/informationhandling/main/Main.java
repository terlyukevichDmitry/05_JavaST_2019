package by.epam.informationhandling.main;

import by.epam.informationhandling.action.CloneComposite;
import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionCalculator;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortParagraphBySentence;
import by.epam.informationhandling.sort.SortText;
import by.epam.informationhandling.sort.SortWordInSentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.crypto.Data;
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

        DataReader dataReader = new DataReader();
        TextSeparator textSeparator = new TextSeparator();
        TextComposite composite = textSeparator.creatingTree(dataReader.readListOfString(FILE));
//        SortParagraphBySentence sotr = new SortParagraphBySentence();
//        sotr.sortingData(composite);
//        SortWordInSentence sortWordInSentence = new SortWordInSentence();
//        sortWordInSentence.sortingData(composite);
        SortText sortText = new SortText();
        sortText.sortingData(composite);

        String str = "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)";
        LOGGER.info((5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1)));

//        System.out.println(composite);
        PolishNotationCreator polishNotationCreator = new PolishNotationCreator();
        try {
            ExpressionCalculator calculator = new ExpressionCalculator(polishNotationCreator.polishCreating(str));
            System.out.println(calculator.calculate());
        } catch (NullDataException e) {
            LOGGER.error(
                    "We have null object in expression!", e);
        }

    }
}
