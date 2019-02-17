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

    private PyramidCalculator pyramidCalculator;
    private Pyramid pyramid;

    @DataProvider(name = "data_square")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {1392.0, 4.0, 17, new ArrayList<Point>(){
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
                        {new double[]{39.0, 4.0},
                                52.0}
                };
    }

    @DataProvider(name = "data_VolumeTruncatedPyramid")
    public Object[][] createCorrectDataVolumeTruncatedPyramid() {
        return
                new Object[][] {
                        {4.0, 17.0, 10.0, 6.0, new ArrayList<Point>() {
                            {
                                add(new Point(3 ,1));
                                add(new Point(3 ,25));
                            }
                        }, 1505.2800000000002}
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
        pyramid = new Pyramid();
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_square")
    public void calculateSquareTest(final double trueSquare,
                                    final double angles,
                                    final double apothem,
                                    final List<Point> pointList) {
        pyramid.setPointList(pointList);
        pyramid.setNumberOfAngles(angles);
        pyramid.setApothem(apothem);
        double actual = pyramidCalculator.calculateSquare(pyramid);
        double expected = trueSquare;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_square_height_for_volume")
    public void calculateVolumeTest(final double[] data, final double volume){
        double actual = pyramidCalculator.calculateVolume(data[0], data[1]);
        double expected = volume;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script of the square calculation",
            dataProvider = "data_VolumeTruncatedPyramid")
    public void calcVolumeTruncatedPyramidTest(final double angles,
                                               final double apothem,
                                               final double height,
                                               final double heightForNewPyr,
                                               final List<Point> pointList,
                                               final double volume) {
        pyramid.setPointList(pointList);
        pyramid.setNumberOfAngles(angles);
        pyramid.setApothem(apothem);
        pyramid.setHeight(height);

        double actual = pyramidCalculator.calculateVolumeTruncatedPyramid(
                pyramid, heightForNewPyr);
        double expected = volume;
        Assert.assertEquals(expected, actual);
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
