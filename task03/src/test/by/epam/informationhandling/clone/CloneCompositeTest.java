package test.by.epam.informationhandling.clone;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * An public class for testing many method for clone composite object.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class CloneCompositeTest {
    /**
     * file direction.
     */
    private static final String FILE = "data"
            + File.separator + "lab3-text.txt";
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
    public void initPyramidCalculator() {
        textSeparator = new TextSeparator();
        dataReader = new DataReader();
    }
    /**
     * method for testing create clone object.
     * @throws MissingWayFileException for checking exception situations.
     * @throws IncorrectDataException for checking exception situations.
     */
    @Test
    public void cloningCompositeTest() throws MissingWayFileException,
            IncorrectDataException {
        TextComposite expected = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        TextComposite actual = new TextComposite(expected);
        Assert.assertEquals(expected, actual);
    }
    /**
     * For remove objects.
     */
    @AfterTest
    private void initPyramidCalculatorA() {
        dataReader = null;
        textSeparator = null;
    }
}
