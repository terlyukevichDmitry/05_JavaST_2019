
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

/**
 * Public class for create Point.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PointCreator implements PointFactory {
    /**
     * Create Point.
     * {@inheritDoc}
     * @return Point object.
     */
    @Override
    public Point createPoint(final double coordinateX,
                                       final double coordinateY,
                                       final double coordinateZ) {
        return new Point(coordinateX, coordinateY, coordinateZ);
    }
}
