package test.by.epam.task01.parse;

import by.epam.task01.parser.ParseData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *An public class for testing many different methods of ParseData class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ParseDataTest {
    /**
     * Parsedata for create object.
     */
    private ParseData parseData;
    /**
     * expectedMap for create Map.
     */
    private Map<Integer, List<Double>> expectedMap;
    /**
     * constant.
     */
    private final double two = 2.0;
    /**
     * constant.
     */
    private final double three = 3.0;
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initParseData() {
        List<Double> doubleList = new ArrayList<>(Arrays.asList(three,
                two, two));
        parseData = new ParseData();
        expectedMap = new HashMap<>();
        expectedMap.put(0, doubleList);
    }
    /**
     * {@inheritDoc}.
     */
    @Test
    public void createMapTest() {
        Map<Integer, List<Double>> actual =
                parseData.createMap(Arrays.asList("3 2 2"));
        Map<Integer, List<Double>> expected = expectedMap;
        Assert.assertEquals(expected, actual);
    }
    /**
     * @ for remove objects.
     */
    @AfterTest
    public void deleteParseData() {
        parseData = null;
        expectedMap = null;
    }
}
