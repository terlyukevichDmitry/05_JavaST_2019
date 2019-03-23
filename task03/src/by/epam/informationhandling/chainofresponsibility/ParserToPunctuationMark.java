package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.SymbolLeaf;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

/**
 * This class we use for parse text.
 * it's class for parse text on punctuation mark.
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToPunctuationMark implements TextParser {
    /**
     * Method for add mark element in entity.
     * {@inheritDoc}
     * @param compositeMark type of mark.
     * @param symbol punctuation mark.
     * @param textElementType type symbol in text.
     * @return entity.
     */
    @Override
    public TextComposite parseText(final TextComposite compositeMark,
                                   final String symbol,
                                   final TextElementType textElementType) {
        SymbolLeaf symbolComponent = new SymbolLeaf();
        symbolComponent.setSymbol(symbol.charAt(0));
        compositeMark.addElement(symbolComponent);
        return compositeMark;
    }
}
