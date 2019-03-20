package by.epam.informationhandling.composite;

import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TextComposite implements TextComponent {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(TextComposite.class);

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
                case EXPRESSION: {
                    Context context = new Context();
                    try {
                        stringBuilder.append(context.evaluate(component.operation().toString()));

                    } catch (NullDataException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case SENTENCE: {
                    stringBuilder.append("\n" + component.operation());
                    break;
                }
                case PARAGRAPH: {
                    stringBuilder.append("    " + component.operation() + "\n");

                    break;
                }
                default: stringBuilder.append(component.operation());
            }
        }
        return stringBuilder.toString();
    }
}
