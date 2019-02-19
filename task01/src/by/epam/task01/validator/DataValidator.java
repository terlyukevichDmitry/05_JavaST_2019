
/**
 * An public class for do different tasks.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
package by.epam.task01.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
/**
 * An public class for validate data.
 *
 * @author Dmitry Terlyukevish
 * @version 1.0
 */
public class DataValidator {

    /**
     *we use this for checking data.
     */
    private List<Double> doubleList;
    /**
     * Logger for show problems or info.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataValidator.class);
    /**
     * It's a first constructor in this class.
     *
     * @param list for doubleList
     */
    public DataValidator(final List<Double> list) {
        this.doubleList = list;
    }
    /**
     * check true height.
     * @return true or false
     */
    public boolean checkingHeight() {
        if (doubleList.get(7) <= 0) {
            LOGGER.warn("We have not correct data!(height)");
            return false;
        }
        return true;
    }
    /**
     * check true height new pyramid.
     * @return true or false
     */
    public boolean checkingHeightNewPyramid() {
        if (doubleList.get(8) < 0) {
            LOGGER.warn("We have not correct data!(heightNewPyramid)");
            return false;
        }
        return true;
    }
    /**
     * check true height comparison.
     * @return true or false
     */
    public boolean checkingHeightComparison() {
        if (doubleList.get(8) > doubleList.get(7)) {
            LOGGER.warn("We have not correct data!(heightNewPyr > height");
            return false;
        }
        return true;
    }
    /**
     * check true point match.
     * @return true or false
     */
    public boolean checkingPointMatch() {
        if ((doubleList.get(0).equals(doubleList.get(3)))
                && doubleList.get(1).equals(doubleList.get(4))
                && doubleList.get(2).equals(doubleList.get(5))) {
            LOGGER.warn("We have the same points!");
        }
        return true;
    }
    /**
     * check true angles.
     * @return true or false
     */
    public boolean checkingAngles() {
        if (doubleList.get(6) <= 2) {
            LOGGER.warn("We can't build pyramid!");
            return false;
        }
        return true;
    }

}

