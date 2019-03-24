package by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * An public class for sorting elements of text.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SortParagraphBySentence implements SortComparator {
    /**
     * Method for sorting by number of sentence in paragraph.
     * @param textComposite object witch we will be sort.
     */
    @Override
    public void sortingData(final TextComposite textComposite) {
        List<TextComponent> paragraph = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>(paragraph);
        components.sort(Comparator.comparingInt(
                ob -> ob.getComponents().size()));
        textComposite.setComponents(components);
    }
}
