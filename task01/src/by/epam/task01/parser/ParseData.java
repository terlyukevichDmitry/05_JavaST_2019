
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *An public class for parse data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParseData {

    /**
     * DIGIT_PATTEN_FOR_SPLIT for parse data.
     */
    private static final String DIGIT_PATTEN_FOR_SPLIT = "\\s+";

    /**
     * This readListOfString we use for read information of file.
     * @param filteredList for parse data.
     * @return List<String> with component for solutions this task.
     */
    public Map<Integer, List<Double>> createMap(
            final List<String> filteredList) {
        ArrayList<Double> listOfDoubles;
        Map<Integer, List<Double>> myMap = new HashMap<>();
        int i = 0;
        for (String el : filteredList) {
            listOfDoubles = new ArrayList<>();
            for (String elementArray : el.split(DIGIT_PATTEN_FOR_SPLIT)) {
                listOfDoubles.add(Double.parseDouble(elementArray));
            }
            myMap.put(i++, listOfDoubles);
        }
        return myMap;
    }
}
