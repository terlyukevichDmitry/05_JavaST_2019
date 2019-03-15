package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComponent;
import by.epam.informationhandling.entity.TextComposite;
import by.epam.informationhandling.entity.Leaf;

import java.util.ArrayList;

public class ParserToParagraph implements TextParser {

    private static final String PARAGRAPH_SPLIT_REGEX =
            "(?m)(?!\\A)(?=^\\s{4})";
    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite wholeText,
                                   String string) {
        for (String paragraph : string.split(PARAGRAPH_SPLIT_REGEX)) {
            textParser = new ParserToSentence();
            TextComposite compositeHelper = new TextComposite();
            compositeHelper.addElement(new Leaf(paragraph.trim()));
            TextComposite textComposite =
                    textParser.parseText(compositeHelper, paragraph.trim());
            wholeText.addElement(textComposite);
        }
        return wholeText;
    }
}
