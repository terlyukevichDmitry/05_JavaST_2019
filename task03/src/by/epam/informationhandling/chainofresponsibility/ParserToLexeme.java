package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToLexeme extends AbstractParser implements TextParser {

    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]+";

    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?^A-Za-z0-9]+";

    private static final String EXPRESSION_SPLIT_REGEX = "[^a-zA-Z]+";

    @Override
    public TextComposite parseText(TextComposite wholeLexeme, String sentence,
                                   TextElementType textElementType)
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
                            && lexeme.charAt(lexeme.length() - 3) == '.') {
                        String dopString = "" + removeForWord(lexeme, lexeme.length() - 3);
                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse(dopString, WORD_SPLIT_REGEX,
                                new ParserToSymbol(), wholeLexeme,
                                TextElementType.WORD);

                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse("" + removeThreePoints(lexeme,lexeme.length() - 3), "",
                                new ParserToPunctuationMark(), wholeLexeme,
                                TextElementType.THREE_POINTS);
                    } else {
                        String dopString = "" + removeCharAt(lexeme, lexeme.length() - 1);
                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse(dopString, WORD_SPLIT_REGEX,
                                new ParserToSymbol(), wholeLexeme,
                                TextElementType.WORD);

                        wholeLexeme.setTextElementType(textElementType);
                        parserToLexeme.parse("" + lexeme.charAt(lexeme.length() - 1), "",
                                new ParserToPunctuationMark(), wholeLexeme,
                                TextElementType.PUNCTUATION_MARK);
                    }
            }
        }

        return wholeLexeme;
    }

    private String removeForWord(final String string, final int pos) {
        return string.substring(0, pos);
    }

    private String removeThreePoints(final String string, final int pos) {
        return string.substring(pos);
    }

    private String removeCharAt(final String string, final int pos) {
        return string.substring(0, pos) + string.substring(pos + 1);
    }
}
