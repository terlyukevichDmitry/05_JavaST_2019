
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */
package by.epam.task01.action;

import by.epam.task01.entity.Pyramid;

/**
 * An public class for do different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCalculator {

    /**
     * This readListOfString we use for read information of file.
     * @param pyramid new
     * @return volume.
     */
    public double calculateSquare(final Pyramid pyramid) {
        double side = calculateSide(pyramid);
        return calculateBaseArea(side, pyramid)
                + calculateSideSurfaceArea(side, pyramid);
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
        double tan = (Math.tan(Math.PI / pyramid.getNumberOfAngles()));
        return (pyramid.getNumberOfAngles() * side * side)
                / (coefficient * tan);
    }
    /**
     * @param pyramid for
     * @return radius
     */
    private double calculateRadius(final Pyramid pyramid) {
        final double pi = 180;
        return calculateSide(pyramid) / (2 * Math.tan(Math.toRadians(pi
                / pyramid.getNumberOfAngles())));
    }
    /**
     * This readListOfString we use for read information of file.
     * @param pyramid for calculating volume
     * @return volume.
     */
    public double calculateVolume(final Pyramid pyramid) {
        final double coefficient = 1.0 / 12.0;
        final double pi = 180;
        return coefficient * pyramid.getNumberOfAngles()
                * pyramid.getHeight()
                * calculateSide(pyramid)
                * calculateSide(pyramid)
                / (Math.tan(Math.toRadians(pi) / pyramid.getNumberOfAngles()));
    }
    /**
     * This readListOfString we use for read information of file.
     * @param pyramid for calculating volume
     * @return volume.
     */
    public double calculateSide(final Pyramid pyramid) {
        return Math.sqrt(Math.pow((pyramid.getPointList(1).getX()
                - pyramid.getPointList(0).getX()), 2)
                + Math.pow((pyramid.getPointList(1).getY()
                - pyramid.getPointList(0).getY()), 2));
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
        double apothem = Math.sqrt(Math.pow(calculateRadius(pyramid), 2)
                + Math.pow(pyramid.getHeight(), 2));
        return side * apothem * pyramid.getNumberOfAngles() * coefficient;
    }
    /**
     * This readListOfString we use for read information of file.
     * @param pyramid for.
     * @param heightPlane for.
     * @return volume.
     */
    public double calculateRatioVolume(final Pyramid pyramid,
                                       final double heightPlane) {
        double volumeAllPyramid = calculateVolume(pyramid);
        double volumeTruncatedPyramid = calculateVolumeTruncatedPyramid(
                pyramid, heightPlane);
        double volumeSmallPyramid = volumeAllPyramid - volumeTruncatedPyramid;
        return volumeTruncatedPyramid / volumeSmallPyramid;
    }
    /**
     * This readListOfString we use for read information of file.
     * @param pyramid for.
     * @param heightPlane for.
     * @return volume.
     */
    private double calculateVolumeTruncatedPyramid(final Pyramid pyramid,
                                                   final double heightPlane) {
        final double coefficient = 1.0 / 3.0;
        double baseArea = calculateBaseArea(calculateSide(pyramid), pyramid);
        double baseAreaNewPyramid = calculateBaseAreaNewPyramid(pyramid,
                heightPlane, baseArea);
        return  coefficient * heightPlane
                * (baseArea + Math.sqrt(baseArea)
                * Math.sqrt(baseAreaNewPyramid) + baseAreaNewPyramid);
    }
    /**
     * This readListOfString we use for read information of file.
     * @param baseArea for.
     * @param pyramid for.
     * @param heightPlane for.
     * @return volume.
     */
    private double calculateBaseAreaNewPyramid(final Pyramid pyramid,
                                           final double heightPlane,
                                           final double baseArea) {
        return baseArea * (pyramid.getHeight() - heightPlane)
                * (pyramid.getHeight() - heightPlane)
                / (pyramid.getHeight() * pyramid.getHeight());
    }
}
