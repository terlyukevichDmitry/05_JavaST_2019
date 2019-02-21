package test.by.epam.task01.creator;

import by.epam.task01.creator.ListCreator;
import by.epam.task01.exception.MissingWayFileException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *An public class for testing many different methods of
 * ListCreatorTest class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ListCreatorTest {

    /**
     * ListCreator for use object this classes.
     */
    private ListCreator listCreator;
    /**
     * file direction.
     */
    private static final String FILE = "data" + File.separator + "test.txt";
    /**
     * Map for use data.
     */
    private Map<Integer, List<Double>> expectedMap;
    /**
     * constant.
     */
    private final double one = 1.0;
    /**
     * constant.
     */
    private final double four = 4.0;
    /**
     * constant.
     */
    private final double zero = 0.0;
    /**
     * constant.
     */
    private final double three = 3.0;
    /**
     * constant.
     */
    private final double twentyFive = 25.0;
    /**
     * constant.
     */
    private final double six = 6.0;
    /**
     * constant.
     */
    private final double ten = 10.0;
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initData() {
        List<Double> doubleList = new ArrayList<>(Arrays.asList(three, one,
                zero, three, twentyFive, zero, four, ten, six));
        listCreator = new ListCreator();
        expectedMap = new HashMap<>();
        expectedMap.put(0, doubleList);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script of the square calculation")
    public void createListTest() throws MissingWayFileException {
        Map<Integer, List<Double>> actual = listCreator.createList(FILE);
        Map<Integer, List<Double>> expected = expectedMap;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @AfterTest
    public void deleteData() {
        listCreator = null;
        expectedMap = null;
    }
}
