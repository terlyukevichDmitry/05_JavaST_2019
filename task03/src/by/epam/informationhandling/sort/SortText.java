package by.epam.informationhandling.sort;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortText{
    public ArrayList<TextComponent> sortingData(final TextComposite textComposite,
                            final char symbol) {

        ArrayList<TextComponent> components = getArrayList(textComposite);
        components.sort(new Comparator<>() {
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
        return components;
    }

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
