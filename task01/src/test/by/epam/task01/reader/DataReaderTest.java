
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
     * @throws MissingWayFileException for check file path
     */
    @Test(expectedExceptions = MissingWayFileException.class)
    public void checkFile() throws MissingWayFileException {
        List<String> expectedList = Arrays.asList("1");
        List<String> actualList = new DataReader().readListOfString(null);
        Assert.assertEquals("For check, \n" + "do we have a file path: ",
                expectedList, String.valueOf(actualList));
    }
}
