package by.epam.informationhandling.interpreter;

import by.epam.informationhandling.action.PolishNotationCreator;

import java.util.*;

public class Context {

    public int evaluate(final String string) {

        PolishNotationCreator polishNotation = new PolishNotationCreator();
        CharCalculator charCalculator = new CharCalculator(
                polishNotation.polishCreating(string));
        return charCalculator.interpret();
    }
}
