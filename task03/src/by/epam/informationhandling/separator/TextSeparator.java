package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToAllText;
import by.epam.informationhandling.chainofresponsibility.TextParser;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class TextSeparator {
    public TextComposite creatingTree(final String string)
            throws IncorrectDataException {
        TextComposite composite = new TextComposite();
        TextParser textParser = new ParserToAllText();
        composite = textParser.parseText(composite, string, TextElementType.TEXT);
        return composite;
    }
}
