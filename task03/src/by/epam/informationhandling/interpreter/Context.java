package by.epam.informationhandling.interpreter;

import java.util.*;

public class Context {

    public Expression evaluate(String string) {
        int pos = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        while(pos != string.length()) {
            String lol = "";
            if (Character.isDigit(string.charAt(pos))) {
                int j = pos + 1;
                String number = "" + string.charAt(pos);
                while(j != string.length() && Character.isDigit(string.charAt(j))) {
                    number += string.charAt(j);
                    j++;
                }
                pos += number.length() - 1;
                lol += number + " ";
                integers.add(Integer.parseInt(number));
            } else {
                String symbol = "" + string.charAt(pos);
                int i = pos + 1;
                while(!Character.isDigit(string.charAt(i))) {
                    if (string.charAt(i) == string.charAt(pos)) {
                        symbol += string.charAt(i);
                    }
                    i++;
                }
                pos += symbol.length() - 1;
                lol += symbol;
            }
            if (lol.charAt(0) == ')') {

                for (String strl : lol.split("")) {
                    stringList.add(strl);
                }
            } else {
                stringList.add(lol);
            }
            pos++;
        }

        List<String> list = new ArrayList<>();
        SymbolPriority priority = null;
        ArrayDeque<SymbolPriority> deque = new ArrayDeque<>();

        int i = 0;
        int z = 0;
        for (String str : stringList) {
            if (Character.isDigit(str.charAt(0))) {
                list.add(str);
            } else {
                System.out.println(list);
                if (str.equals(">>>") || str.equals("<<") || str.equals(">>")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.LEFT_SHIFT;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                } else if (str.equals("|")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.OR;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                } else if (str.equals("&")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.AND;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                } else if (str.equals("~")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.NOT;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                } else if (str.equals("^")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.CAP;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                } else if (str.equals("(") || str.equals(")")) {
                    ExpressionConstant expressionConstant = ExpressionConstant.SKOBKA;
                    priority = new SymbolPriority(expressionConstant.getPriority(), str);
                }

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
                            if ((deque.size() > 0) && (priority.getPriority() >= deque.peek().getPriority())) {
                                list.add(deque.pop().getSymbol());
                            }
                        }
                    }
                    deque.push(priority);
                }
                z++;
            }
            i++;
        }

        while (deque.size() > 0) {
            list.add(deque.pop().getSymbol());
        }

        CharCalculator charCalculator = new CharCalculator(list);
        int number = charCalculator.interpret();
        System.out.println(number);
        return null;//new ByteExpression(result);
    }
}
