package by.epam.informationhandling.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {
    ArrayList<TextComponent> components = new ArrayList<>();

    public ArrayList<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void addElement(TextComponent component) {
        System.out.println("TextComposite -> Adding component!");
        components.add(component);
    }

    @Override
    public TextComponent getChild(int index) {
        System.out.println("TextComposite -> Getting component");
        return components.get(index);
    }

    @Override
    public void operation() {
        System.out.println("TextComposite -> Call children operations");
        for (int i = 0; i < components.size(); i++) {
            components.get(i).operation();
        }
    }

    @Override
    public void remove(TextComponent component) {
        System.out.println("TextComposite -> Removing component");
        components.remove(component);
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "components=" + components +
                '}';
    }
}
