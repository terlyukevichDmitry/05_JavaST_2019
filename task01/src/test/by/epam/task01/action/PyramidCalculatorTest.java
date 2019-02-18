
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package test.by.epam.task01.action;

import by.epam.task01.action.PyramidCalculator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class PyramidCalculatorTest {

    /**
     * pyramidCalculator.
     */
    private PyramidCalculator pyramidCalculator;
    /**
     * pyramid.
     */
    private Pyramid pyramid;

    /**
     * @return data.
     */
    @DataProvider(name = "data_square")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {1392.0, 4.0, 17, new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }}
                };
    }

    @DataProvider(name = "data_square_height_for_volume")
    public Object[][] createCorrectDataForVolume() {
        return
                new Object[][]{
                        {4.0, 10.0, new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }, 1920}
                };
    }

    @DataProvider(name = "data_dataRatioData")
    public Object[][] createCorrectDataRatioVolume() {
        return
                new Object[][] {
                        {4.0, 17.0, 10.0, 6.0, new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }, 14.625}
                };
    }

    @DataProvider(name = "data_side")
    public Object[][] createCorrectSide() {
        return
                new Object[][]{
                        {new ArrayList<Point>(){
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }}
                };
    }


    @BeforeTest
    public void initPyramidCalculator(){
        pyramidCalculator = new PyramidCalculator();
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_square")
    public void calculateSquareTest(final double trueSquare,
                                    final double angles,
                                    final double apothem,
                                    final List<Point> pointList) {
        pyramid = new Pyramid(pointList, angles, 0, apothem);
        double actual = pyramidCalculator.calculateSquare(pyramid);
        double expected = trueSquare;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_square_height_for_volume")
    public void calculateVolumeTest(final double angles,
                                    final double height,
                                    final List<Point> pointList,
                                    final double volume){
        pyramid.setHeight(height);
        pyramid.setNumberOfAngles(angles);
        pyramid.setPointList(pointList);

        double actual = pyramidCalculator.calculateVolume(pyramid);
        double expected = volume;
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_dataRatioData")
    public void calculateRatioVolumeTest(final double angles,
                                               final double apothem,
                                               final double height,
                                               final double heightPlane,
                                               final List<Point> pointList,
                                               final double volumeRatio) {
        pyramid = new Pyramid(pointList, angles, height, apothem);
        double actual = pyramidCalculator.calculateRatioVolume(
                pyramid, heightPlane);
        double expected = volumeRatio;
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test(description = "Positive script for the finding size",
            dataProvider = "data_side")
    public void calculateSideTest(final List<Point> pointList) {
        double actual = pyramidCalculator.calculateSide(pointList);
        final double expected = 24;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    private void initPyramidCalculatorA(){
        pyramidCalculator = null;
        pyramid = null;
    }

}
