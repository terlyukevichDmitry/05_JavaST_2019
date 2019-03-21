package by.epam.informationhandling.interpreter;

public class TerminalExpressionNumber extends AbstractMathExpression {

    private int number;

    public TerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(number);
    }
}
