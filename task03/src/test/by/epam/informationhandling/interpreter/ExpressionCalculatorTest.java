package test.by.epam.informationhandling.interpreter;

import by.epam.informationhandling.interpreter.ExpressionCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for test calculator to calculating polish notation.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ExpressionCalculatorTest {
    /**
     * {@inheritDoc}
     * @return object with data for polish notation.
     */
    @DataProvider(name = "result_polish_notation")
    public Object[][] createCorrectDataForNotation() {
        final int fiftyTwo = 52;
        return
                new Object[][]{
                        {fiftyTwo, new ArrayList<String>() {
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
     * Test for checking good works to calculating polish notation.
     * And in this method we are testing methods in expression context class.
     * @param expression example List<String> with expression components
     * for calculating notation.
     * @param expected true result.
     */
    @Test(dataProvider = "result_polish_notation")
    public void polishCreating(final int expected,
                               final List<String> expression) {
        ExpressionCalculator expressionCalculator
                = new ExpressionCalculator(expression);
        int actual = (int) expressionCalculator.calculate();
        Assert.assertEquals(expected, actual);
    }
}
