package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortParagraphBySentence;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * An public class for testing sort method. It is sort paragraph by number of
 * sentence.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SortParagraphBySentenceTest {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator
            + "lab3-text.txt";
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
        TextComposite composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        SortParagraphBySentence sortParagraphBySentence =
                new SortParagraphBySentence();
        sortParagraphBySentence.sortingData(composite);
        String expected = "     It is a 1274 established fact that a reader "
                + "will be of a page when looking at its layout.\n"
                + "     Bye.\n"
                + "     It is a long established fact that a reader will be "
                + "distracted by the readable content of a page when looking "
                + "at its layout... The point of using 78 Ipsum is that it "
                + "has a more-or-less normal distribution of letters, as "
                + "opposed to using (Content here), content here', making it "
                + "look like readable English.\n"
                + "     It has survived - not only (five) centuries, but also "
                + "the leap34 into 52 electronic typesetting, remaining 3 "
                + "essentially 9 unchanged. It was popularised in the 5 with "
                + "the release of Letraset sheets containing Lorem Ipsum "
                + "passages, and more recently with desktop publishing "
                + "software like Aldus PageMaker including versions of "
                + "Lorem Ipsum.\n";
        Assert.assertEquals(composite.toString(), expected);
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
