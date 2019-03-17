package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToPunctuationMark implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeMark, String symbol) {
        TextComposite textComposite = new TextComposite();
        textComposite.setStr(symbol);
        compositeMark.addElement(textComposite);
        return compositeMark;
    }
}
