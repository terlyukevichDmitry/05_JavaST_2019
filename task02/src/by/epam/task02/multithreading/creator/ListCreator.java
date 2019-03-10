package by.epam.task02.multithreading.creator;

import by.epam.task02.multithreading.exception.MissingWayFileException;
import by.epam.task02.multithreading.parser.ParseData;
import by.epam.task02.multithreading.reader.DataReader;
import by.epam.task02.multithreading.validator.ListFilter;

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
     * This method we use for create final list with data.
     * @param file for create list.
     * @return createdList.
     * @throws MissingWayFileException for checking data path.
     */
    public Map<Integer, List<Double>> createList(final String file)
            throws MissingWayFileException {
        List<String> stringList = stringListCreator(file);
        List<String> filteredList = filterListCreator(stringList);
        return parseDoubleCreator(filteredList);
    }
    /**
     * This method we use for help to create final list.
     * @param file for create list.
     * @return stringList.
     * @throws MissingWayFileException for checking data path.
     */
    private List<String> stringListCreator(final String file)
            throws MissingWayFileException {
        DataReader fileReaderHelper = new DataReader();
        return fileReaderHelper.readListOfString(file);
    }
    /**
     * This method we use for help to create final list.
     * In this method we are filtering data.
     * @param stringList for create list.
     * @return filteredList.
     */
    private List<String> filterListCreator(final List<String> stringList) {
        ListFilter listFilter = new ListFilter();
        return listFilter.filterList(stringList);
    }
    /**
     * This method we use for help to create final list.
     * In this method we are parsing data.
     * @param filteredList for create list.
     * @return map with data.
     */
    private Map<Integer, List<Double>> parseDoubleCreator(
            final List<String> filteredList) {
        ParseData parseData = new ParseData();
        return parseData.createMap(filteredList);
    }
}
