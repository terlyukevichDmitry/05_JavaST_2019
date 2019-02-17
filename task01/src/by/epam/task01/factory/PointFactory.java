
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

import java.util.ArrayList;
import java.util.List;

/**
 *An public class for create points for decide this task.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PointFactory {

    /**
     * coefficient for create pointList.
     */
    private final int coefficient = 4;
    /**
     * This readListOfString we use for read information of file.
     * @param list for create List<Point>.
     * @return List<String> with component for solutions this task.
     */
    public List<Point> createPoints(final List<Double> list) {
        List<Point> pointList = new ArrayList<>();
        int counter = -1;
        for (int i = 0; i < list.size() / coefficient; i++) {
            pointList.add(new Point(list.get(++counter), list.get(++counter)));
        }
        return pointList;
    }
}
