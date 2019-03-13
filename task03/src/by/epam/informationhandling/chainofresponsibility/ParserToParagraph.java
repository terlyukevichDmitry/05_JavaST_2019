package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.Leaf;

public class ParserToParagraph implements TextParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^\\s{4})";

    private TextParser textParser;
    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite getPars(TextComposite composite,
                                 String string) {
        System.out.println("ParserToParagraph Hello!!!");
        String[] paragraphs = string.split(PARAGRAPH_SPLIT_REGEX);
        Leaf leaf;
        for (String paragraph : paragraphs) {
            leaf = new Leaf("    " + paragraph.trim());
            composite.addElement(leaf);
            textParser = new ParserToSentence();
            textParser.getPars(composite, string);
        }
        return composite;
    }

    public TextComposite parseToParagraph() {
        System.out.println("PARSE TO PARAGRAPH!!!!");
        return null;
    }
}
