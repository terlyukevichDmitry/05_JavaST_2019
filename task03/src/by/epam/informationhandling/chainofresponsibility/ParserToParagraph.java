package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToParagraph implements TextParser {

    private static final String PARAGRAPH_SPLIT_REGEX =
            "(?m)(?!\\A)(?=^\\s{4})";
    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite wholeText,
                                   String string) {
        textParser = new ParserToSentence();
        for (String paragraph : string.split(PARAGRAPH_SPLIT_REGEX)) {
            TextComposite textComposite = new TextComposite();
            textComposite = textParser.parseText(textComposite, paragraph.trim());
            textComposite.setStr(paragraph);
            wholeText.addElement(textComposite);
        }
        return wholeText;
    }
}
