package by.epam.informationhandling.interpreter;

public class TerminalExpressionBitTwoLeftShift extends AbstractMathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        int contextOne = context.popValue();
        int contextTwo = context.popValue();
        context.pushValue(contextTwo << contextOne);
    }
}
