package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.TextComposite;

public class ParserToLexeme implements TextParser {
    @Override
    public TextComposite getPars(TextComposite composite,
                                 String string) {
        System.out.println("ParserToLexeme Hello!");
        return composite;
    }
}
