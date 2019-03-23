package by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An public class for sorting elements of text.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortWordInSentence implements SortComparator {
    /**
     * Method for sort word in sentence by word length.
     * @param textComposite object witch we will be sort.
     */
    @Override
    public void sortingData(final TextComposite textComposite) {
        List<TextComponent> textComponents = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>();
        for (TextComponent textComponent: textComponents) {
            components.addAll(textComponent.getComponents());
        }

        for (TextComponent textComponent: components) {
            ArrayList<TextComponent> lexeme =
                    new ArrayList<>(textComponent.getComponents());
            lexeme.sort(Comparator.comparingInt(o -> o.toString().length()));
            textComponent.setComponents(lexeme);
        }
    }
}
