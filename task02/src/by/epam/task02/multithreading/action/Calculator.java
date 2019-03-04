package by.epam.task02.multithreading.action;

import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    public double calculateSide(final Taxi taxi,
                                final Person person) {
        return Math.sqrt(Math.pow(person.getX() - taxi.getX(), 2)+
                Math.pow(person.getY() - taxi.getY(), 2));
    }
    public boolean checkPosition(final Taxi taxi,
                                 final double radius) {
        return radius >= taxi.getX() && radius >= taxi.getY();
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
}
