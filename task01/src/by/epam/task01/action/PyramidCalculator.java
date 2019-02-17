
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */
package by.epam.task01.action;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;

import java.util.List;

/**
 * An public class for do different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCalculator {

    /**
     * This readListOfString we use for read information of file.
     * @param side for calculating volume
     * @param pyramid new
     * @return volume.
     */
    public double calculateSquare(final double side, final Pyramid pyramid) {
        double baseArea = calculateBaseArea(side, pyramid);
        double surfArea = calculateSideSurfaceArea(side, pyramid);
        double square = baseArea + surfArea;
        return square;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param side for calculating volume
     * @param pyramid new
     * @return volume.
     */
    private double calculateBaseArea(final double side,
                                     final Pyramid pyramid) {
        final int coefficient = 4;
        double baseArea1 = (pyramid.getNumberOfAngles() * side * side);
        double tan = (Math.tan(Math.PI / pyramid.getNumberOfAngles()));
        double baseArea2 = (coefficient * tan);
        double baseArea = baseArea1 / baseArea2;
        return baseArea;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param side for calculating volume
     * @param pyramid new
     * @return volume.
     */
    private double calculateSideSurfaceArea(final double side,
                                            final Pyramid pyramid) {
        final double coefficient = 1.0 / 2.0;
        double surfArea1 = pyramid.getApothem() * pyramid.getNumberOfAngles();
        double surfArea = side * surfArea1 * coefficient;
        return surfArea;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param square for calculating volume
     * @param height for calculating volume
     * @return volume.
     */
    public double calculateVolume(final double square, final double height) {
        final double coefficient = 1.0 / 3.0;
        return coefficient * square * height;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param pointList for calculating volume
     * @return volume.
     */
    public double calculateSide(final List<Point> pointList) {
        return Math.sqrt(Math.pow((pointList.get(1).getX()
                - pointList.get(0).getX()), 2)
                + Math.pow((pointList.get(1).getY()
                - pointList.get(0).getY()), 2));
    }

    /**
     * This readListOfString we use for read information of file.
     * @param side for.
     * @param pyramid for.
     * @param heightNewPyramid for.
     * @return volume.
     */
    private double calculateBaseNewPyramid(final Pyramid pyramid,
                                     final double heightNewPyramid,
                                     final double side) {
        double heightPyramid = pyramid.getHeight();
        double baseSquare = calculateBaseArea(side, pyramid);
        double squareBaseNewPyramid = baseSquare * heightNewPyramid
                * heightNewPyramid / (heightPyramid * heightPyramid);
        return squareBaseNewPyramid;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param side for.
     * @param pyramid for.
     * @param height for.
     * @return volume.
     */
    public double calculateVolumeTruncatedPyramid(final Pyramid pyramid,
                                                  final double height,
                                                  final double side) {
        final double coefficient = 1.0 / 3.0;
        double baseArea = calculateBaseArea(side, pyramid);
        double squareBaseNewPyramid = calculateBaseNewPyramid(pyramid,
                height, side);
        double volumeTruncatedPyramid = coefficient
                * (pyramid.getHeight() - height)
                * (baseArea + Math.sqrt(baseArea
                * squareBaseNewPyramid) + squareBaseNewPyramid);
        return volumeTruncatedPyramid;
    }


}
