package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToWordWithMark extends AbstractParser implements TextParser {

    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?a-zA-Z]+";

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(final TextComposite wholeComposite,
                                   final String lexeme,
                                   final TextElementType textElementType)
            throws IncorrectDataException {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark = new TextComposite();
        ParserToWordWithMark parserToWordWithMark = new ParserToWordWithMark();
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            if (symbol.matches(WORD_SPLIT_REGEX)) {
                compositesOfWord.setTextElementType(TextElementType.WORD);
                parserToWordWithMark.parse(symbol, "",
                        new ParserToSymbol(), compositesOfWord,
                        TextElementType.SYMBOL);
            } else {
                compositesOfMark.setTextElementType(
                        TextElementType.PUNCTUATION_MARK);
                parserToWordWithMark.parse(symbol, "",
                        new ParserToPunctuationMark(), compositesOfMark,
                        TextElementType.PUNCTUATION_MARK);
            }
        }
        wholeComposite.addElement(compositesOfWord);
        wholeComposite.addElement(compositesOfMark);
        return wholeComposite;
    }
}
