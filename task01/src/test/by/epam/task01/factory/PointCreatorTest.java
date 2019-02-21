package test.by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.factory.Factory;
import by.epam.task01.factory.PointCreator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *An public class for testing many different methods of
 * PointCreatorTest class.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PointCreatorTest {
    /**
     * constant.
     */
    private final double one = 1.0;
    /**
     * constant.
     */
    private final double two = 2.0;
    /**
     * constant.
     */
    private final double zero = 0.0;
    /**
     * {@inheritDoc}
     * @return object with data for data_for_create_point.
     */
    @DataProvider(name = "data_for_create_point")
    public Object[][] createCorrectDataPoint() {
        return
                new Object[][]{
                        {1, 2, 0,
                                new Point(one, two, zero)
                        }};
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for create point.",
            dataProvider = "data_for_create_point")
    public void createPointTest(final double coordinateX,
                                final double coordinateY,
                                final double coordinateZ,
                                final Point expectedPoint) {
        Factory<Point> pointFactory = new PointCreator();
        Point actual = ((PointCreator) pointFactory).createPoint(coordinateX,
                coordinateY,
                coordinateZ);
        Point expected = expectedPoint;
        Assert.assertEquals(expected, actual);
    }
}
