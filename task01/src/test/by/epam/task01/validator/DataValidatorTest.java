
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package test.by.epam.task01.validator;

import by.epam.task01.validator.DataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class DataValidatorTest {

    private DataValidator dataValidator;
    private List<Double> doubleList;

    @BeforeTest
    public void initData() {
        doubleList = new ArrayList<>(Arrays.asList(3.0, 1.0, 0.0, 3.0, 25.0,
                0.0, 4.0, 10.0, 6.0));
        dataValidator = new DataValidator(doubleList);
    }

    @Test(description = "Positive script for check height")
    public void checkingHeightTest() {
        boolean actual = dataValidator.checkingHeight();
        Assert.assertEquals(true, actual);
    }

    @Test(description = "Positive script for check heightNewPyramid")
    public void checkingHeightNewPyramidTest() {
        boolean actual = dataValidator.checkingHeightNewPyramid();
        Assert.assertEquals(true, actual);
    }

    @Test(description = "Positive script for check heightNewPyramid")
    public void checkingHeightComparisonTest() {
        boolean actual = dataValidator.checkingHeightComparison();
        Assert.assertEquals(true, actual);
    }

    @Test(description = "Positive script for check this method.")
    public void checkingPointMatchTest() {
        boolean actual = dataValidator.checkingPointMatch();
        Assert.assertEquals(true, actual);
    }

    @Test(description = "Positive script for check number of angels.")
    public void checkingAnglesTest() {
        boolean actual = dataValidator.checkingAngles();
        Assert.assertEquals(true, actual);
    }

    @Test(description = "Positive script for check equals parameter of z.")
    public void checkingEqualsZParameter() {
        boolean actual = dataValidator.checkingEqualsZParameter();
        Assert.assertEquals(true, actual);
    }

    @AfterTest
    public void deleteData(){
        dataValidator = null;
        doubleList = null;
    }

}
