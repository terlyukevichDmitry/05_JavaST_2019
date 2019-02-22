
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */
package by.epam.task01.entity;

import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.recorder.Observable;
import by.epam.task01.recorder.Observer;
import by.epam.task01.validator.ListFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An public class for Pyramid.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class Pyramid implements GeometricFigure, Observable {
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
     *Logger for show information.
     */
    private static final Logger LOGGER = LogManager.getLogger(ListFilter.class);
    /**
     *List<Observer> for observer pattern.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * constructor for initialization data.
     * @param points for this object.
     * @param angles for this object.
     * @param heightP for this object.
     * @throws PyramidException for check data problem.
     * @throws LengthCollectionPointException for check point problem.
     */
    public Pyramid(final List<Point> points, final double angles,
                   final  double heightP) throws
            LengthCollectionPointException, PyramidException {
        this.pointList = points;
        if (pointList.size() != 2) {
            throw new LengthCollectionPointException(""
                    + "We have not 2 points, check number of points in your"
                    + " collection");

        }
        if ((Double.compare(pointList.get(0).getX(),
                pointList.get(1).getX()) == 0
                && Double.compare(pointList.get(0).getY(),
                pointList.get(1).getY()) == 0
                && Double.compare(pointList.get(0).getZ(),
                pointList.get(1).getZ()) == 0)) {
            LOGGER.error("We have equal points.");
            throw new PyramidException("We have equal points.");
        }
        this.numberOfAngles = angles;
        if (numberOfAngles <= 2) {
            LOGGER.error("We have what angles <= 2.");
            throw new PyramidException("We have what angles <= 2.");
        }
        this.height = heightP;
        if (height == 0) {
            LOGGER.error("We have what height == 0.");
            throw new PyramidException("We have what height == 0.");
        }
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
     * @throws LengthCollectionPointException for check length point.
     * @throws PyramidException for check not correct data.
     * @param list for take pointList.
     */
    public void setPointList(final List<Point> list) throws
            LengthCollectionPointException, PyramidException {
        this.pointList = list;
        if (pointList.size() != 2) {
            LOGGER.error(""
                    + "We have not 2 points, check number of points in your "
                    + "collection");
            throw new LengthCollectionPointException(""
                    + "We have not 2 points, check number of points in your "
                    + "collection");

        }
        if (Double.compare(pointList.get(0).getX(),
                pointList.get(1).getX()) == 0
                && Double.compare(pointList.get(0).getY(),
                pointList.get(1).getY()) == 0
                && Double.compare(pointList.get(0).getZ(),
                pointList.get(1).getZ()) == 0) {
            LOGGER.error("We have equal points");
            throw new PyramidException("We have equal points");
        }
        if (Double.compare(pointList.get(0).getZ(),
                pointList.get(0).getZ()) != 0) {
            LOGGER.error("Not parallel to the coordinate plane");
            throw new PyramidException("Not parallel to the coordinate plane");
        }
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
     * @throws PyramidException for check not correct data.
     * @param angles for take number of point.
     */
    public void setNumberOfAngles(final double angles) throws PyramidException {
        this.numberOfAngles = angles;
        if (numberOfAngles <= 2) {
            LOGGER.error("We have what angles <= 2");
            throw new PyramidException("We have what angles <= 2");
        }
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
     * @throws PyramidException for check not correct data.
     * @param heightP for take height for this object.
     */
    public void setHeight(final double heightP) throws PyramidException {
        this.height = heightP;
        if (height == 0) {
            LOGGER.error("We have what height == 0");
            throw new PyramidException("We have what height == 0");
        }
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(final Observer observer) {
        observers.add(observer);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() throws PyramidException {
        for (Observer el: observers) {
            el.update(this);
        }
    }
}
