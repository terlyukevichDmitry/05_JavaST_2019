package by.epam.task02.multithreading.main;

import by.epam.task02.multithreading.controller.ControllerThread;
import by.epam.task02.multithreading.creator.ListCreator;
import by.epam.task02.multithreading.entity.Taxi;
import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.home.Home;
import by.epam.task02.multithreading.person.Person;
import by.epam.task02.multithreading.entity.Uber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final String FILE = "data" + File.separator + "file.txt";

    public static void main(String[] args) throws MissingWayFileException {

        ExecutorService es = Executors.newFixedThreadPool(3);
        ListCreator listCreator = new ListCreator();
        Map<Integer, List<Double>> listMap = listCreator.createList(FILE);
        ReentrantLock lock = new ReentrantLock();
        List<Person> people = new ArrayList<Person>() {
            {
                add(new Person(1,1, 4, new Home(5, 5), lock));
                add(new Person(2,4, 4, new Home(3, 3), lock));
                add(new Person(1,0, 4, new Home(2,3), lock));
                add(new Person(3,1, 4, new Home(4,3), lock));
            }
        };

        List<Taxi> taxiList = new ArrayList<Taxi>(){
            {
                add(new Taxi(2,3, "Aristarchus", "number1"));
                add(new Taxi(1,1, "Dmitriy", "number2"));
                add(new Taxi(0 , 0, "Artem", "number3"));
                add(new Taxi(4 , 5, "Ilya", "number4"));
            }
        };
        Uber.INSTANCE.setTaxiList(taxiList);

        ControllerThread controllerThread = new ControllerThread(es);
        controllerThread.start(people);
        List<Future<Person>> futureList = controllerThread.getFutureList();

        for (Future<Person> f : futureList) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
