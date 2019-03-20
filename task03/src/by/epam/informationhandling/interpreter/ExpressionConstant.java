package by.epam.informationhandling.interpreter;

public enum ExpressionConstant {
    OR(10),
    AND(8),
    CAP(9),
    SHIFT(5),
    NOT(2),
    BRACKET(0);

    private int priority;

    ExpressionConstant(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
