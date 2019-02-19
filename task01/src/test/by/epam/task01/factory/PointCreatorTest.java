package test.by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.factory.Factory;
import by.epam.task01.factory.PointCreator;
import by.epam.task01.factory.PointFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("CheckStyle")
public class PointCreatorTest {

    private Factory<PointFactory> pointFactory;

    @DataProvider(name = "data_for_create_point")
    public Object[][] createCorrectDataPoint() {
        return
                new Object[][]{
                        {1, 2, 0,
                                new Point(1,2,0)
                        }};
    }

    @Test(description = "Positive script",
            dataProvider = "data_for_create_point")
    public void createPointTest(final double coordinateX,
                                final double coordinateY,
                                final double coordinateZ,
                                final Point expectedPoint) {
        pointFactory = new PointCreator();
        Point actual = ((PointCreator) pointFactory).createPoint(coordinateX,
                coordinateY,
                coordinateZ);
        Point expected = expectedPoint;
        Assert.assertEquals(expected, actual);
    }


}
