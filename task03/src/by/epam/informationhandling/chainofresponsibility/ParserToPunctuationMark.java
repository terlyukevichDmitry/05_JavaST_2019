package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToPunctuationMark implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeMark, String symbol, TextElementType textElementType) {
        TextComposite textComposite = new TextComposite();
        compositeMark.addElement(textComposite);
        return compositeMark;
    }
}
