
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
    private static final Logger LOGGER =
            LogManager.getLogger(DataValidator.class);
    /**
     *constant.
     */
    private final int constantThree = 3;
    /**
     *constant.
     */
    private final int constantFour = 4;
    /**
     *constant.
     */
    private final int constantFive = 5;
    /**
     *constant.
     */
    private final int constantSix = 6;
    /**
     *constant.
     */
    private final int constantSeven = 7;
    /**
     *constant.
     */
    private final int constantEight = 8;
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
        if (doubleList.get(constantSeven) <= 0) {
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
        if (doubleList.get(constantEight) < 0) {
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
        if (doubleList.get(constantEight) > doubleList.get(constantSeven)) {
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
        if ((doubleList.get(0).equals(doubleList.get(constantThree)))
                &&
                doubleList.get(1).equals(doubleList.get(constantFour))
                &&
                doubleList.get(2).equals(
                        doubleList.get(constantFive))) {
            LOGGER.warn("We have the same points!");
        }
        return true;
    }
    /**
     * check true angles.
     * @return true or false
     */
    public boolean checkingAngles() {
        if (doubleList.get(constantSix) <= 2) {
            LOGGER.warn("We can't build pyramid!");
            return false;
        }
        return true;
    }
    /**
     * check true angles.
     * @return true or false
     */
    public boolean checkingEqualsZParameter() {
        if (doubleList.get(2).equals(doubleList.get(constantFive))) {
            LOGGER.info("The pyramid is located in Oxy plane.");
            return true;
        } else {
            LOGGER.info("l");
            return false;
        }
    }

}

