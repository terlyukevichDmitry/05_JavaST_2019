package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.Leaf;
import by.epam.informationhandling.entity.TextComposite;

public class ParserToAllText implements TextParser {

    private TextParser textParser;

    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite parseText(TextComposite composite, String string) {
        textParser = new ParserToParagraph();
        TextComposite textComposite = new TextComposite();
        textComposite.addElement(new Leaf(string));
        TextComposite compositeHelper = new TextComposite();
        textComposite = textParser.parseText(compositeHelper, string);
        composite.addElement(textComposite);
        System.out.println("ParserToAllText = " + composite.getComponents().size());
        return composite;
    }
}
