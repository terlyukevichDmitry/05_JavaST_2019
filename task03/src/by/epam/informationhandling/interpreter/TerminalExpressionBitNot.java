package by.epam.informationhandling.interpreter;

public class TerminalExpressionBitNot extends AbstractMathExpression {
    @Override
    public void interpret(ExpressionContext context) {
        context.pushValue(~context.popValue());
    }
}
