
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
     * numberOfAngles in this class.
     */
    private double numberOfAngles;
    /**
     * height in this class.
     */
    private double height;
    /**
     * constructor for inicialize data.
     * @param points for this class.
     * @param angles for this class.
     * @param heightP for this class.
     */
    public Pyramid(final List<Point> points, final double angles,
                   final  double heightP) {
        this.pointList = points;
        this.numberOfAngles = angles;
        this.height = heightP;
    }
    /**
     * This readListOfString we use for read information of file.
     * @param index for
     * @return pointList.
     */
    public Point getPointList(final int index) {
        return pointList.get(index);
    }
    /**
     * @param list for pointList
     */
    public void setPointList(final List<Point> list) {
        this.pointList = list;
    }
    /**
     *@return number of angles in this pyramid.
     */
    public double getNumberOfAngles() {
        return numberOfAngles;
    }
    /**
     * @param angles for pointList
     */
    public void setNumberOfAngles(final double angles) {
        this.numberOfAngles = angles;
    }
    /**
     *@return height in this pyramid.
     */
    public double getHeight() {
        return height;
    }
    /**
     * @param heightP for this data.
     */
    public void setHeight(final double heightP) {
        this.height = heightP;
    }
    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "Pyramid{" + "pointList=" + pointList
                + ", numberOfAngles=" + numberOfAngles
                + ", height=" + height
                + ", apothem=" + '}';
    }
    /**
     * {@inheritDoc}
     * @param o Object.
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
        return Double.compare(pyramid.numberOfAngles, numberOfAngles) == 0
                && Double.compare(pyramid.height, height) == 0
                && Objects.equals(pointList, pyramid.pointList);
    }
    /**
     * {@inheritDoc}
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(pointList, numberOfAngles, height);
    }
}
