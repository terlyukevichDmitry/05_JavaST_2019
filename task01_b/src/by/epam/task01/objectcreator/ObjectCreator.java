package by.epam.task01.objectcreator;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.factory.Factory;
import by.epam.task01.factory.PointCreator;
import by.epam.task01.factory.PyramidCreator;
import by.epam.task01.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we use for create object.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ObjectCreator {
    /**
     * constant.
     */
    private final int two = 2;
    /**
     * constant.
     */
    private final int six = 6;
    /**
     * constant.
     */
    private final int seven = 7;

    /**
     *DIGIT_PATTEN_FOR_SPLIT for split array.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ObjectCreator.class);
    /**
     * Method for create pyramid objects.
     * @param pointList for create pyramid.
     * @param doubleList for create pyramid.
     * @return pyramid.
     * @throws LengthCollectionPointException for check data.
     * @throws PyramidException for check data.
     */
    public Pyramid pyramidCreator(final List<Point> pointList,
                                  final List<Double> doubleList)
            throws LengthCollectionPointException, PyramidException {
        Factory<Pyramid> pyramidFactory = new PyramidCreator();
        Pyramid pyramid = null;
        DataValidator dataValidator = new DataValidator(doubleList);
        if (dataValidator.checkingHeight()
                && dataValidator.checkingHeightComparison()
                && dataValidator.checkingAngles()
                && dataValidator.checkingPointMatch()) {
            pyramid = ((PyramidCreator) pyramidFactory).createPyramid(
                    pointList, doubleList.get(six), doubleList.get(seven));
        } else {
            LOGGER.warn("We have not correct data for create pyramid.");
            throw new PyramidException();
        }
        return pyramid;
    }
    /**
     * Method for create point objects.
     * @param coordinateX for x.
     * @param coordinateY for y.
     * @param coordinateZ for z.
     * @return point
     */
    public Point pointCreator(final double coordinateX,
                              final double coordinateY,
                              final double coordinateZ) {
        Factory<Point> pointFactory = new PointCreator();
        Point point = ((PointCreator) pointFactory).createPoint(
                coordinateX, coordinateY, coordinateZ);
        return point;
    }
    /**
     * This method we use for create list.
     * @param doubleList for create list with points.
     * @return points.
     */
    public List<Point> listCreator(final List<Double> doubleList) {
        List<Point> points = new ArrayList<>();
        int counter = -1;
        for (int i = 0; i < two; i++) {
            points.add(pointCreator(doubleList.get(++counter),
                    doubleList.get(++counter),
                    doubleList.get(++counter)));
        }
        return points;
    }
}
