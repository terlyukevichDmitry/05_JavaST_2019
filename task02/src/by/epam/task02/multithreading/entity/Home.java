package by.epam.task02.multithreading.entity;

/**
 *An public Home entity class.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Home {
    /**
     * X coordinate.
     */
    private double x;
    /**
     * Y coordinate.
     */
    private double y;

    /**
     * It's constructor in this class with parameters.
     * @param coordinateX for x.
     * @param coordinateY for y.
     */
    public Home(final double coordinateX, final double coordinateY) {
        this.x = coordinateX;
        this.y = coordinateY;
    }

    /**
     * get x coordinate.
     * @return x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * set data.
     * @param coordinateX for x coordinate
     */
    public void setX(final double coordinateX) {
        this.x = coordinateX;
    }

    /**
     * get y coordinate.
     * @return y coordinate.
     */
    public double getY() {
        return y;
    }
    /**
     * set y coordinate.
     * @param coordinateY for y.
     */
    public void setY(final double coordinateY) {
        this.y = coordinateY;
    }
    /**
     * {@inheritDoc}
     *
     * @return string with this information.
     */
    @Override
    public String toString() {
        return "Home{" + "x=" + x + ", y=" + y + '}';
    }
}
