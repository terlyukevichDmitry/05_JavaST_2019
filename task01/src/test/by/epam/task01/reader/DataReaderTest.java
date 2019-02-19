
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

@SuppressWarnings("CheckStyle")
public class DataReaderTest {

    private static final String FILE = "data" + File.separator + "file.txt";

    @Test(expectedExceptions = MissingWayFileException.class,
    description = "Negative script for show my exception.")
    public void checkFileTest() throws MissingWayFileException {
        List<String> expected = Arrays.asList("1");
        List<String> actual = new DataReader().readListOfString(null);
        Assert.assertEquals("For check, \n" + "do we have a file path: ",
                expected, String.valueOf(actual));
    }

    @Test(description = "Positive script for reading file.")
    public void checkFileTestA() throws MissingWayFileException {
        List<String> expected = new ArrayList<String>() {
            {
                add("3 1 0 3 25 0 4 10 6");
                add("3 4 3 4 1 4 7 8 9");
                add("1 2 3 4.23 6 7 8 ыва аы23");
                add("2 3z adasd4.v93 2s 3.123123 6");
                add("6 4 2 7.131 1,f123 4 4");
                add(" ");
                add("sldkfasjldfkj 1921 29812 h1iuh u21h1 2h1j2h 21");
                add("sjkhafjd fjashdf sahdfhsadfl shdfjkasd fjh");
            }
        };
        List<String> actual = new DataReader().readListOfString(FILE);
        Assert.assertEquals(expected.get(0), actual.get(0));
    }
}
