package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.composite.TextComposite;
import by.epam.informationhandling.composite.TextElementType;
import by.epam.informationhandling.exception.IncorrectDataException;

public class ParserToAllText extends AbstractParser implements TextParser {

    @Override
    public TextComposite parseText(TextComposite wholeComposite, String string,
                                   TextElementType textElementType) throws IncorrectDataException {
        TextParser textParser = new ParserToParagraph();
        wholeComposite.setTextElementType(textElementType);
        textParser.parseText(wholeComposite, string, textElementType);
        return wholeComposite;
    }
}
