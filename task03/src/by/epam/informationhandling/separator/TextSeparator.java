package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToParagraph;
import by.epam.informationhandling.chainofresponsibility.TextParser;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.creator.StringCreator;
import by.epam.informationhandling.exception.MissingWayFileException;

public class TextSeparator {

    public void separatingText(final String file)
            throws MissingWayFileException {
        StringCreator stringCreator = new StringCreator();
        String string = stringCreator.creatingString(file);

        TextComposite composite = new TextComposite();
        TextParser textParser = new ParserToParagraph();
        composite = textParser.getPars(composite, string);
        System.out.println(composite);

    }
}
