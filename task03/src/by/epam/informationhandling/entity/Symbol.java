package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Symbol {
    private List<String> symbols = new ArrayList<>();

    public Symbol(List<String> symbols) {
        this.symbols = symbols;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(symbols, symbol.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbols);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbols=" + symbols +
                '}';
    }
}
