package by.epam.task01.validator;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {

    private static final String DIGIT_PATTEN = "^[0-9]*[,]?[0-9]+$";
    private static final String DIGIT_PATTEN_FOR_SPLIT = "\\s+";

    public List<String> filterList(List<String> list) {
        List<String> listNew = new ArrayList<>();

        for (String el: list) {
            boolean hasSolution = true;
           String[] array = el.split(DIGIT_PATTEN_FOR_SPLIT);
           for (String elArray: array) {
               if (!(elArray.matches(DIGIT_PATTEN))) {
                   hasSolution = false;
               }
           }
           if (hasSolution) {
               listNew.add(el);
           }
        }

        return listNew;
    }
}
