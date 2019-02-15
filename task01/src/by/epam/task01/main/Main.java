
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

import by.epam.task01.exception.MissingWayFileException;
import by.epam.task01.giveInfo.Logic;
import by.epam.task01.parser.ParseData;
import by.epam.task01.reader.DataReader;
import by.epam.task01.validator.ListFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 *An abstract class that represents an algorithm.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */

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
    public static void main(final String[] args) throws MissingWayFileException {
        LOGGER.info("Hello World!");
        DataReader fileReaderHelper = new DataReader();
        List<String> list = fileReaderHelper.readListOfString(FILE);
        ListFilter listFilter = new ListFilter();
        List<String> filteredList = listFilter.filterList(list);
        LOGGER.info("FilteredList: ");
        // I will write parser for data.
        filteredList.forEach(System.out::println);
        ParseData parseData = new ParseData();
        List<Double> createdList = parseData.parseList(filteredList);
        createdList.forEach(System.out::println);
        Logic logic = new Logic();
        logic.fillingInformationOfList(createdList);


    }
}
