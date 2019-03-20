package by.epam.informationhandling.interpreter;

import java.util.*;

public class Context {

    public Expression evaluate(String string) {
        int pos = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        LinkedList<Integer> st = new LinkedList<>();
        LinkedList<String> op = new LinkedList<>();
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
        ArrayList<SymbolPriority> symbolPriorities = new ArrayList<>();
        SymbolPriority priority = null;
        ArrayDeque<SymbolPriority> deque = new ArrayDeque<>();

        int i = 0;
        int z = 0;
        for (String str : stringList) {
            if (Character.isDigit(str.charAt(0))) {
                list.add(str);
            } else {
                System.out.println(list);
                if (z == 0) {
                    symbolPriorities = new ArrayList<>();
                }
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


//                if (str.equals("("))
//                    op.add("(");
//                else if (str.equals(")")) {
//                    while (!op.getLast().equals("("))
//                        processOperator(st,op.removeLast());
//                    op.removeLast();
//                } else if (isOperator(str)) {
//                    while (!op.isEmpty() && priority(op.getLast()) >= priority(str))
//                        processOperator(st, String.valueOf(op.removeLast()));
//                    op.add(str);
//                } else {
//                    String operand = "";
//                    while (i < str.length() && Character.isDigit(str.charAt(i)))
//                        operand += str.charAt(i++);
//                    --i;
//                    st.add(Integer.parseInt(operand));
//                }

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

//                if(!symbolPriorities.isEmpty()) {
//                    if (!str.equals(")")) {
//                        if (!str.equals("(")) {
//                            assert priority != null;
//                            if (!symbolPriorities.get(z - 1).getSymbol().equals("(")) {
//                                if (priority.getPriority() >= symbolPriorities.get(z - 1).getPriority()) {
//                                    list.add(symbolPriorities.get(z - 1).getSymbol());
//                                    symbolPriorities.get(z - 1).setPriority(priority.getPriority());
//                                    symbolPriorities.get(z - 1).setSymbol(priority.getSymbol());
//                                    z--;
//                                } else {
//                                    symbolPriorities.add(priority);
//                                }
//                            } else {
//                                symbolPriorities.add(priority);
//                            }
//                        } else {
//                            symbolPriorities.add(priority);
//                        }
//                    } else {
//                        int length = symbolPriorities.size() - 1;
//                        boolean flag = false;
//                        while (!flag) {
//                            if (!symbolPriorities.get(length).getSymbol().equals("(")) {
//                                list.add(symbolPriorities.get(length).getSymbol());
//                                symbolPriorities.remove(length);
//                                length--;
//                            } else {
//                                flag = true;
//                                symbolPriorities.remove(length);
//                            }
//                        }
//                        if (!symbolPriorities.isEmpty()) {
//                            length = symbolPriorities.size() - 1;
//                            while (!symbolPriorities.isEmpty()) {
//                                list.add(symbolPriorities.get(length).getSymbol());
//                                symbolPriorities.remove(length);
//                                length--;
//                            }
//                        }
//                        z = -1;
//                    }
//                } else {
//                    symbolPriorities.add(priority);
//                }
                z++;
            }
            i++;
        }

        while (deque.size() > 0) {
            list.add(deque.pop().getSymbol());
        }

//        int length = symbolPriorities.size() - 1;
//        while (!symbolPriorities.isEmpty()) {
//            list.add(symbolPriorities.get(length).getSymbol());
//            symbolPriorities.remove(length);
//            length--;
//        }
//        while (!op.isEmpty())
//            processOperator(st, op.removeLast());
//
//        System.out.println(st.get(0));
        //System.out.println(list);

        CharCalculator charCalculator = new CharCalculator(list);
        int number = charCalculator.interpret();
        System.out.println(number);
        return null;//new ByteExpression(result);
    }

    static void processOperator(LinkedList<Integer> st, String op) {
        int r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        int l = st.removeLast(); // также
        switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case ">>>":
                st.add(l >>> r);
                break;
            case "|":
                st.add(l | r);
                break;
        }
    }
    static boolean isOperator(String string) { // возвращяем тру если один из символов ниже
        return string.equals(">>>") || string.equals("|");
    }

    static int priority(String op) {
        switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
            case ">>>":
                return 5;
            case "|":
                return 8;
            default:
                return -1;
        }
    }
}
