package by.epam.informationhandling.interpreter;

import java.util.List;

/**
 * An public class for calculating polish notation.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ExpressionCalculator {
    /**
     * Collection which consists of String elements.
     */
    private List<String> strings;
    /**
     * Constructor for collection.
     * @param stringList collection with String elements for calculate
     * polish notation.
     */
    public ExpressionCalculator(final List<String> stringList) {
        this.strings = stringList;
    }
    /**
     * It is the main calculator.
     * @param context object.
     */
    private void parse(final ExpressionContext context) {

        for (String string : strings) {
            switch (string) {
                case ">>>":
                    Expression lambda1 =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        >>> f1);
                            };
                    lambda1.calculateExpression(context);
                    break;
                case ">>":
                    Expression lambda2 =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        >> f1);
                            };
                    lambda2.calculateExpression(context);
                    break;
                case "<<":
                    Expression lambda3 =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        << f1);
                            };
                    lambda3.calculateExpression(context);
                    break;
                case "^":
                    Expression lambda4 =
                            x -> x.pushValue(x.popValue() ^ x.popValue());
                    lambda4.calculateExpression(context);
                    break;
                case "|":
                    Expression lambda5 =
                            x -> x.pushValue(x.popValue() | x.popValue());
                    lambda5.calculateExpression(context);
                    break;
                case "&":
                    Expression lambda6 =
                            x -> x.pushValue(x.popValue() & x.popValue());
                    lambda6.calculateExpression(context);
                    break;
                case "~":
                    Expression lambda7 = x -> x.pushValue(~x.popValue());
                    lambda7.calculateExpression(context);
                    break;
                default:
                    Expression lambda8 =
                            x -> x.pushValue(Integer.valueOf(string.trim()));
                    lambda8.calculateExpression(context);
            }
        }
    }
    /**
     * Method for calculate polish notation and get result.
     * @return result expression.
     */
    public Number calculate() {
        ExpressionContext context = new ExpressionContext();
        parse(context);
        return context.popValue();
    }
}
