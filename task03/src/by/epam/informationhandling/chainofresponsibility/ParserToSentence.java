package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToSentence extends AbstractParser implements TextParser{

    private static final String SENTENCE_SPLIT_REGEX = ("[.!?]\\s*");

    @Override
    public TextComposite parseText(TextComposite wholeSentence,
                                   String paragraph,
                                   TextElementType textElementType) {

        ParserToSentence parserToSentence = new ParserToSentence();
        wholeSentence = parserToSentence.parse(paragraph, SENTENCE_SPLIT_REGEX,
                new ParserToLexeme(), wholeSentence, TextElementType.LEXEME);
        //System.out.println("ParserToSentence = " + wholeSentence.getComponents().size());
        return wholeSentence;
    }
}
