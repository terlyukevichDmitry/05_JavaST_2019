package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToSentence extends AbstractParser implements TextParser{

    private static final String SENTENCE_SPLIT_REGEX = ("[.!?]\\s*");

    @Override
    public TextComposite parseText(TextComposite wholeSentence,
                                   String paragraph,
                                   TextElementType textElementType)
            throws IncorrectDataException {
        ParserToSentence parserToSentence = new ParserToSentence();
        parserToSentence.parse(paragraph, SENTENCE_SPLIT_REGEX,
                new ParserToLexeme(), wholeSentence, TextElementType.LEXEME);
        return wholeSentence;
    }
}
