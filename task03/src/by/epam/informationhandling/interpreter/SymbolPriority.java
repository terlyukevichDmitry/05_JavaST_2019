package by.epam.informationhandling.interpreter;

public class SymbolPriority {

    private int priority;

    private String symbol;

    public SymbolPriority(int priority, String symbol) {
        this.priority = priority;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "SymbolPriority{" + "priority=" + priority
                + ", symbol='" + symbol + '\'' + '}';
    }
}
