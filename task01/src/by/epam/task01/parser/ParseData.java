package by.epam.task01.parser;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CheckStyle")
public class ParseData {

    private static final String DIGIT_PATTEN_FOR_SPLIT = "\\s+";

    public List<Double> parseList(List<String> filteredList){

        List<Double> listOfDoubles = new ArrayList<>();

        for (String el: filteredList) {
            String[] array = el.split(DIGIT_PATTEN_FOR_SPLIT);
            for (String elementArray: array) {
                listOfDoubles.add(Double.parseDouble(elementArray));
            }
        }
        return listOfDoubles;
    }
}
