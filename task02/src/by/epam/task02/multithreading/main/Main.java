package by.epam.task02.multithreading.main;

import by.epam.task02.multithreading.controller.ThreadController;
import by.epam.task02.multithreading.creator.PersonListCreator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.entity.Person;
import by.epam.task02.multithreading.exception.PersonDataException;
import by.epam.task02.multithreading.singleton.Uber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Main classes for start this application.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class Main {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    /**
     * main method.
     * @param args args.
     * @throws MissingWayFileException for checking data path.
     * @throws PersonDataException for checking data for person objects.
     */
    public static void main(final String[] args)
            throws MissingWayFileException, PersonDataException {
        final double four = 4.0;
        final int fourThreads = 4;
        final double seven = 7.0;
        final double three = 3.0;
        final double two = 2.0;
        final double ten = 10.0;
        ExecutorService es = Executors.newFixedThreadPool(fourThreads);
        PersonListCreator personListCreator = new PersonListCreator();
        List<Person> people = personListCreator.createList();
        ThreadController controllerThread = new ThreadController(es);
        List<Taxi> taxiList = new ArrayList<Taxi>() {
            {
                add(new Taxi(four, seven,
                        "Ilya", "FIRST"));
                add(new Taxi(1, 1,
                        "Aristarchus", "SECOND"));
                add(new Taxi(two, -four,
                        "Dmitriy", "THIRD"));
                add(new Taxi(-two, -three,
                        "Artem", "FOURTH"));
                add(new Taxi(1, ten,
                        "Vladislav", "FIVE"));
            }
        };
        Uber.INSTANCE.setTaxiList(taxiList);

        controllerThread.start(people);
        List<Future<Person>> futureList = controllerThread.getFutureList();
        controllerThread.stopThread();

        for (Future<Person> p : futureList) {
            try {
                LOGGER.info(p.get());
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.warn("We have mistake: ", e);
            }
        }
    }
}
