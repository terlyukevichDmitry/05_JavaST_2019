package by.epam.informationhandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CharCalculator implements Expression {

    private List<String> deque;

    public CharCalculator(List<String> arrayDeque) {
        this.deque = arrayDeque;
    }

    @Override
    public Integer interpret() {

        Deque<Integer> stack = new ArrayDeque<>();
        for (String x : deque) {
            x = x.trim();
            if (x.equals(">>>")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 >>> i1);
            } else if (x.equals("|")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 | i1);
            } else if (x.equals("&")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 & i1);
            } else if (x.equals("<<")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 << i1);
            } else if (x.equals("^")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 ^ i1);
            } else if (x.equals(">>")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2 >> i1);
            } else if (x.equals("~")) {
                int i1 = stack.pop();
                stack.push(~i1);
            } else stack.push(Integer.valueOf(x));
        }
        return stack.pop();
    }
}
