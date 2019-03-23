package by.epam.informationhandling.entity;

import java.util.ArrayList;

/**
 * Interface for text component and creating tree with text elements.
 */
public interface TextComponent {
    /**
     * Method for get string.(toString()).
     * @return string.
     */
    String operation();
    /**
     * Method for get component in composite list.
     * @param index number component.
     * @return component.
     */
    TextComponent getChild(int index);
    /**
     * Method for remove component.
     * @param component for remove.
     */
    void remove(TextComponent component);
    /**
     * Add component in composite list.
     * @param component for add in list.
     */
    void addElement(TextComponent component);
    /**
     * Getter for get all components in composite object.
     * @return list with components.
     */
    ArrayList<TextComponent> getComponents();
    /**
     * Setter for set components in list.
     * @param components for set list with new components.
     */
    void setComponents(ArrayList<TextComponent> components);
}
