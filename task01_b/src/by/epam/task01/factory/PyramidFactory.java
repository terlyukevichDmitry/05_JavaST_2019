
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.factory;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;

import java.util.List;

/**
 * Public interface for create Pyramid.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public interface PyramidFactory extends Factory<Pyramid> {
    /**
     * Method for create Pyramid.
     * @param pointList for create pyramid.
     * @param angles for create pyramid.
     * @param height for create pyramid.
     * @throws LengthCollectionPointException for check length point.
     * @throws PyramidException for check not correct data.
     * @return Pyramid p
     */
    Pyramid createPyramid(List<Point> pointList,
                                  double angles,
                                  double height) throws
            LengthCollectionPointException, PyramidException;
}
