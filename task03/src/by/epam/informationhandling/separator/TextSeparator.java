package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToAllText;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * An public class for separating and creating tree witch consists of text
 * element.
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class TextSeparator {
    /**
     * Method for start creating tree.
     * @param string our text.
     * @return composite with text element(paragraph, sentence, lexeme and ...)
     * @throws IncorrectDataException for checking exception moments.
     */
    public TextComposite creatingTree(final String string)
            throws IncorrectDataException {
        TextComposite composite = new TextComposite();
        composite = new ParserToAllText().parseText(composite, string,
                TextElementType.TEXT);
        return composite;
    }
}
