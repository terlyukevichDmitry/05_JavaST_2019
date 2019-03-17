package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToWordWithMark extends AbstractParser implements TextParser {

    private static final String WORD_SPLIT_REGEX = "[[()'\"-]?a-zA-Z]+";

    private static final String SYMBOL_SPLIT_REGEX = "";

    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(final TextComposite wholeComposite,
                                   final String lexeme) {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark = new TextComposite();
        ParserToWordWithMark parserToWordWithMark = new ParserToWordWithMark();
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            if (symbol.matches(WORD_SPLIT_REGEX)) {
                textParser = new ParserToSymbol();
                compositesOfWord = parserToWordWithMark.parse(symbol,
                        "", textParser, compositesOfWord);
            } else {
                textParser = new ParserToPunctuationMark();
                compositesOfMark = parserToWordWithMark.parse(symbol,
                        "", textParser, compositesOfMark);
            }
        }
        wholeComposite.addElement(compositesOfWord);
        wholeComposite.addElement(compositesOfMark);
        return wholeComposite;
    }
}
