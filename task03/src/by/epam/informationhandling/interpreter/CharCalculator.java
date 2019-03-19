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
            if (x.equals(">>>")) {
                Integer b = stack.pop(), a = stack.pop();
                stack.push(a>>>b);
            } else if (x.equals("|")) {
                stack.push(stack.pop() | stack.pop());
            } else if (x.equals("&")) {
                stack.push(stack.pop() & stack.pop());
            } else if (x.equals("<<")) {
                stack.push(stack.pop() << stack.pop());
            } else if (x.equals("^")) {
                stack.push(stack.pop() ^ stack.pop());
            } else stack.push(Integer.valueOf(x));
        }
        return stack.pop();
        //terminal!,
    }
}
