package by.epam.informationhandling.interpreter;

public enum ExpressionConstant {
    OR(10),
    AND(8),
    CAP(9),
    NOT(2),
    LEFT(6),
    LEFT_SHIFT(5);

    private int priority;

    ExpressionConstant(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}