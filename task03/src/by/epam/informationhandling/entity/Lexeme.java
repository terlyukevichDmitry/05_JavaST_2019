package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lexeme {
    private List<String> lexemes = new ArrayList<>();

    public Lexeme(List<String> lexemes) {
        this.lexemes = lexemes;
    }

    public List<String> getLexemes() {
        return lexemes;
    }

    public void setLexemes(List<String> lexemes) {
        this.lexemes = lexemes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(lexemes, lexeme.lexemes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexemes);
    }

    @Override
    public String toString() {
        return "Lexeme{" + "lexemes=" + lexemes + '}';
    }
}
