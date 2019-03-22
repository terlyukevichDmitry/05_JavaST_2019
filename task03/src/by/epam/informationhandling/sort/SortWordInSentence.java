package by.epam.informationhandling.sort;

import by.epam.informationhandling.composite.TextComponent;
import by.epam.informationhandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SortWordInSentence implements Sort {
    @Override
    public void sortingData(TextComposite textComposite) {
//        List<TextComponent> list = textComposite.getChild(0).getComponents();
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = 0; j < list.get(i).getComponents().size() - 1; j++) {
//                ArrayList<TextComponent> arrayList = list.get(i).getChild(j).getComponents();
//                boolean isSorted = false;
//                while (!isSorted) {
//                    isSorted = true;
//                    for (int k = 0; k < arrayList.size() - 1; k++) {
//                        if (String.valueOf(arrayList.get(k)).trim().length() < String.valueOf(arrayList.get(k + 1)).trim().length()) {
//                            isSorted = false;
//                            ArrayList<TextComponent> buf = arrayList.get(k).getComponents();
//                            arrayList.get(k).setComponents(arrayList.get(k + 1).getComponents());
//                            arrayList.get(k + 1).setComponents(buf);
//                        }
//                    }
//                }
//                list.get(i).getChild(j).setComponents(arrayList);
//            }
//        }



    }
}
