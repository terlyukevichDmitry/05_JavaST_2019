package by.epam.informationhandling.interpreter;

import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.exception.NullDataException;

public class Context {

    public int evaluate(final String string) throws NullDataException {

        PolishNotationCreator polishNotation = new PolishNotationCreator();
        ExpressionCalculator charCalculator = new ExpressionCalculator(
                polishNotation.polishCreating(string));
        return charCalculator.interpret();
    }
}
