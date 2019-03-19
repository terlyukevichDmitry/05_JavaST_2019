package by.epam.informationhandling.interpreter;

import java.util.*;

public class Context {
    public Expression evaluate(String string) {
        int pos = 0;

        ArrayDeque<String> strings = new ArrayDeque<>();

        ArrayList<Integer> integers = new ArrayList<>();
        String l = "";
        while(pos != string.length()) {
            if (Character.isDigit(string.charAt(pos))) {
                int j = pos + 1;
                String number = "" + string.charAt(pos);
                while(j != string.length() && Character.isDigit(string.charAt(j))) {
                    number += string.charAt(j);
                    j++;
                }
                pos += number.length() - 1;
                l += number + " ";
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
                strings.add(symbol);
            }
            pos++;
        }
        // изучить приоритеты!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList<SymbolPriority> symbolPriorities = new ArrayList<>();
        SymbolPriority priority = null;
        for (String str: strings) {
            if (str.equals(">>>") || str.equals("<<") || str.equals(">>")) {
                ExpressionConstant expressionConstant = ExpressionConstant.LEFT_SHIFT;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            } else if(str.equals("|")) {
                ExpressionConstant expressionConstant = ExpressionConstant.OR;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            } else if(str.equals("&")) {
                ExpressionConstant expressionConstant = ExpressionConstant.AND;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            } else if(str.equals("~")) {
                ExpressionConstant expressionConstant = ExpressionConstant.NOT;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            } else if(str.equals("<") || str.equals(">")) {
                ExpressionConstant expressionConstant = ExpressionConstant.LEFT;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            } else if(str.equals("^")) {
                ExpressionConstant expressionConstant = ExpressionConstant.CAP;
                priority = new SymbolPriority(expressionConstant.getPriority(), str);
            }
            symbolPriorities.add(priority);
        }

        symbolPriorities.sort(Comparator.comparing(SymbolPriority::getPriority));

        String str = "" + l;
        for (SymbolPriority p : symbolPriorities) {
            str += " " + p.getSymbol();
        }

        List<String> list = new ArrayList<>();
        for (String s : str.split("\\s+")) {
            list.add(s);
        }

        System.out.println(list);

        CharCalculator charCalculator = new CharCalculator(list);
        int number = charCalculator.interpret();
        System.out.println(number);
        return null;//new ByteExpression(result);
    }
}
