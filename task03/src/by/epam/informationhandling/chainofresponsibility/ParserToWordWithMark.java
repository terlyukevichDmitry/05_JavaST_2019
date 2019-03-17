package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToWordWithMark implements TextParser {

    private static final String WORD_SPLIT_REGEX =  "[a-zA-Z]+";

    private static final String SYMBOL_SPLIT_REGEX = "";

    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(final TextComposite wholeComposite,
                                   final String lexeme) {

        TextComposite compositesOfWord = new TextComposite();
        TextComposite compositesOfMark= new TextComposite();

        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            if (symbol.matches(WORD_SPLIT_REGEX)) {
                textParser = new ParserToSymbol();
                TextComposite textComposite = new TextComposite();
                textComposite = textParser.parseText(textComposite, symbol.trim());
                textComposite.setStr(symbol);
                compositesOfWord.addElement(textComposite);
            } else {
                textParser = new ParserToPunctuationMark();
                TextComposite textComposite = new TextComposite();
                textComposite = textParser.parseText(textComposite, symbol.trim());
                textComposite.setStr(symbol);
                compositesOfMark.addElement(textComposite);
            }
        }
        wholeComposite.addElement(compositesOfWord);
        wholeComposite.addElement(compositesOfMark);
        return wholeComposite;
    }
}
