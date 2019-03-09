package by.epam.task02.multithreading.creator;

import by.epam.task02.multithreading.entity.Home;
import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.entity.Person;
import by.epam.task02.multithreading.exception.PersonDataException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This public class we use for controlling threads.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class PersonListCreator {
    /**
     * File for reading data.
     */
    private static final String FILE = "data" + File.separator + "file.txt";
    /**
     * constant.
     */
    private final int four = 4;
    /**
     * create list with Person objects.
     * @return list with persons.
     * @throws MissingWayFileException for check exception situation.
     * @throws PersonDataException for check exception situation.
     */
    public List<Person> createList()
            throws MissingWayFileException, PersonDataException {
        List<Double> doubleList = getList();
        List<Person> people = new ArrayList<>();
        int counter = -1;
        for (int i = 0; i < four; i++) {
            people.add(new Person(doubleList.get(++counter),
                    doubleList.get(++counter), doubleList.get(++counter),
                    new Home(doubleList.get(++counter),
                            doubleList.get(++counter))));
        }
        return people;
    }

    /**
     * get list with double data.
     * @return list with double.
     * @throws MissingWayFileException for check exception situation.
     */
    private List<Double> getList() throws MissingWayFileException {
        ListCreator listCreator = new ListCreator();
        Map<Integer, List<Double>> listMap = listCreator.createList(FILE);
        return listMap.get(0);
    }
}
