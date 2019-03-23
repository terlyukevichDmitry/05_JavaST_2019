package by.epam.informationhandling.interpreter;

/**
 * Class with Enum element for calculate expression.
 */
public enum ExpressionConstant {
    /**
     * OR element in expression.
     */
    OR(10),
    /**
     * CAP element in expression.
     */
    CAP(9),
    /**
     * AND element in expression.
     */
    AND(8),
    /**
     * SHIFT element in expression.
     */
    SHIFT(5),
    /**
     * NOT element in expression.
     */
    NOT(2),
    /**
     * BRACKET element in expression.
     */
    BRACKET(0);
    /**
     * priority different expression elements.
     */
    private int priority;

    /**
     * Constructor for priority.
     * @param priorityEnum priority expression element.
     */
    ExpressionConstant(final int priorityEnum) {
        this.priority = priorityEnum;
    }

    /**
     * Getter for get priority.
     * @return priority different element.
     */
    public int getPriority() {
        return priority;
    }
}
