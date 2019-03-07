package by.epam.task02.multithreading.main;

import by.epam.task02.multithreading.controller.ControllerThread;
import by.epam.task02.multithreading.creator.ListCreator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.entity.Home;
import by.epam.task02.multithreading.person.Person;
import by.epam.task02.multithreading.singleton.Uber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final String FILE = "data" + File.separator + "file.txt";

    public static void main(String[] args) throws MissingWayFileException {

        ExecutorService es = Executors.newCachedThreadPool();
        ListCreator listCreator = new ListCreator();
        Map<Integer, List<Double>> listMap = listCreator.createList(FILE);
        ReentrantLock lock = new ReentrantLock();
        List<Person> people = new ArrayList<Person>() {
            {
                add(new Person(2,7, 4, new Home(100, 5)));
                add(new Person(4,2, 4, new Home(3, 3123)));
                add(new Person(5,-6, 4, new Home(1013,-713)));
                add(new Person(-1,-4, 4, new Home(-101,-150)));
            }
        };

        List<Taxi> taxiList = new ArrayList<Taxi>(){
            {
                add(new Taxi(4 , 7, "Ilya", "FIRST"));
                add(new Taxi(1,1, "Aristarchus", "SECOND"));
                add(new Taxi(2,-4, "Dmitriy", "THIRD"));
                add(new Taxi(-2 , -3, "Artem", "FOURTH"));
            }
        };
        Uber.INSTANCE.setTaxiList(taxiList);

        ControllerThread controllerThread = new ControllerThread(es);
        controllerThread.start(people);
        List<Future<Person>> futureList = controllerThread.getFutureList();
        controllerThread.stopThread();
        for (Future<Person> p : futureList) {
            try {
                System.out.println(p.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
