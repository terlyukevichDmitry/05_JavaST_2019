package by.epam.informationhandling.action;

import by.epam.informationhandling.interpreter.ExpressionConstant;
import by.epam.informationhandling.interpreter.SymbolPriority;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PolishNotationCreator {

    public List<String> polishCreating(final String string) {

        List<String> stringList = listDataCreating(string);
        List<String> list = new ArrayList<>();
        ArrayDeque<SymbolPriority> deque = new ArrayDeque<>();

        return listCreator(stringList, list, null, deque);
    }

    private List<String> listDataCreating(final String string) {
        int position = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        while(position != string.length()) {
            String dopString = "";
            if (Character.isDigit(string.charAt(position))) {
                int j = position + 1;
                String number = "" + string.charAt(position);
                while(j != string.length() && Character.isDigit(string.charAt(j))) {
                    number += string.charAt(j);
                    j++;
                }
                position += number.length() - 1;
                dopString += number + " ";
                integers.add(Integer.parseInt(number));
            } else {
                String symbol = "" + string.charAt(position);
                int i = position + 1;
                if (i < string.length()) {
                    while (!Character.isDigit(string.charAt(i))) {
                        if (string.charAt(i) == string.charAt(position)) {
                            symbol += string.charAt(i);
                        }
                        i++;
                    }
                }
                position += symbol.length() - 1;
                dopString += symbol;
            }
            if (dopString.charAt(0) == ')') {

                for (String element : dopString.split("")) {
                    stringList.add(element);
                }
            } else {
                stringList.add(dopString);
            }
            position++;
        }
        return stringList;
    }


    private List<String> listCreator(final List<String> stringList,
                                     final List<String> list,
                                     SymbolPriority priority,
                                     final ArrayDeque<SymbolPriority> deque) {
        for (String str : stringList) {
            if (Character.isDigit(str.charAt(0))) {
                list.add(str);
            } else {
                priority = getSymbolPriority(str);
                if (str.equals("(")) {
                    deque.push(priority);
                } else if (str.equals(")")) {
                    SymbolPriority s = deque.pop();
                    while (!s.getSymbol().equals("(")) {
                        list.add(s.getSymbol());
                        s = deque.pop();
                    }
                } else {
                    if (deque.size() != 0) {
                        if (!deque.peek().getSymbol().equals("(")) {
                            if ((deque.size() > 0) && (priority.getPriority()
                                    >= deque.peek().getPriority())) {
                                list.add(deque.pop().getSymbol());
                            }
                        }
                    }
                    deque.push(priority);
                }
            }
        }

        while (deque.size() > 0) {
            list.add(deque.pop().getSymbol());
        }

        return list;
    }

    private SymbolPriority getSymbolPriority(final String str) {
        SymbolPriority priority = null;
        if (str.equals(">>>") || str.equals("<<") || str.equals(">>")) {
            ExpressionConstant expressionConstant =
                    ExpressionConstant.LEFT_SHIFT;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        } else if (str.equals("|")) {
            ExpressionConstant expressionConstant = ExpressionConstant.OR;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        } else if (str.equals("&")) {
            ExpressionConstant expressionConstant = ExpressionConstant.AND;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        } else if (str.equals("~")) {
            ExpressionConstant expressionConstant = ExpressionConstant.NOT;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        } else if (str.equals("^")) {
            ExpressionConstant expressionConstant = ExpressionConstant.CAP;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        } else if (str.equals("(") || str.equals(")")) {
            ExpressionConstant expressionConstant = ExpressionConstant.BRACKET;
            priority = new SymbolPriority(
                    expressionConstant.getPriority(), str);
        }
        return priority;
    }
}
