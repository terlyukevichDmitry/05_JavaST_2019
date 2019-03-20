package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(AbstractParser.class);

    public TextComposite parse(final String string,
                               final String SPLIT_REGEX,
                               final TextParser textParser,
                               final TextComposite wholeText,
                               final TextElementType textElementType)
            throws IncorrectDataException {
        if (string.isEmpty()) {
            LOGGER.error("We have incorrect string!");
            throw new IncorrectDataException("We have incorrect string!!");
        }

        if (textParser == null || wholeText == null
                || textElementType == null) {
            LOGGER.error("We have incorrect object data!");
            throw new IncorrectDataException("We have incorrect object data!!");
        }

        if (textParser instanceof ParserToSymbol
                || textParser instanceof ParserToExpression) {
            solving(textElementType,wholeText, textParser, string);
        } else {
            for (String str : string.split(SPLIT_REGEX)) {
                solving(textElementType,wholeText, textParser, str);
            }
        }
        return wholeText;
    }

    private void solving(final TextElementType textElementType,
                    final TextComposite wholeText,
                    final TextParser textParser,
                    final String string) throws IncorrectDataException {
        //I should add method which will check point in end of sentence!!!!!!!
        TextComposite textComposite = new TextComposite();
        textComposite.setTextElementType(textElementType);
        wholeText.addElement(textComposite);
        textParser.parseText(textComposite, string.trim(),
                textElementType);
    }
}
