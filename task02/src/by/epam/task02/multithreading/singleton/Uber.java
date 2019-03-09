package by.epam.task02.multithreading.singleton;

import by.epam.task02.multithreading.action.Calculator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.entity.Person;

import java.util.List;

/**
 *An public Home entity class.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class Uber {
    /**
     * thread safe singleton.
     */
    public static final Uber INSTANCE = new Uber();
    /**
     * list with taxi objects.
     */
    private List<Taxi> taxiList;

    /**
     * get list with taxi objects.
     * @return taxi list.
     */
    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    /**
     * set list.
     * @param taxiListT for taxiList.
     */
    public void setTaxiList(final List<Taxi> taxiListT) {
        this.taxiList = taxiListT;
    }

    /**
     * for get true taxi for different persons.
     * @param person object.
     * @return taxi object.
     */
    public Taxi getTaxi(final Person person) {
        Calculator calculator = new Calculator();
        Taxi taxi = calculator.taxiSelection(
                calculator.taxiListCreator(person), person);
        return taxi;
    }
}
