package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class we use for save symbol text element.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class SymbolLeaf implements TextComponent {
    /**
     * For save different symbols.
     */
    private char symbol;
    /**
     * Setter for set symbol.
     * @param symbolT element in text.
     */
    public void setSymbol(final char symbolT) {
        this.symbol = symbolT;
    }
    /**
     * {@inheritDoc}
     * @return string with text element.
     */
    @Override
    public String operation() {
        return toString();
    }
    /**
     * Get child collection element.
     * @param index child position.
     * @return component of collection with different components.
     */
    @Override
    public TextComponent getChild(final int index) {
        throw new UnsupportedOperationException();
    }
    /**
     * Method for remove element in collection with component.
     * @param component for remove.
     */
    @Override
    public void remove(final TextComponent component) {
        throw new UnsupportedOperationException();
    }
    /**
     * Add element in composite.
     * @param component for add in collection with components.
     */
    @Override
    public void addElement(final TextComponent component) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     * @return collection with components.
     */
    @Override
    public ArrayList<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     * Set collection in composite collection.
     * @param components component collection.
     */
    @Override
    public void setComponents(final ArrayList<TextComponent> components) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     * @return string with text element.
     */
    @Override
    public String toString() {
        return "" + symbol;
    }
    /**
     * Equals method for compare objects.
     * @param o our object for compare.
     * @return result, true or false. equal or not.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SymbolLeaf that = (SymbolLeaf) o;
        return symbol == that.symbol;
    }
    /**
     * object hashcode.
     * @return int hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
