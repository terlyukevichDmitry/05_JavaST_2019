package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * This class we use for parse text.
 * it's class for parse sentence on lexeme.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToSentence extends AbstractParser implements TextParser {
    /**
     * Regular expression for parse text on sentence.
     */
    private static final String SENTENCE_SPLIT_REGEX =
            "[^.?!]+?(?:\\.{3}|\\.|!{3}|!|\\?)";
    /**
     * Method for parse paragraph to sentence.
     * {@inheritDoc}
     * @param wholeSentence entity.
     * @param paragraph string with sentence.
     * @param textElementType type in text.
     * @return entity.
     * @throws IncorrectDataException for checking exception moments.
     */
    @Override
    public TextComposite parseText(final TextComposite wholeSentence,
                                   final String paragraph,
                                   final TextElementType textElementType)
            throws IncorrectDataException {
        new ParserToSentence().parse(paragraph, SENTENCE_SPLIT_REGEX,
                new ParserToLexeme(), wholeSentence, TextElementType.SENTENCE);
        return wholeSentence;
    }
}
