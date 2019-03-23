package by.epam.informationhandling.interpreter;

/**
 * An public class for storage element and his priority.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SymbolPriority {
    /**
     * priority for symbol.
     */
    private int priority;
    /**
     * symbol which have priority in this class.
     */
    private String symbol;
    /**
     * Constructor for initialization data.
     * @param priorityT for initialization priority.
     * @param symbolT for initialization symbol.
     */
    public SymbolPriority(final int priorityT, final String symbolT) {
        this.priority = priorityT;
        this.symbol = symbolT;
    }

    /**
     * Getter for get symbol.
     * @return symbol.
     */
    public String getSymbol() {
        return symbol;
    }
    /**
     * Getter for get priority.
     * @return priority.
     */
    public int getPriority() {
        return priority;
    }
}
