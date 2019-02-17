package test.by.epam.task01.validator;

import by.epam.task01.validator.DataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class DataValidatorTest {

    private DataValidator dataValidator;
    private List<Double> doubleList;

    @DataProvider(name
            = "data_for_apothem_height")
    public Object[][] createCorrectData() {
        return
                new Object[][]{
                        {new double[]{24.0, 8.0, 4.0, 3.0}}
                };
    }

    @BeforeTest
    public void initData() {
        doubleList = new ArrayList<Double>(Arrays.asList(1.0, 1.0, 4.0, 1.0, 4.0, 4.0, 5.0, 2.0));
        dataValidator = new DataValidator(doubleList);
    }

    @Test(description = "Positive script for checking apothem")
    public void checkingApothemTest() {
        boolean actual = dataValidator.checkingApothem();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for checking height")
    public void checkingHeightTest() {
        boolean actual = dataValidator.checkingHeight();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for checking heightNewPyramid")
    public void checkingHeightNewPyramidTest() {
        boolean actual = dataValidator.checkingHeightNewPyramid();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for checking heightNewPyramid")
    public void checkingHeightComparisonTest() {
        boolean actual = dataValidator.checkingHeightComparison();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for checking this method.")
    public void checkingPointMatchTest() {
        boolean actual = dataValidator.checkingPointMatch();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for checking number of angels.")
    public void checkingAnglesTest() {
        boolean actual = dataValidator.checkingAngles();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test(description = "Positive script for this method",
            dataProvider = "data_for_apothem_height")
    public void checkingApothemDoesMatchHeightTest(final double[] numbers) {
        boolean actual =
                dataValidator.checkingApothemDoesMatchHeight(numbers[0],
                        numbers[1], numbers[2], numbers[3]);
        System.out.println(actual);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @AfterTest
    public void deleteData(){
        dataValidator = null;
    }

}