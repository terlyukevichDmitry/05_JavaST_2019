package by.epam.informationhandling.entity;

import java.util.ArrayList;

public class TextComposite implements TextComponent {

    private ArrayList<TextComponent> components = new ArrayList<>();

    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

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
        System.out.println(getStr());
    }

    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        System.out.println("TextComposite{" + "str=" + str + '}');
        return "TextComposite{" + "components=" + components + '}';
    }
}
