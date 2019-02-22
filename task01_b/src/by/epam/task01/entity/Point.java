
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
public class Point implements GeometricFigure {
    /**
     * X coordinate in this project.
     */
    private double x;
    /**
     * Y coordinate in this project.
     */
    private double y;
    /**
     * Z coordinate in this project.
     */
    private double z;
    /**
     * It's constructor in this class with parameters.
     *
     * @param coordinateX for x
     * @param coordinateY for y
     * @param coordinateZ for z
     */
    public Point(final double coordinateX,
                 final double coordinateY, final double coordinateZ) {
        this.x = coordinateX;
        this.y = coordinateY;
        this.z = coordinateZ;
    }
    /**
     * We use this for get X coordinate beyond class.
     *
     * @return x coordinate.
     */
    public double getX() {
        return x;
    }
    /**
     * We use -//- for take data.
     *
     * @param coordinateX for x
     */
    public void setX(final double coordinateX) {
        this.x = coordinateX;
    }
    /**
     * We use this for get Y coordinate beyond class.
     *
     * @return y coordinate.
     */
    public double getY() {
        return y;
    }
    /**
     * We use -//- for take data.
     *
     * @param coordinateY for x
     */
    public void setY(final double coordinateY) {
        this.y = coordinateY;
    }
    /**
     * We use this for get Z coordinate beyond class.
     *
     * @return z coordinate.
     */
    public double getZ() {
        return z;
    }
    /**
     * We use -//- for take data.
     *
     * @param coordinateZ for z
     */
    public void setZ(final double coordinateZ) {
        this.z = coordinateZ;
    }
    /**
     * {@inheritDoc}
     * @return equals result
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
                && Double.compare(point.y, y) == 0
                && Double.compare(point.z, z) == 0;
    }
    /**
     * {@inheritDoc}
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
    /**
     * {@inheritDoc}
     *
     * @return string with this information
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
