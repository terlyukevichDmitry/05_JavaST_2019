package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToSentence implements TextParser {

    private TextParser textParser;
    public void setTextParser(final TextParser textP) {
        this.textParser = textP;
    }

    @Override
    public TextComposite getPars(TextComposite composite, String string) {
        System.out.println("ParserToSentence Hello!!!");
        textParser = new ParserToLexeme();
        textParser.getPars(composite, string);
        return composite;
    }
}
