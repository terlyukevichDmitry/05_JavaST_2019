package by.epam.task02.multithreading.singleton;

import by.epam.task02.multithreading.action.Calculator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.person.Person;

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

    public Taxi getTaxi(final Person person) {
        Calculator calculator = new Calculator();
        List<Taxi> taxiList = calculator.taxiListCreator(person);
        Taxi taxi = calculator.taxiSelection(taxiList, person);
        return taxi;
    }
}
