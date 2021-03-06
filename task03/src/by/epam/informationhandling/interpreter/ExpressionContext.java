package by.epam.informationhandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An public class for calculating polish notation.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
class ExpressionContext {
    /**
     * Deque for calculate polish notation.
     */
    private Deque<Integer> deque = new ArrayDeque<>();
    /**
     * get deque.pop() element in Deque.
     * @return deque element.
     */
    Integer popValue() {
        return deque.pop();
    }
    /**
     * push element in Deque.
     * @param value element for push in Deque.
     */
    void pushValue(final Integer value) {
        this.deque.push(value);
    }
}
