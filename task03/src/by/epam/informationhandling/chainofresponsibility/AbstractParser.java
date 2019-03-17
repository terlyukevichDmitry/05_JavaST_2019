package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public abstract class AbstractParser {
    public TextComposite parse(final String string,
                               final String SPLIT_REGEX,
                               final TextParser textParser,
                               final TextComposite wholeText) {
        if (textParser instanceof ParserToWordWithMark
                || textParser instanceof ParserToSymbol
                || textParser instanceof ParserToExpression) {
            TextComposite compositeHelper = new TextComposite();
            compositeHelper = textParser.parseText(compositeHelper,
                    string.trim());
            compositeHelper.setStr(string);
            wholeText.addElement(compositeHelper);
        } else {
            for (String str : string.split(SPLIT_REGEX)) {
                TextComposite textComposite = new TextComposite();
                textComposite = textParser.parseText(textComposite, str.trim());
                textComposite.setStr(str);
                wholeText.addElement(textComposite);
            }
        }
        return wholeText;
    }
}
