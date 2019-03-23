package by.epam.informationhandling.action;

import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionConstant;
import by.epam.informationhandling.interpreter.SymbolPriority;
import by.epam.informationhandling.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class we use to create polish notation.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class PolishNotationCreator {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    /**
     * Method for create polish notation.
     * @param string string expression.
     * @return list with polish notation components.
     * @throws NullDataException for checking exception moments.
     */
    public List<String> polishCreating(final String string)
            throws NullDataException {

        List<String> stringList = listDataCreating(string);
        ArrayDeque<SymbolPriority> deque = new ArrayDeque<>();

        return listCreator(stringList, deque);
    }

    /**
     * Method for create list with expression components(symbols and numbers).
     * @param string string expression.
     * @return list with expression components.
     */
    private List<String> listDataCreating(final String string) {
        int position = 0;
        List<String> stringList = new ArrayList<>();
        if (position != string.length()) {
            do {
                String dopString = "";
                int j = position + 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string.charAt(position));
                if (Character.isDigit(string.charAt(position))) {
                    if (j != string.length()
                            && Character.isDigit(string.charAt(j))) {
                        do {
                            stringBuilder.append(string.charAt(j));
                            j++;
                        } while (j != string.length()
                                && Character.isDigit(string.charAt(j)));
                    }
                } else {
                    if (j < string.length()) {
                        while (!Character.isDigit(string.charAt(j))) {
                            if (string.charAt(j) == string.charAt(position)) {
                                stringBuilder.append(string.charAt(j));
                            }
                            j++;
                        }
                    }
                }
                position += stringBuilder.length() - 1;
                dopString += stringBuilder.toString();
                if (dopString.charAt(0) == ')') {
                    stringList.addAll(Arrays.asList(dopString.split("")));
                } else {
                    stringList.add(dopString);
                }
                position++;
            } while (position != string.length());
        }
        return stringList;
    }

    /**
     * Method for create true polish notation.
     * @param stringList list with expression components.
     * @param deque for create polish notation.
     * @return list with polish notation elements.
     * @throws NullDataException for checking exception moments.
     */
    private List<String> listCreator(final List<String> stringList,
                                     final ArrayDeque<SymbolPriority> deque)
            throws NullDataException {
        List<String> list = new ArrayList<>();
        if (deque == null) {
            LOGGER.info("We have null object!");
            throw new NullDataException("We have null object!");
        }
        for (String str : stringList) {
            if (Character.isDigit(str.charAt(0))) {
                list.add(str);
            } else {
                SymbolPriority priority = getSymbolPriority(str);
                if (("(").equals(str)) {
                    deque.push(priority);
                } else if ((")").equals(str)) {
                    SymbolPriority s = deque.pop();
                    while (!("(").equals(s.getSymbol())) {
                        list.add(s.getSymbol());
                        s = deque.pop();
                    }
                } else {
                    if (checkingEmptyDeque(deque) && !checkingSymbol(deque)
                            && comparePriority(deque, priority)) {
                            list.add(deque.pop().getSymbol());
                        }
                    deque.push(priority);
                }
            }
        }
        while (checkingEmptyDeque(deque)) {
            list.add(deque.pop().getSymbol());
        }
        return list;
    }

    /**
     * Method for create class with symbol and his priority for the next
     * actions.
     * @param string symbol.
     * @return class with symbol and his priority.
     */
    private SymbolPriority getSymbolPriority(final String string) {
        SymbolPriority priority = null;
        if ((">>>").equals(string) || (">>").equals(string)
                || ("<<").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.SHIFT.getPriority(), string);
        } else if (("|").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.OR.getPriority(), string);
        } else if (("&").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.AND.getPriority(), string);
        } else if (("~").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.NOT.getPriority(), string);
        } else if (("^").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.CAP.getPriority(), string);
        } else if (("(").equals(string) || (")").equals(string)) {
            priority = new SymbolPriority(
                    ExpressionConstant.BRACKET.getPriority(), string);
        }
        return priority;
    }

    /**
     * Method for check deque on empty moment.
     * @param deque collection for check.
     * @return boolean result.
     */
    private boolean checkingEmptyDeque(final ArrayDeque<SymbolPriority> deque) {
        return !deque.isEmpty();
    }
    /**
     * Method for check symbol.
     * @param deque collection for check.
     * @return boolean result.
     */
    private boolean checkingSymbol(final ArrayDeque<SymbolPriority> deque) {
        assert deque.peek() != null;
        return deque.peek().getSymbol().equals("(");
    }
    /**
     * Method for check priority comparison.
     * @param deque collection for check.
     * @param symbolPriority object with priority.
     * @return boolean result.
     */
    private boolean comparePriority(final ArrayDeque<SymbolPriority> deque,
                                    final SymbolPriority symbolPriority) {
        return (symbolPriority.getPriority()
                >= Objects.requireNonNull(deque.peek()).getPriority());
    }
}
