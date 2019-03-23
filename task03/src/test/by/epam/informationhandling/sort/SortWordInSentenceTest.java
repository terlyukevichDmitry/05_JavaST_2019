package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortWordInSentence;
import org.testng.annotations.Test;

import java.io.File;

public class SortWordInSentenceTest {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "lab3-text.txt";

    @Test
    public void sortingDataTest() throws MissingWayFileException,
            IncorrectDataException {
        DataReader dataReader = new DataReader();
        TextSeparator textSeparator = new TextSeparator();
        TextComposite composite = textSeparator.creatingTree(dataReader.readListOfString(FILE));
        SortWordInSentence sortWordInSentence = new SortWordInSentence();
        sortWordInSentence.sortingData(composite);
        System.out.println(composite);
    }
}
