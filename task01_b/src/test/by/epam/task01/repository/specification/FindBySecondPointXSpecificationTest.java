package test.by.epam.task01.repository.specification;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;
import by.epam.task01.repository.specification.FindBySecondPointXSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we use for check true works methods for finding data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class FindBySecondPointXSpecificationTest {
    /**
     * constant.
     */
    private final double one = 1.0;
    /**
     * constant.
     */
    private final int fivePriority = 5;
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
    private final double fifteen = 15.0;
    /**
     * constant.
     */
    private final double six = 6.0;
    /**
     * constant.
     */
    private final double zero = 0.0;
    /**
     * constant.
     */
    private final double checkLowerBorder = 18;
    /**
     * constant.
     */
    private final double checkUpperBorder = 25;
    /**
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_find_object_by_second_point_x")
    public Object[][] createCorrectSide() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {checkLowerBorder, checkUpperBorder,
                                new Pyramid(new ArrayList<>() {
                                    {
                                        add(new Point(three, one,
                                                zero));
                                        add(new Point(fifteen, fifteen,
                                                zero));
                                    }}, six, fifteen),
                                new Pyramid(new ArrayList<>() {
                                    {
                                        add(new Point(one, one,
                                                zero));
                                        add(new Point(twentyFive, one,
                                                zero));
                                    }}, four, ten)
                        }
                };
    }
    /**
     * {@inheritDoc}
     */
    @Test(priority = fivePriority, dataProvider =
            "data_find_object_by_second_point_x")
    public void specifiedTest(final double lowerBorder,
                              final double upperBorder,
                              final Pyramid firstPyramid,
                              final Pyramid secondPyramid)
            throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(firstPyramid);
        repositorySingleton.addObject(secondPyramid);
        FindBySecondPointXSpecification findPointX =
                new FindBySecondPointXSpecification(lowerBorder, upperBorder);

        List<Pyramid> actual = repositorySingleton.query(findPointX, 1);

        List<Pyramid> expected = new ArrayList<>();
        expected.add(secondPyramid);
        Assert.assertEquals(expected, actual);
    }
}
