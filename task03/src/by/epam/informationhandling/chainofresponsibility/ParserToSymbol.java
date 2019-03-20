package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.SymbolLeaf;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;

public class ParserToSymbol implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeSymbol,
                                   String lexeme, TextElementType textElementType) {
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            SymbolLeaf symbolComponent = new SymbolLeaf();
            compositeSymbol.setTextElementType(textElementType);
            symbolComponent.setSymbol(symbol.charAt(0));
            compositeSymbol.addElement(symbolComponent);
        }
        return compositeSymbol;
    }
}
