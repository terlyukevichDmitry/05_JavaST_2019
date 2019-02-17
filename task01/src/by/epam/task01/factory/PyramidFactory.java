
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
@SuppressWarnings("CheckStyle")
public class PyramidFactory {

    /**
     * This readListOfString we use for read information of file.
     * @param pointList to fill in the data.
     * @param doubleList for.
     * @return List<String> with component for solutions this task.
     */
    public Pyramid createPyramid(final List<Point> pointList,
                                 final List<Double> doubleList) {

        double numberOfAngels = doubleList.get(4);
        double height = doubleList.get(5);
        double apothem = doubleList.get(6);

        Pyramid pyramid = new Pyramid();
        pyramid.setPointList(pointList);
        pyramid.setNumberOfAngles(numberOfAngels);
        pyramid.setHeight(height);
        pyramid.setApothem(apothem);
        return pyramid;
    }
}
