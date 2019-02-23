package test.by.epam.task01.recorder;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.recorder.Recorder;
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
public class RecorderTest {
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
    private final double fifteen = 15.0;
    /**
     * constant.
     */
    private final double six = 6.0;
    /**
     * constant.
     */
    private final double squareNew = 1035.70006743734587;
    /**
     * constant.
     */
    private final double volumeNew = 1805.0000000000002;
    /**
     * {@inheritDoc}
     * @return object with data for data_side.
     */
    @DataProvider(name = "data_calculate_square_volume")
    public Object[][] createCorrectSide()
            throws LengthCollectionPointException, PyramidException {
        return
                new Object[][]{
                        {squareNew, volumeNew,
                                new Pyramid(new ArrayList<Point>() {
                            {
                                add(new Point(three, six,
                                        one));
                                add(new Point(three, twentyFive,
                                        one));
                            }}, four, fifteen)
                        }
                };
    }
    /**
     * {@inheritDoc}.
     */
    @Test(description = "Positive script for calculate new square and volume.",
            dataProvider = "data_calculate_square_volume")
    public void calculateWithNewPyramid(final double trueSquare,
                                        final double trueVolume,
                                        final Pyramid pyramid)
            throws NullDataException, PyramidException {

        Recorder expected = new Recorder();
        expected.setVolume(trueSquare);
        expected.setSquare(trueVolume);
        expected.createSlotForNewPyramid(pyramid);
        double volumeNewPyramid = expected.getVolume();
        double squareNewPyramid = expected.getSquare();
        pyramid.notifyObservers();
        Recorder actual = new Recorder();
        actual.setSquare(squareNewPyramid);
        actual.setVolume(volumeNewPyramid);
        Assert.assertEquals(expected, actual);
    }
}
