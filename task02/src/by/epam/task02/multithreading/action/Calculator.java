package by.epam.task02.multithreading.action;

import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.person.Person;
import by.epam.task02.multithreading.singleton.Uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {

    private ReentrantLock locker = new ReentrantLock();

    public double calculateSide(final Taxi taxi,
                                final Person person) {
        return Math.sqrt(Math.pow(person.getX() - taxi.getX(), 2) +
                Math.pow(person.getY() - taxi.getY(), 2));
    }

    public boolean checkPosition(final Taxi taxi,
                                 final Person person) {

        return ((Math.pow((taxi.getX() - person.getX()), 2)
                + Math.pow((taxi.getY() - person.getY()), 2)))
                <= (person.getRadius() * person.getRadius());
    }

    public double checkComparison(final List<Taxi> taxiList,
                                  final Person person) {
        List<Double> doubleList = new ArrayList<>();
        for (Taxi taxi : taxiList) {
            doubleList.add(calculateSide(taxi, person));
        }
        Collections.sort(doubleList);
        return doubleList.get(0);
    }

    public List<Taxi> taxiListCreator(final Person person) {

        List<Taxi> list = Uber.INSTANCE.getTaxiList();
        List<Taxi> trueList = new ArrayList<>();
        for (Taxi taxi : list) {
            if (!taxi.isCheckTaxi()) {
                if (checkPosition(taxi, person)) {
                    trueList.add(taxi);
                }
            }
        }
        return trueList;
    }

    public Taxi taxiSelection(final List<Taxi> taxiList, final Person person) {
        //locker
        locker.lock();
        for (Taxi taxi : taxiList) {
            if (Double.compare(calculateSide(taxi, person), checkComparison(taxiList, person)) == 0) {
                taxi.setCheckTaxi(true);
                return taxi;
            }
        }
        locker.unlock();
        //locker
        return null;
    }

    public long calculateTime(final Taxi taxi, final Person person) {
        final long speed = 60;
        long time = (long) calculateSide(taxi, person) * speed * 10;
        return time;
    }
}

