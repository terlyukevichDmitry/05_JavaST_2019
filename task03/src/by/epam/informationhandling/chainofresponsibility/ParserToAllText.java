package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToAllText extends AbstractParser implements TextParser {

    @Override
    public TextComposite parseText(TextComposite wholeComposite, String string,
                                   TextElementType textElementType) throws IncorrectDataException {

        TextParser textParser = new ParserToParagraph();
        TextComposite textComposite = new TextComposite();
        textComposite.setTextElementType(textElementType);
        textParser.parseText(textComposite, string, textElementType);
        wholeComposite.addElement(textComposite);
        return wholeComposite;
    }
}
