package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToPunctuationMark implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public TextComposite parseText(TextComposite compositeMark, String symbol) {
        for (String mark : symbol.split(SYMBOL_SPLIT_REGEX)) {
            TextComposite textComposite = new TextComposite();
            textComposite.setStr(mark);
            compositeMark.addElement(textComposite);
        }
        return compositeMark;
    }
}
