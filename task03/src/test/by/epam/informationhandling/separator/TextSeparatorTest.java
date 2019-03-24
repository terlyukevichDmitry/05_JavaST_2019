package test.by.epam.informationhandling.separator;

import by.epam.informationhandling.entity.TextComposite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextSeparatorTest {
    /**
     * {@inheritDoc}
     * @return object with data for creating tree.
     */
    @DataProvider(name = "data_for_create_tree")
    public Object[][] createCorrectDataForVolume() {
        return
                new Object[][]{
                        {
                            new TextComposite() {

                            }
                        }
                };
    }
    @Test
    public void creatingTreeTest() {

    }
}
