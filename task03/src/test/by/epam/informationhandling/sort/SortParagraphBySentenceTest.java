package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortParagraphBySentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;

public class SortParagraphBySentenceTest {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "lab3-text.txt";

    @Test
    public void sortingDataTest() throws MissingWayFileException,
            IncorrectDataException {
        DataReader dataReader = new DataReader();
        TextSeparator textSeparator = new TextSeparator();
        TextComposite composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        System.out.println(composite);
        SortParagraphBySentence sortParagraphBySentence =
                new SortParagraphBySentence();
        sortParagraphBySentence.sortingData(composite);
        System.out.println(composite);
    }
}
