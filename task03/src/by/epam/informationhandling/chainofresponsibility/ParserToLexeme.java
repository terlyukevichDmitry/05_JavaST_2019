package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

/**
 * This class we use for parse text.
 * it's class for parse text on lexeme, and lexeme on word, expression
 * and punctuation mark.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToLexeme extends AbstractParser implements TextParser {

    /**
     * Regular expression for parse text on lexeme.
     */
    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]+";
    /**
     * Regular expression for parse text on word.
     */
    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?^A-Za-z0-9]+";
    /**
     * Regular expression for parse text on expression.
     */
    private static final String EXPRESSION_SPLIT_REGEX = "[^a-zA-Z]+";
    /**
     * Constant.
     */
    private final int three = 3;
    /**
     * In this method we are parsing sentence on lexeme and lexeme on different
     * text components.
     * {@inheritDoc}
     * @param wholeLexeme entity
     * @param sentence
     * @param textElementType
     * @return
     * @throws IncorrectDataException
     */
    @Override
    public TextComposite parseText(final TextComposite wholeLexeme,
                                   final String sentence,
                                   final TextElementType textElementType)
            throws IncorrectDataException {
        ParserToLexeme parserToLexeme = new ParserToLexeme();
        for (String lexeme : sentence.split(LEXEME_SPLIT_REGEX)) {
            if (lexeme.matches(WORD_SPLIT_REGEX)) {
                wholeLexeme.setTextElementType(textElementType);
                parserToLexeme.parse(lexeme, WORD_SPLIT_REGEX,
                        new ParserToSymbol(), wholeLexeme,
                        TextElementType.WORD);
            } else if (lexeme.matches(EXPRESSION_SPLIT_REGEX)) {
                wholeLexeme.setTextElementType(textElementType);
                parserToLexeme.parse(lexeme, WORD_SPLIT_REGEX,
                        new ParserToSymbol(), wholeLexeme,
                        TextElementType.EXPRESSION);
            } else {
                    if (lexeme.charAt(lexeme.length() - 1) == '.'
                            && lexeme.charAt(lexeme.length() - 2) == '.'
                            && lexeme.charAt(lexeme.length() - three) == '.') {
                        String dopString = "" + removeForWord(lexeme,
                                lexeme.length() - three);
                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse(dopString, WORD_SPLIT_REGEX,
                                new ParserToSymbol(), wholeLexeme,
                                TextElementType.WORD);

                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse("" + removeThreePoints(
                                lexeme, lexeme.length() - three), "",
                                new ParserToPunctuationMark(), wholeLexeme,
                                TextElementType.THREE_POINTS);
                    } else {
                        String dopString = "" + removeCharAt(lexeme,
                                lexeme.length() - 1);
                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse(dopString, WORD_SPLIT_REGEX,
                                new ParserToSymbol(), wholeLexeme,
                                TextElementType.WORD);

                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse("" + lexeme.charAt(
                                lexeme.length() - 1), "",
                                new ParserToPunctuationMark(), wholeLexeme,
                                TextElementType.PUNCTUATION_MARK);
                    }
            }
        }
        return wholeLexeme;
    }

    /**
     * Method for remove word.
     * @param string word with punctuation mark.
     * @param pos position all word.
     * @return only word.
     */
    private String removeForWord(final String string, final int pos) {
        return string.substring(0, pos);
    }
    /**
     * Method for remove punctuation mark.
     * @param string word with punctuation mark.
     * @param pos position all punctuation mark.
     * @return only punctuation mark.
     */
    private String removeThreePoints(final String string, final int pos) {
        return string.substring(pos);
    }
    /**
     * Method for remove word.
     * @param string word with punctuation mark.
     * @param pos position all word.
     * @return only word.
     */
    private String removeCharAt(final String string, final int pos) {
        return string.substring(0, pos) + string.substring(pos + 1);
    }
}
