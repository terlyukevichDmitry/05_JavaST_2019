package test.by.epam.task01.repository.specification;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;
import by.epam.task01.repository.specification.SortByHeightAndAnglesSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortByHeightAndAnglesSpecificationTest {
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
                        {
                                new Pyramid(new ArrayList<Point>() {
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
                                }, ten, one),
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

    @Test(priority = 9, dataProvider = "data_sort_object_by_height_and_angles")
    public void specifiedTest(final Pyramid trueFirstPyramid,
                              final Pyramid trueSecondPyramid,
                              final Pyramid trueThirdPyramid,
                              final Pyramid firstPyramid,
                              final Pyramid secondPyramid,
                              final Pyramid thirdPyramid)
            throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(firstPyramid);
        repositorySingleton.addObject(secondPyramid);
        repositorySingleton.addObject(thirdPyramid);
        SortByHeightAndAnglesSpecification specification =
                new SortByHeightAndAnglesSpecification();
        List<Pyramid> actual = repositorySingleton.query(
                specification, 0);

        List<Pyramid> expected = new ArrayList<>();
        expected.add(trueFirstPyramid);
        expected.add(trueSecondPyramid);
        expected.add(trueThirdPyramid);
        Assert.assertEquals(expected, actual);
    }
}
