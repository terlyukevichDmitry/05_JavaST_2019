package test.by.epam.informationhandling.entity;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * An public class for test creating text composite object.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class TextCompositeTest {
    /**
     * @return object with data for creating and checking text composite object.
     * object.
     */
    @DataProvider(name = "text_composite_object")
    public Object[][] createCorrectDataForNotation() {
        return
                new Object[][]{
                        {new TextComposite(), new ArrayList<>(), null}
                };
    }
    /**
     * Test for checking good works to calculating polish notation.
     * @param textElementType example constant for creating object.
     * @param list list to create object.
     * @param expected expected object.
     */
    @Test(dataProvider = "text_composite_object")
    public void polishCreating(final TextComposite expected,
                               final ArrayList<TextComponent> list,
                               final TextElementType textElementType) {
        expected.setComponents(list);
        expected.setTextElementType(textElementType);
        TextComposite actual = new TextComposite();
        Assert.assertEquals(expected, actual);
    }
}
