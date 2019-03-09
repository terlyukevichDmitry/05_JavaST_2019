package by.epam.task02.multithreading.controller;

import by.epam.task02.multithreading.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * This public class we use for controlling threads.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class ThreadController {

    /**
     * Future list.
     */
    private List<Future<Person>> futureList = new ArrayList<>();
    /**
     * es for executorService.
     */
    private ExecutorService es;
    /**
     * Constructor with one parameter.
     * @param executorService object.
     */
    public ThreadController(final ExecutorService executorService) {
        this.es = executorService;
    }
    /**
     * getter for list.
     * @return List<Future<Persont>>.
     */
    public List<Future<Person>> getFutureList() {
        return futureList;
    }

    /**
     * starting works threads.
     * @param people list.
     */
    public void start(final List<Person> people) {

        List<Callable<Person>> callableList = new ArrayList<>(people);

        for (Callable<Person> personCallable: callableList) {
            futureList.add(es.submit(personCallable));
        }
    }

    /**
     * stopping threads.
     */
    public void stopThread() {
        es.shutdown();
    }
}
