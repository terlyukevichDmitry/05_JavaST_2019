
/**
 * Domain classes used to produce .....
 * <p>
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevish
 * @version 1.0
 */

package by.epam.task01.main;

import by.epam.task01.action.PyramidCalculator;
import by.epam.task01.creator.ListCreator;
import by.epam.task01.entity.Point;
import by.epam.task01.entity.Pyramid;
import by.epam.task01.exception.MissingWayFileException;
import by.epam.task01.factory.PointFactory;
import by.epam.task01.factory.PyramidFactory;

import by.epam.task01.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *An abstract class that represents an algorithm.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */

@SuppressWarnings("CheckStyle")
final class Main {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    /**
     * Logger for recording a program state.
     */
    private static final String FILE = "data" + File.separator + "file.txt";
    /**
     * It's a main constructor in this application.
     */
    private Main() {
    }

    /**
     * This main method.
     * @param args program arguments
     * @throws MissingWayFileException asd
     */
    public static void main(final String[] args)
            throws MissingWayFileException {
        ListCreator listCreator = new ListCreator();
        Map<Integer, List<Double>> createdList = listCreator.createList(FILE);
        Map.Entry<Integer, List<Double>> entry =
                createdList.entrySet().iterator().next();
        List<Double> createdLst = entry.getValue();
        createdLst.forEach(System.out::println);

        PointFactory pointFactory = new PointFactory();
        List<Point> pointList = pointFactory.createPoints(createdLst);
        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(pointList, createdLst);
        PyramidCalculator pyramidCalculator = new PyramidCalculator();
        double side = pyramidCalculator.calculateSide(pointList);
        System.out.println("side = " + side);
        double square = pyramidCalculator.calculateSquare(side, pyramid);
        System.out.println("Square = " + square);
        double volume = pyramidCalculator.calculateVolume(square,
                pyramid.getHeight());
        System.out.println("volume = " + volume);

        double heightNewPyramid = createdLst.get(7);
        System.out.println("heightNewPyramid = " + heightNewPyramid);

        double volumeTruncatedPyramid =
                pyramidCalculator.calculateVolumeTruncatedPyramid(pyramid,
                        heightNewPyramid, side);
        double volumeNewPyramid = volume - volumeTruncatedPyramid;

        double volumeRatio = volume / volumeNewPyramid;
        System.out.println("volumeRatio = " + volumeRatio);


        DataValidator dataValidator = new DataValidator(createdLst);
        dataValidator.checkingPointMatch();



    }
}
