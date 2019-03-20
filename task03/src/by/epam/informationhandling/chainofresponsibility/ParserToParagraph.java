package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToParagraph extends AbstractParser implements TextParser {

    private static final String PARAGRAPH_SPLIT_REGEX =
            "(?m)(?!\\A)(?=^\\s{4})";
    @Override
    public TextComposite parseText(TextComposite wholeText, String string,
                                   TextElementType textElementType)
            throws IncorrectDataException {
        ParserToParagraph parserToParagraph = new ParserToParagraph();
        parserToParagraph.parse(string, PARAGRAPH_SPLIT_REGEX,
                new ParserToSentence(), wholeText, TextElementType.SENTENCE);
        return wholeText;
    }
}
