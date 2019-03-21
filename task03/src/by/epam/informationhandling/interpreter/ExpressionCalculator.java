package by.epam.informationhandling.interpreter;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {

    private List<String> strings;

    private ArrayList<AbstractMathExpression> listExpression;

    public ExpressionCalculator(List<String> stringList) {
        listExpression = new ArrayList<>();
        this.strings = stringList;
        parse();
    }

    private void parse() {
        for (String x : strings) {
            x = x.trim();

            switch(x) {
                case ">>>": {
                    listExpression.add(
                            new TerminalExpressionBitThreeRightShift());
                    break;
                }
                case ">>": {
                    listExpression.add(
                            new TerminalExpressionBitTwoRightShift());
                    break;
                }
                case "<<": {
                    listExpression.add(
                            new TerminalExpressionBitTwoLeftShift());
                    break;
                }
                case "^": {
                    listExpression.add(new TerminalExpressionBitCap());
                    break;
                }
                case "|": {
                    listExpression.add(new TerminalExpressionBitOr());
                    break;
                }
                case "&": {
                    listExpression.add(new TerminalExpressionBitAnd());
                    break;
                }
                case "~": {
                    listExpression.add(new TerminalExpressionBitNot());
                    break;
                }
                default: {
                    listExpression.add(
                            new TerminalExpressionNumber(Integer.valueOf(x)));
                }
            }
        }
    }

    public Number calculate() {
        ExpressionContext context = new ExpressionContext();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

}
