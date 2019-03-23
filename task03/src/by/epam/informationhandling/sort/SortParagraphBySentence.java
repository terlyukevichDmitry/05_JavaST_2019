package by.epam.informationhandling.sort;

import by.epam.informationhandling.composite.TextComponent;
import by.epam.informationhandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SortParagraphBySentence implements SortComparator {
    @Override
    public void sortingData(TextComposite textComposite) {
        List<TextComponent> paragraph = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>(paragraph);
        components.sort(Comparator.comparingInt(o -> o.getComponents().size()));
        textComposite.setComponents(components);
    }
}
