package test.by.epam.task01.repository.specification;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;
import by.epam.task01.repository.specification.FindByIdSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("CheckStyle")
public class FindByIdSpecificationTest {
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
     * constant.
     */
    private final double checkLowerBorder = 0;
    /**
     * constant.
     */
    private final double checkUpperBorder = 1;
    /**
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_find_object_by_id")
    public Object[][] createCorrectData() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {checkLowerBorder, checkUpperBorder,
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(three, one,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }}, four, ten),
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(one, one,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }}, four, six),
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(one, two,
                                                zero));
                                        add(new Point(three, twentyFive,
                                                zero));
                                    }}, fifteen, six)
                        }
                };
    }

    @Test(priority = 1,dataProvider = "data_find_object_by_id")
    public void specifiedTest(final double lowerBorder,
                              final double upperBorder,
                              final Pyramid firstPyramid,
                              final Pyramid secondPyramid,
                              final Pyramid thirdPyramid)
            throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(firstPyramid);
        repositorySingleton.addObject(secondPyramid);
        repositorySingleton.addObject(thirdPyramid);
        FindByIdSpecification specification =
                new FindByIdSpecification(lowerBorder, upperBorder);
        List<Pyramid> actual = repositorySingleton.query(specification, 0);

        List<Pyramid> expected = new ArrayList<>();
        expected.add(firstPyramid);
        expected.add(secondPyramid);
        Assert.assertEquals(expected, actual);
    }
}
