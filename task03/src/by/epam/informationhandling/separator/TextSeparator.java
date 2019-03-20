package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToAllText;
import by.epam.informationhandling.chainofresponsibility.TextParser;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.creator.StringCreator;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;

public class TextSeparator {

    public void separatingText(final String file)
            throws MissingWayFileException, IncorrectDataException {
        StringCreator stringCreator = new StringCreator();
        String string = stringCreator.creatingString(file);

        TextComposite textComposite = creatingTree(string);
        System.out.println(textComposite);
    }

    public TextComposite creatingTree(final String string)
            throws IncorrectDataException {
        TextComposite composite = new TextComposite();
        composite.setTextElementType(TextElementType.TEXT);
        TextParser textParser = new ParserToAllText();
        composite = textParser.parseText(composite, string, TextElementType.PARAGRAPH);
        return composite;
    }
}
