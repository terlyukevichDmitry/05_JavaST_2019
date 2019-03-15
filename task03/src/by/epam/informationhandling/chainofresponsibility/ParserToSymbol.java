package by.epam.informationhandling.chainofresponsibility;

import by.epam.informationhandling.entity.Leaf;
import by.epam.informationhandling.entity.TextComposite;

public class ParserToSymbol implements TextParser {

    private static final String SYMBOL_SPLIT_REGEX = ".{1}";

    @Override
    public TextComposite parseText(TextComposite composite,
                                   String lexeme) {
        System.out.println("ParserToParagraph Hello!!!");
        for (String paragraph : lexeme.split(SYMBOL_SPLIT_REGEX)) {
            composite.addElement( new Leaf(paragraph));
        }
        return composite;
    }
}
