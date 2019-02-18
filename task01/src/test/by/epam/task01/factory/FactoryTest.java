package test.by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.factory.PointFactory;
import by.epam.task01.factory.PyramidFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class FactoryTest {

    private PointFactory pointFactory;
    private PyramidFactory pyramidFactory;

    @DataProvider(name = "data_for_point")
    public Object[][] createCorrectDataPoint() {
        return
                new Object[][]{
                        { new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }, new ArrayList<>(Arrays.asList(3.0,
                                1.0, 3.0, 25.0, 4.0, 10.0, 17.0))
                }};
    }

    @DataProvider(name = "data_for_pyramid")
    public Object[][] createCorrectDataPyramid() {
        return
                new Object[][]{
                        {new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }}, 4, 10, 17),
                                new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }, new ArrayList<>(Arrays.asList(3.0,
                                1.0, 3.0, 25.0, 4.0, 10.0, 17.0))
                        }};
    }

    @BeforeTest
    public void initData() {
        pointFactory = new PointFactory();
        pyramidFactory = new PyramidFactory();
    }

    @Test(description = "Positive script",
            dataProvider = "data_for_point")
    public void createPointsTest(final List<Point> pointList,
                                 final List<Double> doubleList) {

        List<Point> actual = pointFactory.createPoints(doubleList);
        List<Point> expected = pointList;
        Assert.assertEquals(expected.get(0), actual.get(0));
    }

    @Test(description = "Positive script",
            dataProvider = "data_for_pyramid")
    public void createPyramidTest(final Pyramid expectedPyramid,
                                  final List<Point> pointList,
                                  final List<Double> doubleList) {
        Pyramid actual = pyramidFactory.createPyramid(pointList,
                doubleList);
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    public void deleteData() {
        pointFactory = null;
        pyramidFactory = null;
    }



}
