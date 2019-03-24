package test.by.epam.informationhandling.interpreter;

import by.epam.informationhandling.interpreter.ExpressionConstant;
import by.epam.informationhandling.interpreter.SymbolPriority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * An public class for test creating symbol priority object.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SymbolPriorityTest {
    /**
     * @return object with data for creating and checking symbol priority
     * object.
     */
    @DataProvider(name = "symbol_priority_object")
    public Object[][] createCorrectDataForNotation() {
        final int ten = 10;
        return
                new Object[][]{
                        {ExpressionConstant.OR, "|",
                                new SymbolPriority(ten, "|")}
                };
    }
    /**
     * Test for checking good works to calculating polish notation.
     * @param expressionConstant example constant for creating object.
     * @param expected true result.
     * @param symbol for create object.
     */
    @Test(dataProvider = "symbol_priority_object")
    public void polishCreating(final ExpressionConstant expressionConstant,
                               final String symbol,
                               final SymbolPriority expected) {
        SymbolPriority actual =
                new SymbolPriority(expressionConstant.getPriority(), symbol);
        Assert.assertEquals(expected, actual);
    }
}
