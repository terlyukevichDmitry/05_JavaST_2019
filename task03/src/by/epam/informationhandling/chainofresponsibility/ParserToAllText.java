package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public class ParserToAllText extends AbstractParser implements TextParser {

    @Override
    public TextComposite parseText(TextComposite wholeComposite, String string,
                                   TextElementType textElementType) {

        TextParser textParser = new ParserToParagraph();
        TextComposite textComposite = new TextComposite();
        textComposite.setTextElementType(TextElementType.PARAGRAPH);
        textParser.parseText(textComposite, string, TextElementType.PARAGRAPH);
        wholeComposite.addElement(textComposite);

        //System.out.println("ParserToAllText = " + composite.getComponents().size());
        return wholeComposite;
    }


}
