package by.epam.informationhandling.entity;

public interface TextComponent {
    void operation();
    TextComponent getChild(int index);
    void remove(TextComponent component);
    void addElement(TextComponent component);
}
