package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private List<String> words = new ArrayList<>();

    public Word(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(words, word.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        return "Word{" + "words=" + words + '}';
    }
}
