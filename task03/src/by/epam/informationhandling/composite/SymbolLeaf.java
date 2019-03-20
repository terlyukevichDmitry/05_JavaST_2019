package by.epam.informationhandling.composite;

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
    public String toString() {
        String str = "" + symbol;
        return str;
    }
}
