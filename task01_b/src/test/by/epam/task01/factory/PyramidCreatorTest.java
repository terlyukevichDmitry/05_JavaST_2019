
package test.by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.factory.PyramidCreator;
import by.epam.task01.factory.Factory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for testing many different methods of
 * PyramidCreatorTest class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCreatorTest {

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
    private final double three = 3.0;
    /**
     * constant.
     */
    private final double twentyFive = 25.0;

    /**
     * {@inheritDoc}
     * @return object with data for data_for_create_pyramid.
     */
    @DataProvider(name = "data_for_create_pyramid")
    public Object[][] createCorrectData() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {four, ten, new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }
                        }, new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }}, four, ten)
                        }};
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_for_create_pyramid.
     */
    @DataProvider(name = "data_for_create_pyramid_negative")
    public Object[][] createCorrectDataA() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {four, ten, new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        one));
                                add(new Point(three, twentyFive,
                                        one));
                            }
                        }, new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        one));
                                add(new Point(three, twentyFive,
                                        one));
                            }}, four, ten)
                        }};
    }
    /**
     * {@inheritDoc}.
     */
    @Test(expectedExceptions = PyramidException.class,
            description = "Negative script for create pyramid.",
            dataProvider = "data_for_create_pyramid")
    public void createPyramidTest(final double angles,
                                final double height,
                                final List<Point> pointList,
                                final Pyramid expectedPyramid) throws
            LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        final double falseAngle = 2;
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, falseAngle, height);
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(expectedExceptions = PyramidException.class,
            description = "Negative script for create pyramid.",
            dataProvider = "data_for_create_pyramid")
    public void createPyramidTestNegative(final double angles,
                                final double height,
                                final List<Point> pointList,
                                final Pyramid expectedPyramid) throws
            LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, angles, height);
        actual.setHeight(0);
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(expectedExceptions = LengthCollectionPointException.class,
            description = "Negative script for create pyramid.",
            dataProvider = "data_for_create_pyramid")
    public void createPyramidTestNegativePoint(final double angles,
                                          final double height,
                                          final List<Point> pointList,
                                          final Pyramid expectedPyramid) throws
            LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, angles, height);
        actual.setPointList(new ArrayList<Point>() {
            {
                add(new Point(three, one,
                        1));
                add(new Point(three, twentyFive,
                        1));
                add(new Point(three, twentyFive,
                        1));
            }
        });
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(expectedExceptions = PyramidException.class,
            description = "Negative script for create pyramid.",
            dataProvider = "data_for_create_pyramid_negative")
    public void createPyramidTestNegativeEqualPoint(final double angles,
                                               final double height,
                                               final List<Point> pointList,
                                               final Pyramid expectedPyramid)
            throws LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, angles, height);
        actual.setPointList(new ArrayList<Point>() {
            {
                add(new Point(three, one,
                        one));
                add(new Point(three, one,
                        one));
            }
        });
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for create pyramid.",
            dataProvider = "data_for_create_pyramid")
    public void createPyramidTestNegativeHeight(final double angles,
                                          final double height,
                                          final List<Point> pointList,
                                          final Pyramid expectedPyramid) throws
            LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        Pyramid actual = ((PyramidCreator) pyramidFactory).createPyramid(
                pointList, angles, height);
        Pyramid expected = expectedPyramid;
        Assert.assertEquals(expected, actual);
    }

}
