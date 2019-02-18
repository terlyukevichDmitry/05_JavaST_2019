package test.by.epam.task01.parse;

import by.epam.task01.parser.ParseData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;

@SuppressWarnings("CheckStyle")
public class ParseDataTest {

    private ParseData parseData;

    private Map<Integer, List<Double>> expectedMap;

    @BeforeTest
    public void initParseData(){
        List<Double> doubleList = new ArrayList<>(Arrays.asList(3.0, 2.0, 2.0));
        parseData = new ParseData();
        expectedMap = new HashMap<>();
        expectedMap.put(0, doubleList);
    }

    @Test
    public void createMapTest() {
        Map<Integer, List<Double>> actual =
                parseData.createMap(Arrays.asList("3 2 2"));
        Map<Integer, List<Double>> expected = expectedMap;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    public void deleteParseData(){
        parseData = null;
        expectedMap = null;
    }
}
