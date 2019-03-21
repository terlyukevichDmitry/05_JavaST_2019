package by.epam.informationhandling.interpreter;

public class TerminalExpressionBitOr extends AbstractMathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(context.popValue() | context.popValue());
    }
}
