package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.SymbolLeaf;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;

public class ParserToSymbol implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeSymbol,
                                   String lexeme, TextElementType textElementType) {
        TextComposite textComposite = new TextComposite();
        for (String symbol : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            SymbolLeaf symbolComponent = new SymbolLeaf();
            textComposite.setTextElementType(TextElementType.SYMBOL);
            symbolComponent.setSymbol(symbol.charAt(0));
            textComposite.addElement(symbolComponent);
        }
        compositeSymbol.addElement(textComposite);
        compositeSymbol.setTextElementType(textElementType);
        return compositeSymbol;
    }
}
