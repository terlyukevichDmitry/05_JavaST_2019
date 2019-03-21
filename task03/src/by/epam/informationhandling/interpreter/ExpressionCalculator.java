package by.epam.informationhandling.interpreter;

import java.util.List;

public class ExpressionCalculator {

    private List<String> strings;

    public ExpressionCalculator(List<String> stringList) {
        this.strings = stringList;
    }

    private void parse(final ExpressionContext context) {

        for (String string : strings) {
            switch(string) {
                case ">>>": {
                    Expression lambda =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        >>> f1);
                            };
                    lambda.test(context);
                    break;
                }
                case ">>": {
                    Expression lambda =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        >> f1);
                            };
                    lambda.test(context);
                    break;
                }
                case "<<": {
                    Expression lambda =
                            x -> {
                                int f1 = x.popValue();
                                int f2 = x.popValue();
                                x.pushValue(f2
                                        << f1);
                            };
                    lambda.test(context);
                    break;
                }
                case "^": {
                    Expression lambda =
                            x -> x.pushValue(x.popValue() ^ x.popValue());
                    lambda.test(context);
                    break;
                }
                case "|": {
                    Expression lambda =
                            x -> x.pushValue(x.popValue() | x.popValue());
                    lambda.test(context);
                    break;
                }
                case "&": {
                    Expression lambda =
                            x -> x.pushValue(x.popValue() & x.popValue());
                    lambda.test(context);
                    break;
                }
                case "~": {
                    Expression lambda = x -> x.pushValue(~x.popValue());
                    lambda.test(context);
                    break;
                }
                default: {
                    Expression lambda =
                            x -> x.pushValue(Integer.valueOf(string.trim()));
                    lambda.test(context);
                }
            }
        }
    }

    public Number calculate() {
        ExpressionContext context = new ExpressionContext();
        parse(context);
        return context.popValue();
    }
}
