package by.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph {

    private List<String> paragraphs = new ArrayList<>();

    public Paragraph(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(paragraphs, paragraph.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphs);
    }

    @Override
    public String toString() {
        return "Paragraph{" + "paragraphs=" + paragraphs + '}';
    }
}
