package by.epam.task02.multithreading.main;

import by.epam.task02.multithreading.controller.ThreadController;
import by.epam.task02.multithreading.creator.PersonListCreator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.entity.Person;
import by.epam.task02.multithreading.singleton.Uber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws MissingWayFileException {

        ExecutorService es = Executors.newFixedThreadPool(4);
        PersonListCreator personListCreator = new PersonListCreator();
        List<Person> people = personListCreator.createList();
        ThreadController controllerThread = new ThreadController(es);
        List<Taxi> taxiList = new ArrayList<Taxi>() {
            {
                add(new Taxi(4, 7, "Ilya", "FIRST"));
                add(new Taxi(1, 1, "Aristarchus", "SECOND"));
                add(new Taxi(2, -4, "Dmitriy", "THIRD"));
                add(new Taxi(-2, -3, "Artem", "FOURTH"));
            }
        };
        Uber.INSTANCE.setTaxiList(taxiList);

        controllerThread.start(people);
        List<Future<Person>> futureList = controllerThread.getFutureList();
        controllerThread.stopThread();

        for (Future<Person> p : futureList) {
            try {
                System.out.println(p.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
