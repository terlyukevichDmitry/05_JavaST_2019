package test.by.epam.task01.validator;

import by.epam.task01.validator.DataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *An public class for testing many different methods of PyramidCalculator class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class DataValidatorTest {

    /**
     * object for next things.
     */
    private DataValidator dataValidator;
    /**
     * doubleList for validate data.
     */
    private List<Double> doubleList;
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
    private final double zero = 0.0;
    /**
     * constant.
     */
    private final double six = 6.0;
    /**
     * {@inheritDoc}.
     */
    @BeforeTest
    public void initData() {
        doubleList = new ArrayList<>(Arrays.asList(three, one, zero, three,
                twentyFive, zero, four, ten, six));
        dataValidator = new DataValidator(doubleList);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check height")
    public void checkingHeightTest() {
        boolean actual = dataValidator.checkingHeight();
        Assert.assertEquals(true, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check heightNewPyramid")
    public void checkingHeightNewPyramidTest() {
        boolean actual = dataValidator.checkingHeightNewPyramid();
        Assert.assertEquals(true, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check heightNewPyramid")
    public void checkingHeightComparisonTest() {
        boolean actual = dataValidator.checkingHeightComparison();
        Assert.assertEquals(true, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check this method.")
    public void checkingPointMatchTest() {
        boolean actual = dataValidator.checkingPointMatch();
        Assert.assertEquals(true, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check number of angels.")
    public void checkingAnglesTest() {
        boolean actual = dataValidator.checkingAngles();
        Assert.assertEquals(true, actual);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check equals parameter of z.")
    public void checkingEqualsZParameter() {
        boolean actual = dataValidator.checkingEqualsZParameter();
        Assert.assertEquals(true, actual);
    }
    /**
     * @ for remove objects.
     */
    @AfterTest
    public void deleteData() {
        dataValidator = null;
        doubleList = null;
    }

}
