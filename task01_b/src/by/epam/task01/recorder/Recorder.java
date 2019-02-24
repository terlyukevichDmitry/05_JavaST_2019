package by.epam.task01.recorder;

import by.epam.task01.action.PyramidCalculator;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.NullDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In this class we use for different methods.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Recorder implements Observer {
    /**
     * Number of square different pyramids.
     */
    private double square;
    /**
     * Number of volume different pyramids.
     */
    private double volume;
    /**
     *Logger for show information.
     */
    private static final Logger LOGGER = LogManager.getLogger(Recorder.class);
    /**
     * COUNTER for id.
     */
    private static final AtomicInteger COUNTER =
            new AtomicInteger(0);
    /**
     * id.
     */
    private int id;
    /**
     * @throws NullDataException for check mistake.
     * @param pyramid object.
     */
    public void createSlotForNewPyramid(final Pyramid pyramid)
            throws NullDataException {
        if (pyramid == null) {
            LOGGER.error("We have null in object!");
            throw new NullDataException("We have null in object!");
        }
        update(pyramid);
        id = COUNTER.getAndIncrement();
    }
    /**
     * get id.
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * get square different objects.
     * @return square
     */

    public double getSquare() {
        return square;
    }
    /**
     * set square.
     * @param squareP for set new data.
     */
    public void setSquare(final double squareP) {
        this.square = squareP;
    }
    /**
     * get volume different objects.
     * @return volume
     */
    public double getVolume() {
        return volume;
    }
    /**
     * set volume.
     * @param volumeP for set new data.
     */
    public void setVolume(final double volumeP) {
        this.volume = volumeP;
    }
    /**
     * For calculate new square and volume with new data.
     * @param pyramid object.
     */
    private void calculateWithNewData(final Pyramid pyramid) {
        PyramidCalculator pyramidCalculator = new PyramidCalculator();
        square = pyramidCalculator.calculateSquare(pyramid);
        volume = pyramidCalculator.calculateVolume(pyramid);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Pyramid pyramid) {
        calculateWithNewData(pyramid);
    }
    /**
     * {@inheritDoc}
     * @return string.
     */
    @Override
    public String toString() {
        return "Recorder{" + "square=" + square + ", volume=" + volume
                + ", id=" + '}';
    }
    /**
     * {@inheritDoc}
     * @return equals result.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recorder recorder = (Recorder) o;
        return Double.compare(recorder.square, square) == 0
                && Double.compare(recorder.volume, volume) == 0;
    }
    /**
     * {@inheritDoc}
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(square, volume);
    }
}
