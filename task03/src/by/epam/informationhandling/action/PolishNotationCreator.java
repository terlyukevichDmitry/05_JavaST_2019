package by.epam.informationhandling.action;

import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionConstant;
import by.epam.informationhandling.interpreter.SymbolPriority;
import by.epam.informationhandling.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PolishNotationCreator {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> polishCreating(final String string)
            throws NullDataException {

        List<String> stringList = listDataCreating(string);
        List<String> list = new ArrayList<>();
        ArrayDeque<SymbolPriority> deque = new ArrayDeque<>();

        return listCreator(stringList, list, deque);
    }

    private List<String> listDataCreating(final String string) {
        int position = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        while(position != string.length()) {
            String dopString = "";
            if (Character.isDigit(string.charAt(position))) {
                int j = position + 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string.charAt(position));
                while(j != string.length()
                        && Character.isDigit(string.charAt(j))) {
                    stringBuilder.append(string.charAt(j));
                    j++;
                }
                position += stringBuilder.length() - 1;
                dopString += stringBuilder.toString() + " ";
                arrayList.add(Integer.parseInt(stringBuilder.toString()));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string.charAt(position));
                int i = position + 1;
                if (i < string.length()) {
                    while (!Character.isDigit(string.charAt(i))) {
                        if (string.charAt(i) == string.charAt(position)) {
                            stringBuilder.append(string.charAt(i));
                        }
                        i++;
                    }
                }
                position += stringBuilder.length() - 1;
                dopString += stringBuilder.toString();
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
                                     final ArrayDeque<SymbolPriority> deque)
            throws NullDataException {
        if (deque == null) {
            LOGGER.info("We have null object!");
            throw new NullDataException("We have null object!");
        }
        for (String str : stringList) {
            if (Character.isDigit(str.charAt(0))) {
                list.add(str);
            } else {
                SymbolPriority priority = getSymbolPriority(str);
                //TODO nullPointerException
                if (("(").equals(str)) {
                    deque.push(priority);
                } else if ((")").equals(str)) {
                    SymbolPriority s = deque.pop();
                    while (!s.getSymbol().equals("(")) {
                        list.add(s.getSymbol());
                        s = deque.pop();
                    }
                } else {
                    if (!isEmpty(deque) && !checkingSymbol(deque)
                            && comparePriority(deque, priority)) {
                            list.add(deque.pop().getSymbol());
                        }
                    deque.push(priority);
                }
            }
        }
        while (!isEmpty(deque)) {
            list.add(deque.pop().getSymbol());
        }
        return list;
    }

    private SymbolPriority getSymbolPriority(final String str) {
        SymbolPriority priority = null;
        if (str.equals(">>>") || str.equals("<<") || str.equals(">>")) {
            priority = new SymbolPriority(
                    ExpressionConstant.SHIFT.getPriority(), str);
        } else if (str.equals("|")) {
            priority = new SymbolPriority(
                    ExpressionConstant.OR.getPriority(), str);
        } else if (str.equals("&")) {
            priority = new SymbolPriority(
                    ExpressionConstant.AND.getPriority(), str);
        } else if (str.equals("~")) {
            priority = new SymbolPriority(
                    ExpressionConstant.NOT.getPriority(), str);
        } else if (str.equals("^")) {
            priority = new SymbolPriority(
                    ExpressionConstant.CAP.getPriority(), str);
        } else if (str.equals("(") || str.equals(")")) {
            priority = new SymbolPriority(
                    ExpressionConstant.BRACKET.getPriority(), str);
        }
        return priority;
    }

    private boolean isEmpty(final ArrayDeque<SymbolPriority> deque) {
        return deque.isEmpty();
    }

    private boolean checkingSymbol(final ArrayDeque<SymbolPriority> deque) {
        return deque.peek().getSymbol().equals("(");
    }

    private boolean comparePriority(final ArrayDeque<SymbolPriority> deque,
                                    final SymbolPriority priority) {
        return (priority.getPriority() >= deque.peek().getPriority());
    }
}
