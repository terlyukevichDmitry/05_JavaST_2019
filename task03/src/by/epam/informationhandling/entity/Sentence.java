package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {
    private List<String> sentences = new ArrayList<>();

    public Sentence(List<String> sentences) {
        this.sentences = sentences;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(sentences, sentence.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentences=" + sentences +
                '}';
    }
}
