package test.by.epam.informationhandling.separator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

public class TextSeparator {
    /**
     * {@inheritDoc}
     * @return object with data for polish notation.
     */
    @DataProvider(name = "polish_notation")
    public Object[][] createCorrectDataForVolume() {
        return
                new Object[][]{
                        {"",
                        }
                };
    }
    @Test
    public void creatingTree() {

    }
}
