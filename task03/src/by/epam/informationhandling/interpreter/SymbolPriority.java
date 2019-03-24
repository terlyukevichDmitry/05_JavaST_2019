package by.epam.informationhandling.interpreter;

import java.util.Objects;

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
    /**
     * Equals method for compare objects.
     * @param o our object for compare.
     * @return result, true or false. equal or not.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SymbolPriority that = (SymbolPriority) o;
        return priority == that.priority
                && Objects.equals(symbol, that.symbol);
    }
    /**
     * object hashcode.
     * @return int hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(priority, symbol);
    }
}
