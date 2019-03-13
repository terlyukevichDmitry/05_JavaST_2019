package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PunctuationMark {
    private List<String> punctuationMarks = new ArrayList<>();

    public PunctuationMark(List<String> punctuationMarks) {
        this.punctuationMarks = punctuationMarks;
    }

    public List<String> getPunctuationMarks() {
        return punctuationMarks;
    }

    public void setPunctuationMarks(List<String> punctuationMarks) {
        this.punctuationMarks = punctuationMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return Objects.equals(punctuationMarks, that.punctuationMarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punctuationMarks);
    }

    @Override
    public String toString() {
        return "PunctuationMark{" + "punctuationMarks=" + punctuationMarks
                + '}';
    }
}
