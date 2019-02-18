package by.epam.task01.creator;

import by.epam.task01.exception.MissingWayFileException;
import by.epam.task01.parser.ParseData;
import by.epam.task01.reader.DataReader;
import by.epam.task01.validator.ListFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 *An public class for create list with double data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ListCreator {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ListCreator.class);
    /**
     * This method we use for create final list.
     * @param file for create list.
     * @return createdList.
     * @throws MissingWayFileException for checking data path.
     */
    public Map<Integer, List<Double>> createList(final String file)
            throws MissingWayFileException {
        List<String> stringList = stringListCreator(file);
        List<String> filteredList = filterListCreator(stringList);
        Map<Integer, List<Double>> createdListOfDoubles =
                parseDoubleCreator(filteredList);
        return createdListOfDoubles;
    }

    /**
     * This method we use for create final list.
     * @param file for create list.
     * @return stringList.
     * @throws MissingWayFileException for checking data path.
     */
    private List<String> stringListCreator(final String file)
            throws MissingWayFileException {
        DataReader fileReaderHelper = new DataReader();
        List<String> stringList = fileReaderHelper.readListOfString(file);
        return stringList;
    }

    /**
     * This method we use for create final list.
     * @param stringList for create list.
     * @return filteredList.
     */
    private List<String> filterListCreator(final List<String> stringList) {
        ListFilter listFilter = new ListFilter();
        List<String> filteredList = listFilter.filterList(stringList);
        LOGGER.info("FilteredList: ");
        return filteredList;
    }

    /**
     * This method we use for create final list.
     * @param filteredList for create list.
     * @return createdListOfDoubles.
     */
    private Map<Integer, List<Double>> parseDoubleCreator(
            final List<String> filteredList) {
        ParseData parseData = new ParseData();
        Map<Integer, List<Double>> createdListOfDoubles =
                parseData.createMap(filteredList);
        return createdListOfDoubles;
    }

}
