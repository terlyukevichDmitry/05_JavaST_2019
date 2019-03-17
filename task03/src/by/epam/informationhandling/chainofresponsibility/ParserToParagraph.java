package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToParagraph extends AbstractParser implements TextParser {

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
        ParserToParagraph parserToParagraph = new ParserToParagraph();
        wholeText = parserToParagraph.parse(string, PARAGRAPH_SPLIT_REGEX,
                textParser, wholeText);
        return wholeText;
    }
}
