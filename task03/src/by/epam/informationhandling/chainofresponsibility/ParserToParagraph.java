package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * This class we use for parse text.
 * it's class for parse text on sentence.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToParagraph extends AbstractParser implements TextParser {
    /**
     * Regular expression for parse text on paragraph.
     */
    private static final String PARAGRAPH_SPLIT_REGEX =
            "(?m)(?!\\A)(?=^\\s{4})";

    /**
     * Method for parse paragraph on sentence.
     * {@inheritDoc}
     * @param wholeText entity.
     * @param string text.
     * @param textElementType type text.
     * @return entity object.
     * @throws IncorrectDataException for checking exception moments.
     */
    @Override
    public TextComposite parseText(final TextComposite wholeText,
                                   final String string,
                                   final TextElementType textElementType)
            throws IncorrectDataException {
        new ParserToParagraph().parse(string, PARAGRAPH_SPLIT_REGEX,
                new ParserToSentence(), wholeText, TextElementType.PARAGRAPH);
        return wholeText;
    }
}
