package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToAllText;
import by.epam.informationhandling.chainofresponsibility.TextParser;
import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.creator.StringCreator;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;

import java.util.ArrayList;

public class TextSeparator {

    public void separatingText(final String file)
            throws MissingWayFileException, IncorrectDataException {
        StringCreator stringCreator = new StringCreator();
        String string = stringCreator.creatingString(file);

        TextComposite textComposite = creatingTree(string);
        ArrayList<TextComponent> components = textComposite.getComponents();
        System.out.println(components);
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
