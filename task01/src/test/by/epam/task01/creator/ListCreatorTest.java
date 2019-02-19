package test.by.epam.task01.creator;

import by.epam.task01.creator.ListCreator;
import by.epam.task01.exception.MissingWayFileException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.*;

@SuppressWarnings("CheckStyle")
public class ListCreatorTest {

    private ListCreator listCreator;

    private static final String FILE = "data" + File.separator + "test.txt";

    private Map<Integer, List<Double>> expectedMap;

    @BeforeTest
    public void initData() {
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.0, 1.0, 0.0,
                4.0 , 1.0, 0.0, 4.0, 5.0, 2.0));
        listCreator = new ListCreator();
        expectedMap = new HashMap<>();
        expectedMap.put(0, doubleList);
    }

    @Test(description = "Positive script of the square calculation")
    public void createListTest() throws MissingWayFileException {
        Map<Integer, List<Double>> actual = listCreator.createList(FILE);
        Map<Integer, List<Double>> expected = expectedMap;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    public void deleteData() {
        listCreator = null;
        expectedMap = null;
    }



}
