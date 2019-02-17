
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package test.by.epam.task01.reader;

import by.epam.task01.exception.MissingWayFileException;
import by.epam.task01.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *An public class for reading different information.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class DataReaderTest {

    /**
     * Logger for recording a program state.
     */
    private static final String FILE = "data" + File.separator + "test.txt";
    /**
     * @throws MissingWayFileException for check file path
     */
    @Test(expectedExceptions = MissingWayFileException.class,
    description = "Negative script for show my exception.")
    public void checkFileTest() throws MissingWayFileException {
        List<String> expected = Arrays.asList("1");
        List<String> actual = new DataReader().readListOfString(null);
        Assert.assertEquals("For check, \n" + "do we have a file path: ",
                expected, String.valueOf(actual));
    }

    /**
     * @throws MissingWayFileException for check file path
     */
    @Test(description = "Positive script for reading file.")
    public void checkFileTestA() throws MissingWayFileException {
        List<String> expected = new ArrayList<String>() {
            {
                add("1 1 4 1 4 4 5 2");
            }
        };
        List<String> actual = new DataReader().readListOfString(FILE);
        Assert.assertEquals(expected, actual);
    }
}
