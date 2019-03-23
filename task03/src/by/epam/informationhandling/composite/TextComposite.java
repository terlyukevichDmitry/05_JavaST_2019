package by.epam.informationhandling.composite;

import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TextComposite implements TextComponent, Cloneable {

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

    public void addElement(TextComponent component) {
        components.add(component);
    }

    @Override
    public ArrayList<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void setComponents(ArrayList<TextComponent> components) {
        this.components = components;
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
                case WORD: {
                    stringBuilder.append(" " + (component.operation()));
                    break;
                }
                case EXPRESSION: {
                    PolishNotationCreator polishNotationCreator = new PolishNotationCreator();
                    try {
                        ExpressionCalculator calculator =
                                new ExpressionCalculator(
                                        polishNotationCreator.polishCreating(
                                                component.operation()));
                        stringBuilder.append(" " + calculator.calculate());

                    } catch (NullDataException e) {
                        LOGGER.error(
                                "We have null object in expression!", e);
                    }

                    break;
                }
                case PUNCTUATION_MARK: {
                    stringBuilder.append((component.operation()));
                    break;
                }
                case TEXT: {
                    stringBuilder.append("    " + (component.operation() + "\n"));
                    break;
                }
                default: stringBuilder.append(component.operation());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
