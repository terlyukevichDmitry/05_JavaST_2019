package by.epam.informationhandling.entity;

public class SymbolComponent implements TextComponent {

    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String operation() {
        return null;
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
        return "SymbolComponent{" + "symbol=" + symbol + '}';
    }
}
