package test.by.epam.informationhandling.reader;

import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 *An public class for testing many different methods of DataReader calculateExpression class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class DataReaderTest {
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "test.txt";
    /**
     * {@inheritDoc}.
     */
    @Test(expectedExceptions = MissingWayFileException.class,
            description = "Negative script for show my exception.")
    public void checkFileTest() throws MissingWayFileException {
        String expected = "1";
        String actual = new DataReader().readListOfString(null);
        Assert.assertEquals("For check, \n" + "do we have a file path: ",
                expected, String.valueOf(actual));
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for reading file.")
    public void checkFileTestA() throws MissingWayFileException {
        String expected = "jklas jsld sdkjlfe 9fsdf 9sfds fs 23 323.";
        String actual = new DataReader().readListOfString(FILE);
        Assert.assertEquals(expected, actual);
    }
}