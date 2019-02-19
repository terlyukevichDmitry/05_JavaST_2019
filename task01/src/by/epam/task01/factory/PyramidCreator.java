
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

import java.util.List;

/**
 *An public class for create pyramid for decide this task.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PyramidCreator implements PyramidFactory {
    /**
     * {@inheritDoc}
     * @return Point object.
     */
    @Override
    public Pyramid createPyramid(final List<Point> pointList,
                                         final double angles,
                                         final double height) {
        return new Pyramid(pointList, angles, height);
    }
}

