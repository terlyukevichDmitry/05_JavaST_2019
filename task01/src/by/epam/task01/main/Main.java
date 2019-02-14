
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

import by.epam.task01.reader.DataReader;
import by.epam.task01.validator.ListFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
     * It's a main constructor in this application.
     */
    private Main() {
    }

    /**
     * This main method.
     * @param args program arguments
     */
    public static void main(final String[] args) {
        LOGGER.info("Hello World!");
        DataReader fileReaderHelper = new DataReader();
        List<String> list = fileReaderHelper.readArrayOfString();
        list.forEach(System.out::println);
        ListFilter listFilter = new ListFilter();
        List<String> filteredList = listFilter.filterList(list);
        filteredList.forEach(System.out::println);

    }
}
