package test.by.epam.informationhandling.action;

import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.exception.NullDataException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for testing polish notation creator methods.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PolishNotationCreatorTest {
    /**
     * {@inheritDoc}
     * @return object with data for polish notation.
     */
    @DataProvider(name = "polish_notation")
    public Object[][] createCorrectDataForNotation() {
        return
                new Object[][]{
                        {"13<<2", new ArrayList<String>() {
                            {
                                add("13");
                                add("2");
                                add("<<");
                            }
                        }
                        }
                };
    }

    /**
     * Test for checking good works for creating polish notation.
     * @param string example string for create notation.
     * @param expected true result.
     * @throws NullDataException for checking exception situations.
     */
    @Test(description = "Positive script for check result.",
            dataProvider = "polish_notation")
    public void polishCreatingTest(final String string,
                               final List<String> expected)
            throws NullDataException {
        PolishNotationCreator creator = new PolishNotationCreator();
        List<String> actual = creator.polishCreating(string);

        Assert.assertEquals(expected, actual);
    }

    /**
     * Test for checking good works for creating polish notation.
     * @param string example string for create notation.
     * @param expected true result.
     * @throws NullDataException for checking exception situations.
     */
    @Test(expectedExceptions = NullDataException.class,
            description = "Negative script for check result.",
            dataProvider = "polish_notation")
    public void polishCreatingNegativeTest(final String string,
                               final List<String> expected)
            throws NullDataException {
        PolishNotationCreator creator = new PolishNotationCreator();
        List<String> actual = creator.polishCreating(null);
        Assert.assertEquals(expected, String.valueOf(actual));
        //Functional interfaces suka blyat!!!!!!!
    }
}
