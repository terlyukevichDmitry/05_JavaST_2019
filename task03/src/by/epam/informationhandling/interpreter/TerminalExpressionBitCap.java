package by.epam.informationhandling.interpreter;

public class TerminalExpressionBitCap extends AbstractMathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(context.popValue() ^ context.popValue());
    }
}
