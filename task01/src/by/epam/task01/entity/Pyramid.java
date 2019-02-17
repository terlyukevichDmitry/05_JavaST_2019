
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

@SuppressWarnings("CheckStyle")
public class Pyramid {
    /**
     * pointList in this class.
     */
    private List<Point> pointList;
    /**
     * numberOfAngles in this class.
     */
    private double numberOfAngles;

    private double height;

    private double apothem;

    public double getApothem() {
        return apothem;
    }

    public void setApothem(double apothem) {
        this.apothem = apothem;
    }

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

    public double getNumberOfAngles() {
        return numberOfAngles;
    }

    public void setNumberOfAngles(double numberOfAngles) {
        this.numberOfAngles = numberOfAngles;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pointList=" + pointList +
                ", numberOfAngles=" + numberOfAngles +
                ", height=" + height +
                ", apothem=" + apothem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pyramid pyramid = (Pyramid) o;
        return Double.compare(pyramid.numberOfAngles, numberOfAngles) == 0 &&
                Double.compare(pyramid.height, height) == 0 &&
                Double.compare(pyramid.apothem, apothem) == 0 &&
                Objects.equals(pointList, pyramid.pointList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointList, numberOfAngles, height, apothem);
    }

}
