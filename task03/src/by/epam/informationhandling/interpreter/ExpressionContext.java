package by.epam.informationhandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionContext {

    private Deque<Integer> deque = new ArrayDeque<>();

    public Integer popValue() {
        return deque.pop();
    }

    public void pushValue(Integer value) {
        this.deque.push(value);
    }
}
