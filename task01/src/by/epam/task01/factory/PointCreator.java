
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
 *An public class for create points for decide this task.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PointCreator implements PointFactory {
    /**
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
