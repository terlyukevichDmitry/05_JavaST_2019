package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this class we use for parse different state text.
 * For creating tree;
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public abstract class AbstractParser {

    /**
     * Logger for recording a program state.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(AbstractParser.class);

    /**
     * We use this method for parse text on different state.
     * It's will be Paragraph, Sentence, Lexeme, Word, Expression
     * and Punctuation mark.
     * @param string text state.
     * @param regex regular expression for parse text.
     * @param textParser parse level.
     * @param wholeText entity object.
     * @param textElementType type different state.
     * @return entity object.
     * @throws IncorrectDataException for checking exception moments.
     * It will be incorrect data(string or object).
     */
    public TextComposite parse(final String string,
                               final String regex,
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

        if (textParser instanceof ParserToSymbol) {
            solving(textElementType, wholeText, textParser, string);
        } else {
            if (textElementType == TextElementType.SENTENCE) {
                solvingSentence(string, regex, textParser, wholeText,
                        textElementType);
            } else {
                for (String str : string.split(regex)) {
                    solving(textElementType, wholeText, textParser, str);
                }
            }
        }
        return wholeText;
    }

    /**
     * In this method we are solving our task to create tree.
     * @param textElementType type different state.
     * @param wholeText entity object.
     * @param textParser parse level.
     * @param string text state.
     * @throws IncorrectDataException for checking exception moments.
     * It will be incorrect data(string or object).
     */
    private void solving(final TextElementType textElementType,
                    final TextComposite wholeText,
                    final TextParser textParser,
                    final String string) throws IncorrectDataException {
        TextComposite textComposite = new TextComposite();
        textComposite.setTextElementType(textElementType);
        wholeText.addElement(textComposite);
        textParser.parseText(textComposite, string.trim(),
                textElementType);
    }

    /**
     * Method for parse sentence of the different punctuation marks.
     * @param string sentence.
     * @param regex for parse sentence on lexeme.
     * @param textParser type of parser.
     * @param wholeText entity.
     * @param textElementType type in text.
     * @throws IncorrectDataException for checking exception moments.
     */
    private void solvingSentence(final String string,
                                 final String regex,
                                 final TextParser textParser,
                                 final TextComposite wholeText,
                                 final TextElementType textElementType)
            throws IncorrectDataException {
        String m = "";
        Pattern patternSentence = Pattern.compile(regex);
        Matcher matcher = patternSentence.matcher(string);
        if (matcher.find()) {
            do {
                m = matcher.group(0);
                TextComposite textComposite = new TextComposite();
                textComposite.setTextElementType(textElementType);
                wholeText.addElement(textComposite);
                textParser.parseText(textComposite, m.trim(),
                        textElementType);
            } while (matcher.find());
        }
    }
}
