package by.epam.informationhandling.sort;

import by.epam.informationhandling.composite.TextComponent;
import by.epam.informationhandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SortParagraphBySentence implements Sort {
    @Override
    public void sortingData(TextComposite textComposite) {
                boolean isSorted = false;
//        while(!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < textComposite.getComponents().size() - 1; i++) {
//                if(textComposite.getChild(i).getComponents().size() < textComposite.getChild(i + 1).getComponents().size()){
//                    isSorted = false;
//                    ArrayList<TextComponent> buf = textComposite.getChild(i).getComponents();
//                    textComposite.getChild(i).setComponents(textComposite.getChild(i + 1).getComponents());
//                    textComposite.getChild(i + 1).setComponents(buf);
//                }
//            }
//        }
        List<TextComponent> list = textComposite.getComponents();
        list.sort(Comparator.comparing(TextComponent::getSize));
    }
}
