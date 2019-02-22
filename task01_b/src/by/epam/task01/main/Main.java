package by.epam.task01.main;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.LengthCollectionPointException;
import by.epam.task01.exception.PyramidException;
import by.epam.task01.recorder.Recorder;
import by.epam.task01.repository.RepositorySingleton;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class Main {
    public static void main(String[] args) throws LengthCollectionPointException, PyramidException {
        Recorder recorder = new Recorder();
        RepositorySingleton repositorySingleton =
                RepositorySingleton.getInstance();
        List<Point> points = new ArrayList<Point>() {
            {
                add(new Point(3, 1, 0));
                add(new Point(3, 25, 0));
            }
        };
        List<Pyramid> pyramids = new ArrayList<Pyramid>(){
            {
                add(new Pyramid(points, 4, 10));
            }
        };
        repositorySingleton.save(new Pyramid(points, 4, 10));
        System.out.println(pyramids.get(0));
        pyramids.get(0).setHeight(100);
        pyramids.get(0).notifyObservers();
        System.out.println(pyramids.get(0));

    }
}
