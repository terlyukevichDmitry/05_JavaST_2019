
/**
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author Dmitry Terlyukevich
 * @version 1.0
 */
package by.epam.task01.validator;

import by.epam.task01.reader.DataReader;
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
     * This readListOfString we use for read information of file.
     * @param list for filtering data.
     * @return List<String> with component for solutions this task.
     */
    public List<String> filterList(final List<String> list) {
        List<String> listNew = new ArrayList<>();
        for (String el: list) {
            boolean isSolution = true;
            for (String elementList: el.split(DIGIT_PATTEN_FOR_SPLIT)) {
                if (!(elementList.matches(DIGIT_PATTEN))) {
                    LOGGER.info("Validation error: incorrect string"
                            + elementList + ".");
                    isSolution = false;
                }
            }
            if (isSolution) {
                listNew.add(el);
            }
        }
        return listNew;
    }

}
