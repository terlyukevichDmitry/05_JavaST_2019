package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToSymbol implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeSymbol,
                                   String lexeme) {
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            TextComposite textComposite = new TextComposite();
            textComposite.setStr(symbol);
            compositeSymbol.addElement(textComposite);
        }
        return compositeSymbol;
    }
}
