package test.by.epam.informationhandling.entity;

import by.epam.informationhandling.entity.SymbolLeaf;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * An public class for test creating symbol leaf object.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class SymbolLeafTest {
    /**
     * @return object with data for creating and checking symbol leaf object.
     * object.
     */
    @DataProvider(name = "symbol_leaf_object")
    public Object[][] createCorrectDataForNotation() {
        return
                new Object[][]{
                        {new SymbolLeaf(), 'a'}
                };
    }
    /**
     * Test for checking good works to calculating polish notation.
     * @param expected expected object.
     * @param expectedSymbol for check symbol in objects.
     */
    @Test(dataProvider = "symbol_leaf_object")
    public void symbolLeafCreatingTest(final SymbolLeaf expected,
                               final char expectedSymbol) {
        expected.setSymbol(expectedSymbol);
        SymbolLeaf actual = new SymbolLeaf();
        actual.setSymbol(expectedSymbol);
        Assert.assertEquals(expected, actual);
    }
}
