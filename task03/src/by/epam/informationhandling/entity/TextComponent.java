package by.epam.informationhandling.entity;

public interface TextComponent {
    void addElement(TextComponent component);
    TextComponent getChild(int index);
    void operation();
    void remove(TextComponent component);
}
