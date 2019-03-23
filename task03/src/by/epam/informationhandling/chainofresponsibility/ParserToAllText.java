package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * This class we use for parse text.
 * it's start method for parse text.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToAllText extends AbstractParser implements TextParser {

    /**
     * Start parse text to symbol.
     * {@inheritDoc}
     * @param wholeComposite our main entity.
     * @param string all text.
     * @param textElementType type in text.
     * @return entity object.
     * @throws IncorrectDataException for checking exception moments.
     */
    @Override
    public TextComposite parseText(final TextComposite wholeComposite,
                                   final String string,
                                   final TextElementType textElementType)
            throws IncorrectDataException {
        wholeComposite.setTextElementType(textElementType);
        new ParserToParagraph().parseText(wholeComposite, string,
                textElementType);
        return wholeComposite;
    }
}
