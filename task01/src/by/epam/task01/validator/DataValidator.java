package by.epam.task01.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@SuppressWarnings("CheckStyle")
public class DataValidator {

    List<Double> doubleList;

    private static final Logger LOGGER = LogManager.getLogger(DataValidator.class);

    public DataValidator(List<Double> list) {
        this.doubleList = list;
    }

    public boolean checkingApothem() {
        if (doubleList.get(4) <= 0) {
            LOGGER.warn("We have not correct data!(apothem)");
            return false;
        }
        return true;
    }

    public boolean checkingHeight() {
        if (doubleList.get(6) <= 0) {
            LOGGER.warn("We have not correct data!(height)");
            return false;
        }
        return true;
    }

    public boolean checkingHeightNewPyramid() {
        if(doubleList.get(7) < 0) {
            LOGGER.warn("We have not correct data!(heightNewPyramid)");
            return false;
        }
        return true;
    }

    public boolean checkingHeightComparison() {
        if (doubleList.get(7) > doubleList.get(6)) {
            LOGGER.warn("We have not correct data!(heightNewPyr > height");
            return false;
        }
        return true;
    }

    public boolean checkingPointMatch() {
        if ((doubleList.get(0).equals(doubleList.get(2)))
                && doubleList.get(1).equals(doubleList.get(3))) {
            LOGGER.warn("We have the same points!");
        }
        return true;
    }

    public boolean checkingAngles() {
        if (doubleList.get(5) <= 2) {
            LOGGER.warn("We can't build pyramid!");
            return false;
        }
        return true;
    }

    public boolean checkingApothemDoesMatchHeight(final double side,
                                                  final double apothem,
                                                  final double height,
                                                  final double angels) {
        final double epsilon = 0.001;
        double tangent = Math.tan((Math.toRadians(180 / angels)));
        double part1 = side / (2.0 * tangent);
        double part2 = apothem * apothem - height * height;

        return Math.abs(part2 - (part1 * part1)) < epsilon;
    }

}

