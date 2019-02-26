package test.by.epam.task01.repository.specification;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;
import by.epam.task01.repository.specification.SortByVolumeSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we use for check true works methods(sort) in this class.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortByVolumeSpecificationTest {
    /**
     * constant.
     */
    private final double one = 1.0;
    /**
     * constant.
     */
    private final int two = 2;
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
    private final int tenthPriority = 10;
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
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_sort_object_by_height_and_angles")
    public Object[][] createCorrectData() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(one, one,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }
                                }, four, three),
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(one, two,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }
                                }, fifteen, six),
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(one, two,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }
                                }, ten, one)
                        }
                };
    }
    /**
     * Use for check true work sort method.
     * {@inheritDoc}
     */
    @Test(priority = tenthPriority, dataProvider =
            "data_sort_object_by_height_and_angles")
    public void specifiedTest(final Pyramid firstPyramid,
                              final Pyramid secondPyramid,
                              final Pyramid thirdPyramid)
            throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(firstPyramid);
        repositorySingleton.addObject(secondPyramid);
        repositorySingleton.addObject(thirdPyramid);
        SortByVolumeSpecification specification =
                new SortByVolumeSpecification();
        List<Pyramid> actual = repositorySingleton.query(
                specification, 0);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(firstPyramid);
        expected.add(thirdPyramid);
        expected.add(secondPyramid);
        Assert.assertEquals(expected, actual);
    }
}
