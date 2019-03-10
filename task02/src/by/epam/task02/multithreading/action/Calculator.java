package by.epam.task02.multithreading.action;

import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.entity.Person;
import by.epam.task02.multithreading.singleton.Uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This public class we use for calculate different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class Calculator {
    /**
     * Locker for correct works methods.
     */
    private ReentrantLock locker = new ReentrantLock();

    /**
     * calculate side between two points.
     * @param taxi object.
     * @param person object.
     * @return side.
     */
    public double calculateSide(final Taxi taxi,
                                final Person person) {
        return Math.sqrt(Math.pow(person.getX() - taxi.getX(), 2)
                + Math.pow(person.getY() - taxi.getY(), 2));
    }
    /**
     * check whether the point is in the area.
     * @param taxi object.
     * @param person object.
     * @return true of false, if we are in this area.
     */
    public boolean checkPosition(final Taxi taxi,
                                 final Person person) {
        return (Math.pow((taxi.getX() - person.getX()), 2)
                + Math.pow((taxi.getY() - person.getY()), 2))
                <= (person.getRadius() * person.getRadius());
    }

    /**
     * check small side.
     * @param taxiList object.
     * @param person object.
     * @return small side.
     */
    public double checkComparison(final List<Taxi> taxiList,
                                  final Person person) {
        List<Double> doubleList = new ArrayList<>();
        for (Taxi taxi : taxiList) {
            doubleList.add(calculateSide(taxi, person));
        }
        Collections.sort(doubleList);
        return doubleList.get(0);
    }

    /**
     * get taxi list, which we can use.
     * @param person object.
     * @return list with taxi.
     */
    public List<Taxi> taxiListCreator(final Person person) {

        List<Taxi> list = Uber.INSTANCE.getTaxiList();
        List<Taxi> trueList = new ArrayList<>();
        for (Taxi taxi : list) {
            if (!(taxi.isCheckTaxi()) && checkPosition(taxi, person)) {
                trueList.add(taxi);
            }
        }
        // if we don't have correct taxi in this radius,
        // we use taxi without radius!!
        if (trueList.isEmpty()) {
            for (Taxi taxi : list) {
                if (!taxi.isCheckTaxi()) {
                    trueList.add(taxi);
                }
            }
        }
        return trueList;
    }

    /**
     * return true taxi for different persons.
     * @param taxiList list with taxi.
     * @param person object.
     * @return taxi.
     */
    public Taxi taxiSelection(final List<Taxi> taxiList, final Person person) {
        //locker
        locker.lock();
        for (Taxi taxi : taxiList) {
            if (Double.compare(calculateSide(taxi, person),
                    checkComparison(taxiList, person)) == 0) {
                taxi.setCheckTaxi(true);
                return taxi;
            }
        }
        locker.unlock();
        //locker
        return null;
    }

    /**
     * calculate time for different way taxi.
     * @param taxi object.
     * @param person object.
     * @return time.
     */
    public long calculateTime(final Taxi taxi, final Person person) {
        final long speed = 60;
        final long coefficient = 10;
        long time = (long) calculateSide(taxi, person) * speed * coefficient;
        return time;
    }
}

