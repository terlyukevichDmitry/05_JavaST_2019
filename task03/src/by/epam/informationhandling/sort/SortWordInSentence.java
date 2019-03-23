package by.epam.informationhandling.sort;

import by.epam.informationhandling.composite.TextComponent;
import by.epam.informationhandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortWordInSentence implements SortComparator {
    @Override
    public void sortingData(TextComposite textComposite) {
        List<TextComponent> textComponents = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>();
        for (TextComponent textComponent: textComponents) {
            components.addAll(textComponent.getComponents());
        }

        for (TextComponent textComponent: components) {
            ArrayList<TextComponent> lexeme = new ArrayList<>(textComponent.getComponents());
            lexeme.sort(Comparator.comparingInt(o -> o.toString().length()));
            textComponent.setComponents(lexeme);
        }
//
//        for (TextComponent t : components) {
//            System.out.println(t);
//        }
    }
}
