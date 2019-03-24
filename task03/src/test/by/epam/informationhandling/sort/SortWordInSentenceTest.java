package test.by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import by.epam.informationhandling.sort.SortWordInSentence;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * An public class for testing sort method. It is sort word in sentence.
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SortWordInSentenceTest {
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
        TextComposite composite = new TextComposite();
        composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE), composite);
        SortWordInSentence sortWordInSentence = new SortWordInSentence();
        sortWordInSentence.sortingData(composite);
        String expected = "    ... a a a It is be by of at the its long fact "
                + "that will page when reader layout content looking readable "
                + "distracted established,,,. a of 78 is it of as to it The "
                + "has that look like point using Ipsum using here) here' "
                + "normal making letters opposed content English (Content "
                + "readable more-or-less distribution\n"
                + "    . a a a It is be of at its 1274 fact that will page "
                + "when reader layout looking established\n"
                + "    . Bye\n"
                + "    ,,. - 3 9 It 52 has not but the only also into (five) "
                + "leap34 survived centuries remaining unchanged electronic "
                + "typesetting essentially,. 5 It in of of was the the and "
                + "with more with like Lorem Ipsum Aldus Lorem Ipsum sheets "
                + "release desktop Letraset passages recently software "
                + "versions PageMaker including containing publishing "
                + "popularised\n";
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
