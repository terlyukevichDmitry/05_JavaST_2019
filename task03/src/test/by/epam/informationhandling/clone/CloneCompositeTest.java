package test.by.epam.informationhandling.clone;

import by.epam.informationhandling.action.CloneComposite;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.reader.DataReader;
import by.epam.informationhandling.separator.TextSeparator;
import org.testng.annotations.Test;

import java.io.File;

public class CloneCompositeTest {

    /**
     * file direction.
     */
    private static final String FILE = "data"
            + File.separator + "lab3-text.txt";

    @Test
    public void cloningCompositeTest() throws MissingWayFileException,
            IncorrectDataException {
        DataReader dataReader = new DataReader();
        TextSeparator textSeparator = new TextSeparator();
        TextComposite composite = textSeparator.creatingTree(
                dataReader.readListOfString(FILE));
        System.out.println(composite);
        CloneComposite cloneComposite = new CloneComposite();
        TextComposite actual = cloneComposite.cloneComposite(composite);

    }
}
