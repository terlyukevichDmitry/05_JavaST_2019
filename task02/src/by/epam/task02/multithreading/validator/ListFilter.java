package by.epam.task02.multithreading.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * An public class for filtering data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ListFilter {
    /**
     * DIGIT_PATTEN for filtering data.
     */
    private static final String DIGIT_PATTEN = "^[0-9]*[.-]?[0-9]+$";
    /**
     *DIGIT_PATTEN_FOR_SPLIT for split array.
     */
    private static final String DIGIT_PATTEN_FOR_SPLIT = "\\s+";
    /**
     *DIGIT_PATTEN_FOR_SPLIT for split array.
     */
    private static final Logger LOGGER = LogManager.getLogger(ListFilter.class);
    /**
     * This filterList we use for filtering not incorrect data.
     * @param list for filtering data.
     * @return List<String> with component for solutions this task.
     */
    public List<String> filterList(final List<String> list) {
        List<String> listNew = new ArrayList<>();
        for (String string: list) {
            int counter = 0;
            boolean isSolution = true;
            if (string.trim().length() != 0) {
                for (String elementList
                        : string.split(DIGIT_PATTEN_FOR_SPLIT)) {
                    if (!(elementList.matches(DIGIT_PATTEN))) {
                        LOGGER.info(
                                "Validation error: incorrect string:"
                                        + " " + elementList + ".");
                        isSolution = false;
                    }
                    counter++;
                }
                final int checkNumber = 20;
                if (!isSolution || counter != checkNumber) {
                    LOGGER.info("Validation error: insufficient data : "
                            + string + ".");
                } else {
                    listNew.add(string);
                }
            } else {
                LOGGER.info("Validation error: empty string" + string + ".");
            }
        }
        return listNew;
    }
}
