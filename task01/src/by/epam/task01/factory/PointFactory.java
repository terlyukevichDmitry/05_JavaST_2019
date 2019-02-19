
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
public interface PointFactory extends Factory<PointFactory> {
    /**
     * It's a main constructor in this class.
     * @param coordinateX for createPoint
     * @param coordinateY for createPoint
     * @param coordinateZ for createPoint
     * @return Point p
     */
     Point createPoint(double coordinateX, double coordinateY,
                             double coordinateZ);
}
