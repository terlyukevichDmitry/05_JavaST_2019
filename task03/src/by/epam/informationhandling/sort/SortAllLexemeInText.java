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
public class SortAllLexemeInText {
    /**
     * Method for sorting word in all text by one symbol or by alphabetically.
     * @param textComposite object witch we will be sort.
     * @param symbol for sorting word.
     * @return sorted ArrayList<TextComponent> with all components in text.
     */
    public ArrayList<TextComponent> sortingData(
            final TextComposite textComposite, final char symbol) {
        ArrayList<TextComponent> components = getArrayList(textComposite);

        components.sort(Comparator.comparing(ob -> ob.toString().chars().filter(
                s -> s == symbol).count()).reversed().thenComparing(
                        Object::toString));
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
