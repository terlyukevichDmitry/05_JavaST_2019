package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.SymbolLeaf;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;

public class ParserToPunctuationMark implements TextParser {
    @Override
    public TextComposite parseText(TextComposite compositeMark, String symbol, TextElementType textElementType) {
        SymbolLeaf symbolComponent = new SymbolLeaf();
        symbolComponent.setSymbol(symbol.charAt(0));
        compositeMark.addElement(symbolComponent);
        return compositeMark;
    }
}
