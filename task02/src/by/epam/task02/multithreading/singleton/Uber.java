package by.epam.task02.multithreading.singleton;

import by.epam.task02.multithreading.entity.Taxi;

import java.util.List;

public class Uber {
    public static final Uber INSTANCE = new Uber();

    private List<Taxi> taxiList;

    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(List<Taxi> taxiList) {
        this.taxiList = taxiList;
    }
}
