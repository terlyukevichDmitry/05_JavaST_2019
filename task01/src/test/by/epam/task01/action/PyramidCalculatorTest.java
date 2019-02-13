package test.by.epam.task01.action;

import by.epam.task01.action.PyramidCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("CheckStyle")
public class PyramidCalculatorTest {

    private PyramidCalculator pyramidCalculator;

    @DataProvider(name = "input_x_y_z")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {new double[]{0, 0}, 0},
                        {new double[]{0, 0}, 0},
                        {new double[]{0, 0}, 0},
                        {new double[]{0, 0}, 0}
                };
    }


    @BeforeTest
    public void initPyramidCalculator(){
        pyramidCalculator = new PyramidCalculator();
    }

    @Test(description = "Positive script of the volume calculation",
            dataProvider = "input_x_y_z")
    public void calculateVolumeTest(final double[] heights, final double square){
        double actual = pyramidCalculator.calculateVolume(heights[0], heights[1]);
        double expected = square;
        Assert.assertEquals(expected, actual);
    }

}
