package by.epam.task01.recorder;

import by.epam.task01.action.PyramidCalculator;
import by.epam.task01.entity.Pyramid;

@SuppressWarnings("CheckStyle")
public class Recorder implements Observer{

    private double square;
    private double volume;
    private int id;
    private static int idCounter = -1;

    public void register(final Pyramid pyramid) {
        id = ++idCounter;
        update(pyramid);
    }

    public int getId() {
        return id;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    private void calculateWithNewData(final Pyramid pyramid) {
        PyramidCalculator pyramidCalculator = new PyramidCalculator();
        square = pyramidCalculator.calculateSquare(pyramid);
        volume = pyramidCalculator.calculateVolume(pyramid);
    }

    @Override
    public void update(Object object) {
        calculateWithNewData((Pyramid)object);
    }
}
