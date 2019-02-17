
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */

package by.epam.task01.entity;

import java.util.Objects;

/**
 * An public class for creating Point.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */

public class Point {
    /**
     * radius in this project.
     */
    private double x;
    /**
     * radius in this project.
     */
    private double y;
    /**
     * It's a first constructor in this class.
     *
     * @param cordiantX for x
     * @param cordiantY for y
     */
    public Point(final double cordiantX, final double cordiantY) {
        this.x = cordiantX;
        this.y = cordiantY;
    }
    /**
     * This readListOfString we use for read information of file.
     *
     * @return x cordinat.
     */
    public double getX() {
        return x;
    }
    /**
     * This readListOfString we use for read information of file.
     *
     * @param cordiantX for x
     */
    public void setX(final double cordiantX) {
        this.x = cordiantX;
    }
    /**
     * This readListOfString we use for read information of file.
     *
     * @return y cordinat.
     */
    public double getY() {
        return y;
    }
    /**
     * This readListOfString we use for read information of file.
     *
     * @param cordiantY for x
     */
    public void setY(final double cordiantY) {
        this.y = cordiantY;
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
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0
                && Double.compare(point.y, y) == 0;

    }
    /**
     * {@inheritDoc}
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    /**
     * {@inheritDoc}
     * @return string with this information
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
