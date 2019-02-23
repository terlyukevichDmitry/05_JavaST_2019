package test.by.epam.task01.repository;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 *An public class for testing many different methods of
 * RecorderTest class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class RepositorySingletonTest {

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
    private final double number = 0.1;
    /**
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_add_object")
    public Object[][] createCorrectSide() throws
            LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {
                            new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(three, one,
                                        0));
                                add(new Point(three, twentyFive,
                                        0));
                            }}, four, ten),
                                new Pyramid(new ArrayList<Point>() {
                                    {
                                        add(new Point(three, one,
                                                0));
                                        add(new Point(three, twentyFive,
                                                0));
                                    }}, six, fifteen)
                        }
                };
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check addObject method.",
    dataProvider = "data_add_object")
    public void addObjectTest(final Pyramid pyramidOne,
                              final Pyramid pyramid) throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(pyramid);
        repositorySingleton.addObject(pyramidOne);
        Assert.assertEquals(repositorySingleton.getRecorderList().size(), two);
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for check addObject method.",
            dataProvider = "data_add_object")
    public void removeObjectTest(final Pyramid pyramidOne,
                              final Pyramid pyramid) throws NullDataException {
        RepositorySingleton repositorySingleton = new RepositorySingleton();
        repositorySingleton.addObject(pyramid);
        repositorySingleton.addObject(pyramidOne);
        repositorySingleton.removeObject(pyramid);
        Assert.assertEquals(repositorySingleton.getRecorderList().size(), one,
                number);
    }
}
