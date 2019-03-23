package by.epam.informationhandling.interpreter;

/**
 * Functional interface for calculate expression.
 */
@FunctionalInterface
public interface Expression {
    /**
     * Method for calculate expression.
     * @param context context object.
     */
    void calculateExpression(ExpressionContext context);
}
