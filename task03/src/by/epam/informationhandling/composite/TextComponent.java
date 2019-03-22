package by.epam.informationhandling.composite;

import java.util.ArrayList;

public interface TextComponent {
    String operation();
    TextComponent getChild(int index);
    void remove(TextComponent component);
    void addElement(TextComponent component);
    ArrayList<TextComponent> getComponents();
    int getSize();
    void setComponents(ArrayList<TextComponent> components);
}
