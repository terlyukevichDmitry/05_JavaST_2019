package test.by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.factory.PyramidCreator;
import by.epam.task01.factory.PyramidFactory;
import by.epam.task01.factory.Factory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class PyramidCreatorTest {

    private Factory<PyramidFactory> pyramidFactory;

    @DataProvider(name = "data_for_create_pyramid")
    public Object[][] createCorrectDataPoint() {
        return
                new Object[][]{
                        {4, 10, new ArrayList<Point>() {
                            {
                                add(new Point(3, 1,
                                        0));
                                add(new Point(3, 25,
                                        0));
                            }
                        }, new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(3, 1,
                                        0));
                                add(new Point(3, 25,
                                        0));
                            }}, 4, 10)
                        }};
    }

    @Test(description = "Positive script",
            dataProvider = "data_for_create_pyramid")
    public void createPointTest(final double angles,
                                final double height,
                                final List<Point> pointList,
                                final Pyramid expectedPyramid) {
        pyramidFactory = new PyramidCreator();
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, angles, height);
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }
}
