package by.epam.task01.main;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.NullDataException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.repository.RepositorySingleton;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class Main {
    public static void main(String[] args) throws LengthCollectionPointException, PyramidException, NullDataException {
        RepositorySingleton repositorySingleton =
                RepositorySingleton.getInstance();
        List<Point> points = new ArrayList<Point>() {
            {
                add(new Point(3, 1, 0));
                add(new Point(3, 25, 0));
            }
        };

        Pyramid pyramid = new Pyramid(points, 4, 10);
        Pyramid pyramid1 = new Pyramid(points, 5, 13);

        repositorySingleton.addObject(pyramid);
        repositorySingleton.addObject(pyramid1);
        pyramid.addObserver(repositorySingleton);
        pyramid1.addObserver(repositorySingleton);
        System.out.println(repositorySingleton.getRecorderList().get(0).getSquare());
        System.out.println(repositorySingleton.getRecorderList().get(0).getVolume());
        System.out.println(repositorySingleton.getRecorderList().get(1).getSquare());
        System.out.println(repositorySingleton.getRecorderList().get(1).getVolume());
        pyramid.setHeight(100);
        pyramid.notifyObservers();

        pyramid1.setHeight(8);
        pyramid1.notifyObservers();

        System.out.println(repositorySingleton.getRecorderList().get(0).getSquare());
        System.out.println(repositorySingleton.getRecorderList().get(0).getVolume());
        System.out.println(repositorySingleton.getRecorderList().get(1).getSquare());
        System.out.println(repositorySingleton.getRecorderList().get(1).getVolume());


    }
}
