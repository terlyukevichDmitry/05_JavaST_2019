
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
     * list with point data in this class.
     */
    private List<Point> pointList;
    /**
     * numberOfAngles in this class for our pyramid.
     */
    private double numberOfAngles;
    /**
     * height in this class for our pyramid.
     */
    private double height;
    /**
     * constructor for initialization data.
     * @param points for this object.
     * @param angles for this object.
     * @param heightP for this object.
     */
    public Pyramid(final List<Point> points, final double angles,
                   final  double heightP) {
        this.pointList = points;
        this.numberOfAngles = angles;
        this.height = heightP;
    }
    /**
     * We use this method for get necessary point beyond class.
     * @param index to choose necessary point.
     * @return necessary point.
     */
    public Point getPointList(final int index) {
        return pointList.get(index);
    }
    /**
     * We use -//- for take data.
     *
     * @param list for take pointList.
     */
    public void setPointList(final List<Point> list) {
        this.pointList = list;
    }
    /**
     * We use this method for get number of angles beyond class.
     * @return angles.
     */
    public double getNumberOfAngles() {
        return numberOfAngles;
    }
    /**
     * We use -//- for take data.
     *
     * @param angles for take number of point.
     */
    public void setNumberOfAngles(final double angles) {
        this.numberOfAngles = angles;
    }
    /**
     * We use this method for get height this pyramid beyond class.
     * @return height.
     */
    public double getHeight() {
        return height;
    }
    /**
     * We use -//- for take data.
     *
     * @param heightP for take height for this object.
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
                + ", height=" + height + '}';
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
