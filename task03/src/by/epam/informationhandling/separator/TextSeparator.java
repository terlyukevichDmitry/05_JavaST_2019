package by.epam.informationhandling.separator;

import by.epam.informationhandling.chainofresponsibility.ParserToAllText;
import by.epam.informationhandling.chainofresponsibility.TextParser;
import by.epam.informationhandling.action.CloneComposite;
import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.creator.StringCreator;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;
import by.epam.informationhandling.exception.MissingWayFileException;
import by.epam.informationhandling.sort.SortParagraphBySentence;

public class TextSeparator {

    public void separatingText(final String file)
            throws MissingWayFileException, IncorrectDataException,
            CloneNotSupportedException {
        StringCreator stringCreator = new StringCreator();
        String string = stringCreator.creatingString(file);

        TextComposite textComposite = creatingTree(string);
        System.out.println(textComposite);
        CloneComposite cloneObject = new CloneComposite();
        TextComposite composite = cloneObject.cloningComposite(textComposite);
        SortParagraphBySentence sotr = new SortParagraphBySentence();
        sotr.sortingData(composite);
        System.out.println(composite);
//        SortWordInSentence sortWordInSentence = new SortWordInSentence();
//        sortWordInSentence.sortingData(composite);
//        System.out.println(composite);

    }

    public TextComposite creatingTree(final String string)
            throws IncorrectDataException {
        TextComposite composite = new TextComposite();
        TextParser textParser = new ParserToAllText();
        composite = textParser.parseText(composite, string, TextElementType.TEXT);
        return composite;
    }
}
