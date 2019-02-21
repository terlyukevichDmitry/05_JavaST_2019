package test.by.epam.task01.action;

import by.epam.task01.action.PyramidCalculator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for testing many different methods of PyramidCalculator class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCalculatorTest {
    /**
     * object for next things.
     */
    private PyramidCalculator pyramidCalculator;
    /**
     * object for next things.
     */
    private Pyramid pyramid;
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
     * constant.
     */
    private final double volume = 1920.0;
    /**
     * constant.
     */
    private final double six = 6.0;
    /**
     * constant.
     */
    private final double ratioVolume = 14.625;
    /**
     * constant.
     */
    private final double square = 1325.78;
    /**
     * constant.
     */
    private final double number = 0.01;
    /**
     * {@inheritDoc}
     * @return object with data for data_square_height_for_volume.
     */
    @DataProvider(name = "data_square_height_for_volume")
    public Object[][] createCorrectDataForVolume() {
        return
                new Object[][]{
                        {four, ten, new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }
                        }, volume}
                };
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_for_ratio_data.
     */
    @DataProvider(name = "data_for_ratio_data")
    public Object[][] createCorrectDataRatioVolume() {
        return
                new Object[][] {
                        {four, ten, six, new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }
                        }, ratioVolume}
                };
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_side")
    public Object[][] createCorrectSide() {
        return
                new Object[][]{
                        {new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }
                        }
                        }
                };
    }
    /**
     * {@inheritDoc}
     * @return object with data for data_square.
     */
    @DataProvider(name = "data_square")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {square, four, new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }
                        }
                        }
                };
    }
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initPyramidCalculator() {
        pyramidCalculator = new PyramidCalculator();
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_square")
    public void calculateSquareTest(final double trueSquare,
                                    final double angles,
                                    final List<Point> pointList) throws
            LengthCollectionPointException, PyramidException {
        pyramid = new Pyramid(pointList, angles, ten);
        double actual = pyramidCalculator.calculateSquare(pyramid);
        double expected = trueSquare;
        Assert.assertEquals(expected, actual, number);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script of the volume calculation",
            dataProvider = "data_square_height_for_volume")
    public void calculateVolumeTest(final double angles,
                                    final double height,
                                    final List<Point> pointList,
                                    final double expectedVolume) throws
            LengthCollectionPointException, PyramidException {
        pyramid = new Pyramid(pointList, angles, height);

        double actual = pyramidCalculator.calculateVolume(pyramid);
        double expected = expectedVolume;
        Assert.assertEquals(expected, actual, number);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script of the data ratio calculation",
            dataProvider = "data_for_ratio_data")
    public void calculateRatioVolumeTest(final double angles,
                                               final double height,
                                               final double heightPlane,
                                               final List<Point> pointList,
                                               final double volumeRatio) throws
            LengthCollectionPointException, PyramidException {
        pyramid = new Pyramid(pointList, angles, height);
        double actual = pyramidCalculator.calculateRatioVolume(
                pyramid, heightPlane);
        double expected = volumeRatio;
        Assert.assertEquals(expected, actual, number);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script of the side calculation",
            dataProvider = "data_side")
    public void calculateSideTest(final List<Point> pointList) throws
            LengthCollectionPointException, PyramidException {
        pyramid = new Pyramid(pointList, three, ten);
        pyramid.setPointList(pointList);
        double actual = pyramidCalculator.calculateSide(pyramid);
        final double expected = 24;
        Assert.assertEquals(expected, actual);
    }
    /**
     * @ for remove objects.
     */
    @AfterTest
    private void initPyramidCalculatorA() {
        pyramidCalculator = null;
        pyramid = null;
    }

}
