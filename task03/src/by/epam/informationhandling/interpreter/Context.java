package by.epam.informationhandling.interpreter;

import by.epam.informationhandling.action.PolishNotationCreator;

public class Context {

    public int evaluate(final String string) {

        PolishNotationCreator polishNotation = new PolishNotationCreator();
        ExpressionCalculator charCalculator = new ExpressionCalculator(
                polishNotation.polishCreating(string));
        return charCalculator.interpret();
    }
}
