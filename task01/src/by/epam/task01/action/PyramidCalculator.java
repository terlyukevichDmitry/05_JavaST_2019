
/**
 * These classes contain the ......
 *
 * @author Dmitry Terlyukevich
 * @version 1.0
 * @since 1.0
 */
package by.epam.task01.action;

/**
 * An public class for do different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PyramidCalculator {

    /**
     * This readListOfString we use for read information of file.
     * @param height for calculating volume
     * @param square for calculating volume
     * @return volume.
     */
    public double calculateVolume(final double height, final double square) {
        double squarePyramid = height * square / 3;
        return squarePyramid;
    }

    /**
     * This readListOfString we use for read information of file.
     * @param height for calculating volume
     * @param side for calculating volume
     * @return volume.
     */
    public double calculateSquare(final double height, final double side) {
        final double coeff = 1 / 3;
        double volume = height * side * side * coeff;
        return volume;
    }
}
