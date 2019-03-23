package by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An public class for sorting all elements of text.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortText {
    /**
     * Method for sorting word in all text by one symbol or by alphabetically.
     * @param textComposite object witch we will be sort.
     * @param symbol for sorting word.
     * @return sorted ArrayList<TextComponent> with all components in text.
     */
    public ArrayList<TextComponent> sortingData(
            final TextComposite textComposite, final char symbol) {
        ArrayList<TextComponent> components = getArrayList(textComposite);
        components.sort(new Comparator<>() {
            @Override
            public int compare(final TextComponent a, final TextComponent b) {
                if (checkSymbol(symbol, a.toString()) - checkSymbol(symbol,
                        b.toString()) == 0) {
                    List<TextComponent> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.sort(Comparator.comparing(Object::toString));
                    return 0;
                } else {
                    return Integer.signum(checkSymbol(symbol, a.toString())
                            - checkSymbol(symbol, b.toString()));
                }
            }

            private int checkSymbol(final char symbol, final String lexeme) {
                char[] chars = lexeme.toCharArray();
                int counter = 0;
                for (char aChar : chars) {
                    if (aChar == symbol) {
                        counter++;
                    }
                }
                return counter;
            }
        });
        return components;
    }

    /**
     * Getter for get list with all elements in text.
     * @param textComposite object witch we will be sort.
     * @return ArrayList<TextComponent> with all components in text.
     */
    private ArrayList<TextComponent> getArrayList(final TextComposite
                                                          textComposite) {
        List<TextComponent> textComponents = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>();
        for (TextComponent textComponent: textComponents) {
            components.addAll(textComponent.getComponents());
        }
        ArrayList<TextComponent> list = new ArrayList<>();
        for (TextComponent textComponent: components) {
            list.addAll(textComponent.getComponents());
        }
        return list;
    }
}
