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
        if(doubleList.get(6) <= 0) {
            LOGGER.warn("We have not correct data!(apothem)");
            return false;
        }
        return true;
    }

    public boolean checkingHeight() {
        if(doubleList.get(8) <= 0){
            LOGGER.warn("We have not correct data!(height)");
            return false;
        }
        return true;
    }

    public boolean heightСomparison() {
        if(doubleList.get(9) > doubleList.get(8)){
            LOGGER.warn("We have not correct data!(heightNewPyr > height");
            return false;
        }
        return true;
    }

    public boolean checkingPointMatch() {
        if((doubleList.get(0).equals(doubleList.get(3)))
                && doubleList.get(1).equals(doubleList.get(4))
                && doubleList.get(2).equals(doubleList.get(5))) {
            LOGGER.warn("We have the same points!");
        }
        return true;
    }

    public boolean checkingAngles() {
        if(doubleList.get(7) <= 2){
            LOGGER.warn("We can't build pyramid!");
            return false;
        }
        return true;
    }

}
