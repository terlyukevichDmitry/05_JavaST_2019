package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.SymbolComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToSymbol implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeSymbol,
                                   String lexeme, TextElementType textElementType) {
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            SymbolComponent symbolComponent = new SymbolComponent();
            symbolComponent.setSymbol(symbol.charAt(0));
            compositeSymbol.addElement(symbolComponent);
        }
        return compositeSymbol;
    }
}
