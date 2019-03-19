package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.TextElementType;

public abstract class AbstractParser {
    public TextComposite parse(final String string,
                               final String SPLIT_REGEX,
                               final TextParser textParser,
                               final TextComposite wholeText,
                               final TextElementType textElementType) {
        if (textParser instanceof ParserToWordWithMark
                || textParser instanceof ParserToSymbol
                || textParser instanceof ParserToExpression) {
            TextComposite compositeHelper = new TextComposite();
            compositeHelper.setTextElementType(textElementType);
            textParser.parseText(compositeHelper,
                    string.trim(), textElementType);
            wholeText.addElement(compositeHelper);
        } else {
            for (String str : string.split(SPLIT_REGEX)) {
                TextComposite textComposite = new TextComposite();
                textComposite.setTextElementType(textElementType);
                wholeText.addElement(textComposite);
                textParser.parseText(textComposite, str.trim(), textElementType);
            }
        }
        return wholeText;
    }
}
