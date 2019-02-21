package test.by.epam.task01.objectcreator;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.objectcreator.ObjectCreator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In this class we use for check create object.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ObjectCreatorTest {
    /**
     * object for create different object and for do methods.
     */
    private ObjectCreator objectCreator;
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
    private final double ten = 10.0;
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
     * {@inheritDoc}
     * @return object with data for data_square.
     */
    @DataProvider(name = "data_pyramid")
    public Object[][] createCorrectData()
            throws LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(three, one, zero));
                                add(new Point(three, twentyFive, zero));
                            }}, four, ten),
                                new ArrayList<>(Arrays.asList(
                                three, one, zero, three, twentyFive,
                                zero, four, ten)),
                                new ArrayList<Point>() {
                            {
                                add(new Point(three, one, zero));
                                add(new Point(three, twentyFive, zero));
                            }
                        }
                        }
                };
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_square.
     */
    @DataProvider(name = "data_point")
    public Object[][] createCorrectDataForPoint() {
        return
                new Object[][]{
                        {
                            new Point(three, one, zero), three, one, zero
                        }
                };
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_square.
     */
    @DataProvider(name = "data_list")
    public Object[][] createCorrectDataForList() {
        return
                new Object[][]{
                        {new ArrayList<Point>() {
                            {
                                add(new Point(three, one, zero));
                                add(new Point(three, twentyFive, zero));
                            }
                        }, new ArrayList<>(Arrays.asList(three, one, zero,
                                    three, twentyFive, zero, four, ten))
                        }
                };
    }
    /**
     * {@inheritDoc}
     */
    @BeforeTest
    public void createData() {
        objectCreator = new ObjectCreator();
    }
    /**
     * {@inheritDoc}.
     */
    @Test(dataProvider = "data_pyramid")
    public void pyramidCreatorTest(final Pyramid pyramid,
                                   final List<Double> doubleList,
                                   final List<Point> pointList)
            throws LengthCollectionPointException, PyramidException {
        Pyramid actual = objectCreator.pyramidCreator(pointList, doubleList);
        Pyramid expected = pyramid;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(dataProvider = "data_point")
    public void pointCreatorTest(final Point point,
                                 final double coordinateX,
                                 final double coordinateY,
                                 final double coordinateZ) {
        Point actual = objectCreator.pointCreator(coordinateX,
                coordinateY, coordinateZ);
        Point expected = point;
        Assert.assertEquals(actual, expected);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(dataProvider = "data_list")
    public void listCreatorTest(final List<Point> pointList,
                                final List<Double> doubleList) {
        List<Point> actual = objectCreator.listCreator(doubleList);
        List<Point> expected = pointList;
        Assert.assertEquals(expected, actual);
    }
    /**
     * @ for remove data.
     */
    @AfterTest
    public void removeData() {
        objectCreator = null;
    }
}
