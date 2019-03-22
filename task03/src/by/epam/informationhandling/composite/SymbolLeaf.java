package by.epam.informationhandling.composite;

import java.util.ArrayList;

public class SymbolLeaf implements TextComponent {

    private char symbol;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String operation() {
        return toString();
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addElement(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ArrayList<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setComponents(ArrayList<TextComponent> components) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        String str = "" + symbol;
        return str;
    }
}
