package by.epam.informationhandling.sort;

import by.epam.informationhandling.composite.TextComponent;
import by.epam.informationhandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortText implements SortComparator {
    @Override
    public void sortingData(TextComposite textComposite) {
        List<TextComponent> textComponents = textComposite.getComponents();
        ArrayList<TextComponent> components = new ArrayList<>();
        for (TextComponent textComponent: textComponents) {
            components.addAll(textComponent.getComponents());
        }
        ArrayList<TextComponent> textComponents1 = new ArrayList<>();
        for (TextComponent textComponent: components) {
            textComponents1.addAll(textComponent.getComponents());
        }

        char symbol = 't';
        textComponents1.sort(new Comparator<>() {
            @Override
            public int compare(TextComponent a, TextComponent b) {
                if (checkSymbol(symbol, a.toString()) - checkSymbol(symbol, b.toString()) == 0) {
                    List<TextComponent> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.sort(Comparator.comparing(Object::toString));
                    return 0;
                } else {
                    return Integer.signum(checkSymbol(symbol, a.toString()) - checkSymbol(symbol, b.toString()));
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
        System.out.println(textComponents1);
    }

}
