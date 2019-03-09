package by.epam.task02.multithreading.entity;

import by.epam.task02.multithreading.state.Expectation;
import by.epam.task02.multithreading.state.Meet;
import by.epam.task02.multithreading.state.StateTaxi;
import by.epam.task02.multithreading.state.Trip;

/**
 *An public Taxi entity class.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Taxi {

    /**
     * for x coordinate.
     */
    private double x;
    /**
     * for y coordinate.
     */
    private double y;
    /**
     * for name taxi driver.
     */
    private String name;
    /**
     * number of taxi.
     */
    private String taxiNumber;
    /**
     * check employment taxi.
     */
    private boolean checkTaxi = false;
    /**
     * state interface for realization state pattern.
     */
    private StateTaxi stateTaxi;

    /**
     * constructor for init data.
     * @param coordinateX for x.
     * @param coordinateY for y.
     * @param nameT for name.
     * @param taxiNumberT for taxi number.
     */
    public Taxi(final double coordinateX, final double coordinateY,
                final String nameT, final String taxiNumberT) {
        this.x = coordinateX;
        this.y = coordinateY;
        this.name = nameT;
        this.taxiNumber = taxiNumberT;
    }

    /**
     * get employment taxi.
     * @return true or false.
     */
    public boolean isCheckTaxi() {
        return checkTaxi;
    }

    /**
     * set false or true for checkTaxi.
     * @param checkTaxiT for checkTaxi.
     */
    public void setCheckTaxi(final boolean checkTaxiT) {
        this.checkTaxi = checkTaxiT;
    }

    /**
     * get state.
     * @return state taxi.
     */
    public StateTaxi getStateTaxi() {
        return stateTaxi;
    }

    /**
     * set state.
     * @param stateTaxiT for stateTaxi.
     */
    public void setStateTaxi(final StateTaxi stateTaxiT) {
        this.stateTaxi = stateTaxiT;
    }

    /**
     * get x coordinate.
     * @return x;
     */
    public double getX() {
        return x;
    }

    /**
     * set x coordinate.
     * @param coordinateX for x.
     */
    public void setX(final double coordinateX) {
        this.x = coordinateX;
    }

    /**
     * get y coordinate.
     * @return y.
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
     * get name taxi driver.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * set name taxi driver.
     * @param nameT for name.
     */
    public void setName(final String nameT) {
        this.name = nameT;
    }

    /**
     * get taxi number.
     * @return number.
     */
    public String getTaxiNumber() {
        return taxiNumber;
    }

    /**
     * set taxi number.
     * @param taxiNumberT for taxiNumber.
     */
    public void setTaxiNumber(final String taxiNumberT) {
        this.taxiNumber = taxiNumberT;
    }

    /**
     * for choose state and next realization.
     */
    public void nextStation() {
        if (stateTaxi instanceof Expectation) {
            setStateTaxi(new Meet());
        } else if (stateTaxi instanceof Meet) {
            setStateTaxi(new Trip());
        } else if (stateTaxi instanceof Trip) {
            setStateTaxi(new Expectation());
        }
    }

    /**
     * motion state.
     */
    public void motion() {
        stateTaxi.motion();
    }
    /**
     * {@inheritDoc}
     *
     * @return string with this information.
     */
    @Override
    public String toString() {
        return "Taxi{" + "x=" + x + ", y=" + y + ", name='" + name + '\''
                + ", taxiNumber='" + taxiNumber + '\'';
    }
}
