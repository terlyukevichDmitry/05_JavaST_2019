package by.epam.informationhandling.entity;

import by.epam.informationhandling.action.PolishNotationCreator;
import by.epam.informationhandling.exception.NullDataException;
import by.epam.informationhandling.interpreter.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * This class we use for storage text element(symbol).
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class TextComposite implements TextComponent {
    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(TextComposite.class);
    /**
     * Collection for storage text components.
     */
    private ArrayList<TextComponent> components = new ArrayList<>();
    /**
     * ENUM type in text.
     */
    private TextElementType textElementType = null;
    /**
     * Getter for get element type in text.
     * @return enum element.
     */
    public TextElementType getTextElementType() {
        return textElementType;
    }
    /**
     * Setter for set enum type in text.
     * @param textElementTypeT element type in text.
     */
    public void setTextElementType(final TextElementType textElementTypeT) {
        this.textElementType = textElementTypeT;
    }
    /**
     * Add element in composite.
     * @param component for add in collection with components.
     */
    public void addElement(final TextComponent component) {
        components.add(component);
    }

    /**
     * Get child collection element.
     * @param index child position.
     * @return component of collection with different components.
     */
    public TextComponent getChild(final int index) {
        return components.get(index);
    }

    /**
     * Method for remove element in collection with component.
     * @param componentT for remove.
     */
    public void remove(final TextComponent componentT) {
        components.remove(componentT);
    }

    /**
     * {@inheritDoc}
     * @return collection with components.
     */
    @Override
    public ArrayList<TextComponent> getComponents() {
        return components;
    }

    /**
     * {@inheritDoc}
     * Set collection in composite collection.
     * @param componentsT component collection.
     */
    @Override
    public void setComponents(final ArrayList<TextComponent> componentsT) {
        this.components = componentsT;
    }

    /**
     * {@inheritDoc}
     * Operation for collect text.
     * @return string - text element.
     */
    @Override
    public String operation() {
        return toString();
    }

    /**
     * {@inheritDoc}
     * @return string with text element.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            switch (textElementType) {
                case WORD:
                    stringBuilder.append(" ").append(component.operation());
                    break;
                case EXPRESSION:
                    PolishNotationCreator polishNotationCreator =
                            new PolishNotationCreator();
                    try {
                        ExpressionCalculator calculator =
                                new ExpressionCalculator(
                                        polishNotationCreator.polishCreating(
                                                component.operation()));
                        stringBuilder.append(" ").append(
                                calculator.calculate());

                    } catch (NullDataException e) {
                        LOGGER.error(
                                "We have null object in expression!", e);
                    }
                    break;
                case PUNCTUATION_MARK:
                    stringBuilder.append((component.operation()));
                    break;
                case TEXT:
                    stringBuilder.append("    ").append(
                            component.operation()).append("\n");
                    break;
                default: stringBuilder.append(component.operation());
            }
        }
        return stringBuilder.toString();
    }
}
