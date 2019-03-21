package by.epam.informationhandling.interpreter;

public class TerminalExpressionBitAnd extends AbstractMathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(context.popValue() & context.popValue());
    }
}
