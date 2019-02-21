package by.epam.task01.action;

import by.epam.task01.entity.Pyramid;

/**
 * It's public class for calculate different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCalculator {

    /**
     * This calculateSquare we use for calculate pyramid square.
     * @param pyramid object
     * @return square.
     */
    public double calculateSquare(final Pyramid pyramid) {
        double side = calculateSide(pyramid);
        return calculateBaseArea(side, pyramid)
                + calculateSideSurfaceArea(side, pyramid);
    }
    /**
     * This calculateBaseArea we use for help calculate pyramid square.
     * @param side the base of the pyramid.
     * @param pyramid object.
     * @return baseArea.
     */
    private double calculateBaseArea(final double side,
                                     final Pyramid pyramid) {
        final int coefficient = 4;
        double tan = (Math.tan(Math.PI / pyramid.getNumberOfAngles()));
        return (pyramid.getNumberOfAngles() * side * side)
                / (coefficient * tan);
    }
    /**
     * This calculateRadius we use for calculate radius in pyramid.
     * @param pyramid object.
     * @return radius.
     */
    private double calculateRadius(final Pyramid pyramid) {
        final double pi = 180;
        return calculateSide(pyramid) / (2 * Math.tan(Math.toRadians(pi
                / pyramid.getNumberOfAngles())));
    }
    /**
     * This calculateVolume we use calculate volume our pyramid.
     * @param pyramid object.
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
     * This calculateSide we use for calculate side the base of the pyramid.
     * @param pyramid object.
     * @return side.
     */
    public double calculateSide(final Pyramid pyramid) {
        return Math.sqrt(Math.pow((pyramid.getPointList(1).getX()
                - pyramid.getPointList(0).getX()), 2)
                + Math.pow((pyramid.getPointList(1).getY()
                - pyramid.getPointList(0).getY()), 2));
    }
    /**
     * This calculateSideSurfaceArea we use for calculate side of surface area
     * for square our pyramid.
     * @param side the base of the pyramid.
     * @param pyramid object.
     * @return side of surface area.
     */
    private double calculateSideSurfaceArea(final double side,
                                            final Pyramid pyramid) {
        final double coefficient = 1.0 / 2.0;
        double apothem = Math.sqrt(Math.pow(calculateRadius(pyramid), 2)
                + Math.pow(pyramid.getHeight(), 2));
        return side * apothem * pyramid.getNumberOfAngles() * coefficient;
    }
    /**
     * This calculateRatioVolume we use for calculate ratio between two volume.
     * @param pyramid object.
     * @param heightPlane it's height plane -> truncated pyramid.
     * @return volume ratio.
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
     * This calculateVolumeTruncatedPyramid we use for help calculate volume
     * ratio.
     * @param pyramid object.
     * @param heightPlane it's height plane -> truncated pyramid.
     * @return volume of truncated pyramid.
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
     * This calculateBaseAreaNewPyramid we use for help calculate volume ratio.
     * @param baseArea our pyramid.
     * @param pyramid object.
     * @param heightPlane it's height plane -> truncated pyramid..
     * @return base area of new pyramid.
     */
    private double calculateBaseAreaNewPyramid(final Pyramid pyramid,
                                           final double heightPlane,
                                           final double baseArea) {
        return baseArea * (pyramid.getHeight() - heightPlane)
                * (pyramid.getHeight() - heightPlane)
                / (pyramid.getHeight() * pyramid.getHeight());
    }
}
