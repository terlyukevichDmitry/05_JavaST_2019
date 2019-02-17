
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *An public class for filtering data.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ListFilter {

    /**
     * DIGIT_PATTEN for filtering data.
     */
    private static final String DIGIT_PATTEN = "^[0-9]*[.]?[0-9]+$";
    /**
     *DIGIT_PATTEN_FOR_SPLIT for splitting array.
     */
    private static final String DIGIT_PATTEN_FOR_SPLIT = "\\s+";
    /**
     *DIGIT_PATTEN_FOR_SPLIT for splitting array.
     */
    private static final Logger LOGGER = LogManager.getLogger(ListFilter.class);
    /**
     *checkNumber for checking true string.
     */
    private final int checkNumber = 8;

    /**
     * This readListOfString we use for read information of file.
     * @param list for filtering data.
     * @return List<String> with component for solutions this task.
     */
    public List<String> filterList(final List<String> list) {
        List<String> listNew = new ArrayList<>();
        for (String string: list) {
            int counter = 0;
            boolean isSolution = true;
            if (string.trim().length() == 0) {
                LOGGER.info("Validation error: empty string" + string + ".");
            } else {
                for (String elementList
                        : string.split(DIGIT_PATTEN_FOR_SPLIT)) {
                    if (!(elementList.matches(DIGIT_PATTEN))) {
                        LOGGER.info("Validation error: incorrect string: "
                                + elementList + ".");
                        isSolution = false;
                    }
                    counter++;
                }
                if (isSolution && counter == checkNumber) {
                    listNew.add(string);
                } else {
                    LOGGER.info("Validation error: insufficient data : "
                    + string + ".");
                }
            }
        }
        return listNew;
    }

}
