package by.epam.informationhandling.composite;

import java.util.ArrayList;

public class TextComposite implements TextComponent {

    private ArrayList<TextComponent> components = new ArrayList<>();

    private TextElementType textElementType;

    public TextElementType getTextElementType() {
        return textElementType;
    }

    public void setTextElementType(TextElementType textElementType) {
        this.textElementType = textElementType;
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
    public String operation() {
        return toString();
    }

    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            switch (textElementType) {
                case LEXEME: {
                    stringBuilder.append((component.operation() + " "));
                    break;
                }
                case SENTENCE: {
                    stringBuilder.append("\n" + component.operation());
                    break;
                }
                default: stringBuilder.append(component.operation());
            }
        }
        return stringBuilder.toString();
    }
}
