
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
 * Public class for create Pyramid.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PyramidCreator implements PyramidFactory {
    /**
     * Create pyramid.
     * {@inheritDoc}
     * @throws LengthCollectionPointException for check not correct length.
     * @throws PyramidException for check not correct data.
     * @return Point object.
     */
    @Override
    public Pyramid createPyramid(final List<Point> pointList,
                                         final double angles,
                                         final double height) throws
            LengthCollectionPointException, PyramidException {
        return new Pyramid(pointList, angles, height);
    }
}

