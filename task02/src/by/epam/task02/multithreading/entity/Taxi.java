package by.epam.task02.multithreading.entity;

import by.epam.task02.multithreading.state.Expectation;
import by.epam.task02.multithreading.state.Meet;
import by.epam.task02.multithreading.state.StateTaxi;
import by.epam.task02.multithreading.state.Trip;

public class Taxi {

    private double x;
    private double y;
    private String name;
    private String taxiNumber;
    private boolean checkTaxi = false;

    private StateTaxi stateTaxi;

    public Taxi(double x, double y, String name, String taxiNumber) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.taxiNumber = taxiNumber;
    }

    public boolean isCheckTaxi() {
        return checkTaxi;
    }

    public void setCheckTaxi(boolean checkTaxi) {
        this.checkTaxi = checkTaxi;
    }

    public StateTaxi getStateTaxi() {
        return stateTaxi;
    }

    public void setStateTaxi(StateTaxi stateTaxi) {
        this.stateTaxi = stateTaxi;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public void nextStation() {
        if (stateTaxi instanceof Expectation) {
            setStateTaxi(new Meet());
        } else if (stateTaxi instanceof Meet) {
            setStateTaxi(new Trip());
        } else if (stateTaxi instanceof Trip) {
            setStateTaxi(new Expectation());
        }
    }
    public void motion() {
        stateTaxi.motion();
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                ", taxiNumber='" + taxiNumber + '\'';
    }
}
