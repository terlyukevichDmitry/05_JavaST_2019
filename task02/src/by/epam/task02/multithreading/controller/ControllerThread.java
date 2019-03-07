package by.epam.task02.multithreading.controller;

import by.epam.task02.multithreading.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ControllerThread {

    private List<Future<Person>> futureList = new ArrayList<>();

    private ExecutorService es;

    public ControllerThread(ExecutorService es) {
        this.es = es;
    }

    public List<Future<Person>> getFutureList() {
        return futureList;
    }

    public void start(final List<Person> people) {

        List<Callable<Person>> callableList = new ArrayList<>(people);

        for (Callable<Person> personCallable: callableList) {
            futureList.add(es.submit(personCallable));
        }
    }

    public void stopThread() {
        es.shutdown();
    }
}
