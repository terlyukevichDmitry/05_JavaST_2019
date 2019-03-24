package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortAllLexemeInText;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * An public class for testing sort method. It is sort lexemes in our text.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SortAllLexemeInTextTest {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator
            + "testWordSort.txt";
    /**
     * Data reader object for reading text of file.
     */
    private DataReader dataReader;
    /**
     * Text separator object for separating text on components and creating
     * tree.
     */
    private TextSeparator textSeparator;
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initSortData() {
        textSeparator = new TextSeparator();
        dataReader = new DataReader();
    }
    /**
     * Method for checking good works sort method.
     * {@inheritDoc}.
     * @throws MissingWayFileException for checking exception moments.
     * @throws IncorrectDataException for checking exception moments.
     */
    @Test
    public void sortingDataTest() throws MissingWayFileException,
            IncorrectDataException {
        final char symbol = 't';
        TextComposite composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        ArrayList<TextComponent> actual = new SortAllLexemeInText().sortingData(
                composite, symbol);
        String expected = "[ content,  distracted,  that,  It,  at,  "
                + "established,  fact,  its,  layout,  the,  a,  a,  a,  be,  "
                + "by,  is,  long,  looking,  of,  page,  readable,  reader,  "
                + "when,  will, .]";
        System.out.println(actual.toString());
        Assert.assertEquals(actual.toString(), expected);
    }
    /**
     * For remove objects.
     */
    @AfterTest
    private void removeSortData() {
        dataReader = null;
        textSeparator = null;
    }
}
