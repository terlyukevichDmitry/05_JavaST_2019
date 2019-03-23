package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.SymbolLeaf;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

/**
 * This class we use for parse text to symbol element.
 *
 *
 * @author Dmitry Terlyukevish
 *
 * @version 1.0
 */
public class ParserToSymbol implements TextParser {
    /**
     * Regular expression for parse text on lexeme.
     */
    private static final String SYMBOL_SPLIT_REGEX = "";

    /**
     * {@inheritDoc}
     * @param compositeSymbol entity object.
     * @param lexeme string for parse.
     * @param textElementType type in text.
     * @return entity with symbols.
     */
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
