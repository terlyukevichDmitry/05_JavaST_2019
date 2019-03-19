package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToLexeme extends AbstractParser implements TextParser {

    private static final String LEXEME_SPLIT_REGEX = "[\\s\\n]+";

    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?a-zA-Z]+";

    private static final String EXPRESSION_SPLIT_REGEX = "[^a-zA-Z]+";

    @Override
    public TextComposite parseText(TextComposite wholeLexeme, String sentence,
                                   TextElementType textElementType) {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark= new TextComposite();
        TextComposite compositesOfExpression = new TextComposite();
        boolean checkerOne = false;
        boolean checkerTwo = false;
        boolean checkerThree = false;

        ParserToLexeme parserToLexeme = new ParserToLexeme();

        for (String lexeme : sentence.split(LEXEME_SPLIT_REGEX)) {
            if (lexeme.matches(WORD_SPLIT_REGEX)) {
                compositesOfWord.setTextElementType(TextElementType.WORD);
                parserToLexeme.parse(lexeme,
                        WORD_SPLIT_REGEX, new ParserToSymbol(), compositesOfWord,
                        TextElementType.SYMBOL);
                checkerOne = true;
            } else if (lexeme.matches(EXPRESSION_SPLIT_REGEX)) {
//                textParser = new ParserToExpression();
                compositesOfExpression.setTextElementType(TextElementType.EXPRESSION);
                parserToLexeme.parse(lexeme,
                        WORD_SPLIT_REGEX, new ParserToSymbol(), compositesOfWord,
                        TextElementType.SYMBOL);
                checkerTwo = true;
            } else {
                compositesOfMark.setTextElementType(TextElementType.WORDWITHMARK);
                 parserToLexeme.parse(lexeme,
                        "", new ParserToWordWithMark(), compositesOfMark,
                        TextElementType.WORDWITHMARK);
                checkerThree = true;
            }
        }

        if (checkerOne) {
            wholeLexeme.addElement(compositesOfWord);
        }
        if (checkerTwo) {
            wholeLexeme.addElement(compositesOfExpression);
        }
        if (checkerThree) {
            wholeLexeme.addElement(compositesOfMark);
        }

        return wholeLexeme;
    }
}
