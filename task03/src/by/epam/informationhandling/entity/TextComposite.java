package by.epam.informationhandling.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {

    private ArrayList<TextComponent> components = new ArrayList<>();


    public ArrayList<TextComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<TextComponent> components) {
        this.components = components;
    }

    public void addElement(TextComponent component) {
        components.add(component);
    }

    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public void operation() {
        for (int i = 0; i < components.size(); i++) {
            components.get(i).operation();
        }
    }

    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        return "TextComposite{" + "components=" + components + '}';
    }
}
