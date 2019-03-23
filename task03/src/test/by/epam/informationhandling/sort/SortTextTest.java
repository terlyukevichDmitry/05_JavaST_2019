package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortText;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

public class SortTextTest {

    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator
            + "testWordSort.txt";

    @Test
    public void sortingData() throws MissingWayFileException,
            IncorrectDataException {
        final char symbol = 't';
        DataReader dataReader = new DataReader();
        TextSeparator textSeparator = new TextSeparator();
        TextComposite composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        SortText sortText = new SortText();
        ArrayList<TextComponent> actual = sortText.sortingData(
                composite, symbol);
    }
}
