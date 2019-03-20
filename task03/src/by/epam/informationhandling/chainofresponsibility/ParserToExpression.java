package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToExpression extends AbstractParser implements  TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite wholeExpression, String lexeme,
                                   TextElementType textElementType)
            throws IncorrectDataException {
        ParserToExpression parserToExpression = new ParserToExpression();
        parserToExpression.parse(lexeme, SYMBOL_SPLIT_REGEX,
                new ParserToSymbol(), wholeExpression, TextElementType.SYMBOL);
        return wholeExpression;
    }
}
