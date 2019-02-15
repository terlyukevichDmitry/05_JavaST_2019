
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */

package by.epam.task01.entity;

import java.util.List;
import java.util.Objects;

/**
 * An public class for Pyramid.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */

public class Pyramid {
    /**
     * pointList in this class.
     */
    private List<Point> pointList;

    /**
     * This readListOfString we use for read information of file.
     *
     * @return pointList.
     */
    public List<Point> getPointList() {
        return pointList;
    }

    /**
     * This readListOfString we use for read information of file.
     *
     * @param list for pointList
     */
    public void setPointList(final List<Point> list) {
        this.pointList = list;
    }

    /**
     * {@inheritDoc}
     * @return true or false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) o;
        return Objects.equals(pointList, pyramid.pointList);
    }

    /**
     * {@inheritDoc}
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(pointList);
    }

    /**
     * {@inheritDoc}
     * @return string
     */
    @Override
    public String toString() {
        return "Pyramid{"
                +  "pointList=" + pointList
                + '}';
    }

}
