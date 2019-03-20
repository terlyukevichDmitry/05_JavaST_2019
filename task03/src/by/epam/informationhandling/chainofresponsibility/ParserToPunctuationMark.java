package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.SymbolComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToPunctuationMark implements TextParser {
    @Override
    public TextComposite parseText(TextComposite compositeMark, String symbol, TextElementType textElementType) {
        SymbolComponent symbolComponent = new SymbolComponent();
        symbolComponent.setSymbol(symbol.charAt(0));
        compositeMark.addElement(symbolComponent);
        return compositeMark;
    }
}
