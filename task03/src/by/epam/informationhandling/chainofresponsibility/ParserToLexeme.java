package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToLexeme extends AbstractParser implements TextParser {

    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]+";

    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?a-zA-Z]+";

    private static final String EXPRESSION_SPLIT_REGEX = "[^a-zA-Z]+";

    @Override
    public TextComposite parseText(TextComposite wholeLexeme, String sentence,
                                   TextElementType textElementType)
            throws IncorrectDataException {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark= new TextComposite();
        TextComposite compositesOfExpression = new TextComposite();

        ParserToLexeme parserToLexeme = new ParserToLexeme();
        for (String lexeme : sentence.split(LEXEME_SPLIT_REGEX)) {
            if (lexeme.matches(WORD_SPLIT_REGEX)) {
                compositesOfWord.setTextElementType(TextElementType.WORD);
                parserToLexeme.parse(lexeme, WORD_SPLIT_REGEX,
                        new ParserToSymbol(), compositesOfWord,
                        TextElementType.SYMBOL);
            } else if (lexeme.matches(EXPRESSION_SPLIT_REGEX)) {
                compositesOfExpression.setTextElementType(
                        TextElementType.EXPRESSION);
                parserToLexeme.parse(lexeme, EXPRESSION_SPLIT_REGEX,
                        new ParserToSymbol(), compositesOfExpression,
                        TextElementType.SYMBOL);
            } else {
                compositesOfMark.setTextElementType(
                        TextElementType.WORD_WITH_MARK);
                parserToLexeme.parse(lexeme, "",
                         new ParserToWordWithMark(),compositesOfMark,
                        TextElementType.WORD_WITH_MARK);
            }
        }

        if (!compositesOfWord.getComponents().isEmpty()) {
            wholeLexeme.addElement(compositesOfWord);
        }
        if (!compositesOfExpression.getComponents().isEmpty()) {
            wholeLexeme.addElement(compositesOfExpression);
        }
        if (!compositesOfMark.getComponents().isEmpty()) {
            wholeLexeme.addElement(compositesOfMark);
        }

        return wholeLexeme;
    }
}
